package com.board.boardserver.terms.adapter.out.persistence.vo

import com.board.boardserver.attachment.adapter.out.persistence.entity.AttachmentJpaEntity
import com.board.boardserver.terms.adapter.out.persistence.entity.TermsJpaEntity

/**
 * @author jinwook.kim
 * @since 4/20/24
 */
data class TermsVo(
    val termsJpaEntity: TermsJpaEntity,
    val attachmentJpaEntity: AttachmentJpaEntity
)