package com.board.boardserver.attachment.adapter.`in`.rest

import com.board.boardserver.attachment.adapter.`in`.rest.dto.AttachmentDto
import com.board.boardserver.attachment.adapter.`in`.rest.mapper.AttachmentDtoMapper
import com.board.boardserver.attachment.port.`in`.usecase.AttachmentUseCase
import com.board.boardserver.common.response.GenericResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

/**
 * @author jinwook.kim
 * @since 4/19/24
 */
@RestController
@RequestMapping(value = ["/attachment"])
class AttachmentController(
    private val attachmentUseCase: AttachmentUseCase
) {

    @PostMapping("/multipart-file")
    fun uploadMultipleFile(
        @RequestPart file: MultipartFile,
    ): ResponseEntity<GenericResponse<AttachmentDto.Response>> {
        val attachment = attachmentUseCase.upload(file)
        return GenericResponse.ok(AttachmentDtoMapper.instance.toDto(attachment))
    }

}