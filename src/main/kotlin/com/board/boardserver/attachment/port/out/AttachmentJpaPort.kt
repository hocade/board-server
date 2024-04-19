package com.board.boardserver.attachment.port.out

import com.board.boardserver.attachment.domain.Attachment

/**
 * @author jinwook.kim
 * @since 4/19/24
 */
interface AttachmentJpaPort {
    fun findById(id: Long): Attachment
    fun save(attachment: Attachment): Attachment
    fun delete(id: Long)
}