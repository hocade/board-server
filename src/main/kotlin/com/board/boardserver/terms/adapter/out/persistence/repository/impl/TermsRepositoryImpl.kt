package com.board.boardserver.terms.adapter.out.persistence.repository.impl

import com.board.boardserver.attachment.adapter.out.persistence.entity.QAttachmentJpaEntity
import com.board.boardserver.terms.adapter.out.persistence.entity.QTermsJpaEntity
import com.board.boardserver.terms.adapter.out.persistence.entity.TermsJpaEntity
import com.board.boardserver.terms.adapter.out.persistence.repository.TermsCustomRepository
import com.board.boardserver.terms.adapter.out.persistence.vo.TermsVo
import com.querydsl.core.types.Projections
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

/**
 * @author jinwook.kim
 * @since 4/20/24
 */
@Repository
class TermsRepositoryImpl() : QuerydslRepositorySupport(TermsJpaEntity::class.java), TermsCustomRepository {
    val terms: QTermsJpaEntity = QTermsJpaEntity.termsJpaEntity
    val attachment: QAttachmentJpaEntity = QAttachmentJpaEntity.attachmentJpaEntity

    override fun fetchAll(): List<TermsVo> {
        return from(terms)
            .join(attachment).on(attachment.id.eq(terms.file))
            .select(Projections.constructor(TermsVo::class.java,
                terms,
                attachment
            ))
            .fetch()
    }

}