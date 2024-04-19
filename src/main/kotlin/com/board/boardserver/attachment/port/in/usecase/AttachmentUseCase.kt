package com.board.boardserver.attachment.port.`in`.usecase

import com.board.boardserver.attachment.domain.Attachment
import org.springframework.web.multipart.MultipartFile

/**
 * @author jinwook.kim
 * @since 4/19/24
 */
interface AttachmentUseCase {
    fun upload(file: MultipartFile): Attachment
    fun delete(id: Long)
}