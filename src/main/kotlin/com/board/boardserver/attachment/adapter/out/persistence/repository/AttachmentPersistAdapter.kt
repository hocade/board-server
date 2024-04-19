package com.board.boardserver.attachment.adapter.out.persistence.repository

import com.board.boardserver.attachment.adapter.out.persistence.mapper.AttachmentJpaEntityMapper
import com.board.boardserver.attachment.domain.Attachment
import com.board.boardserver.attachment.port.out.AttachmentJpaPort
import com.board.boardserver.common.exception.CommonException
import com.board.boardserver.common.exception.enum.CommonExceptionCode
import org.springframework.stereotype.Component

/**
 * @author jinwook.kim
 * @since 4/19/24
 */
@Component
class AttachmentPersistAdapter(
    private val attachmentRepository: AttachmentRepository
) : AttachmentJpaPort {
    override fun findById(id: Long): Attachment {
        val entity = attachmentRepository.findById(id).orElseThrow { CommonException(CommonExceptionCode.NOT_FOUND_RESOURCE) }
        return AttachmentJpaEntityMapper.instance.toDomain(entity)
    }

    override fun save(attachment: Attachment): Attachment {
        val entity = attachmentRepository.save(AttachmentJpaEntityMapper.instance.toJpaEntity(attachment))
        return AttachmentJpaEntityMapper.instance.toDomain(entity)
    }

    override fun delete(id: Long) {
        attachmentRepository.deleteById(id)
    }
}