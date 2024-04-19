package com.board.boardserver.attachment.adapter.out.persistence.repository

import com.board.boardserver.attachment.adapter.out.persistence.entity.AttachmentJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author jinwook.kim
 * @since 4/19/24
 */
interface AttachmentRepository : JpaRepository<AttachmentJpaEntity, Long> {
}