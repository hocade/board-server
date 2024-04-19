package com.board.boardserver.attachment.application.service

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.board.boardserver.attachment.adapter.out.persistence.mapper.AttachmentJpaEntityMapper
import com.board.boardserver.attachment.domain.Attachment
import com.board.boardserver.attachment.port.`in`.usecase.AttachmentUseCase
import com.board.boardserver.attachment.port.out.AttachmentJpaPort
import com.board.boardserver.common.properties.S3Properties
import com.board.boardserver.common.utils.RandomCodeUtils
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

/**
 * @author jinwook.kim
 * @since 4/19/24
 */
@Service
class AttachmentService(
    private val attachmentJpaPort: AttachmentJpaPort,
    private val amazonS3Client: AmazonS3,
    private val s3Properties: S3Properties
) : AttachmentUseCase {

    override fun upload(file: MultipartFile): Attachment {
        // 파일 메타데이터
        val objectMetadata = ObjectMetadata().apply {
            this.contentType = file.contentType
            this.contentLength = file.size
        }

        // 파일 이름 UUID 처리
        val originalFileName = file.originalFilename!!
        val ext = originalFileName.substring(originalFileName.indexOf(".") + 1);
        val uploadFileName = getUUIDFileName(originalFileName, ext)
        val fullPath = getFullPath(uploadFileName)

        // aws 저장
        val putObjectRequest = PutObjectRequest(
            s3Properties.bucketName,
            fullPath,
            file.inputStream,
            objectMetadata,
        )
        amazonS3Client.putObject(putObjectRequest)
        // 데이터 베이스 저장
        val resourceUrl = amazonS3Client.getUrl(s3Properties.bucketName, uploadFileName).toExternalForm()
        return attachmentJpaPort.save(AttachmentJpaEntityMapper.instance.toDomain(ext, uploadFileName, originalFileName, resourceUrl.toString(), fullPath))
    }

    override fun delete(id: Long) {
        val attachment = attachmentJpaPort.findById(id)
        amazonS3Client.deleteObject(s3Properties.bucketName, attachment.fullPath)
        attachmentJpaPort.delete(id)
    }

    fun getFullPath(filaName: String): String {
        return s3Properties.folderPath + "/" + filaName
    }

    fun getUUIDFileName(fileName: String, ext: String): String {
        return RandomCodeUtils.uuid() + "." + ext;
    }
}