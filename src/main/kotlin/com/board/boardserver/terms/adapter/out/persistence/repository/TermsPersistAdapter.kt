package com.board.boardserver.terms.adapter.out.persistence.repository

import com.board.boardserver.attachment.adapter.out.persistence.repository.AttachmentRepository
import com.board.boardserver.terms.adapter.out.persistence.mapper.TermsJpaEntityMapper
import com.board.boardserver.terms.domain.Terms
import com.board.boardserver.terms.domain.mapper.TermsMapper
import com.board.boardserver.terms.port.out.TermsJpaPort
import org.springframework.stereotype.Component

/**
 * @author jinwook.kim
 * @since 4/17/24
 */
@Component
class TermsPersistAdapter(
    private val termsRepository: TermsRepository,
    private val attachmentRepository: AttachmentRepository
) : TermsJpaPort {
    override fun save(terms: Terms): Terms {
        val termsJpaEntity = termsRepository.save(TermsJpaEntityMapper.instance.toJpaEntity(terms))
        val attachment = attachmentRepository.findById(termsJpaEntity.file).get()
        return TermsMapper.instance.toDomain(termsJpaEntity, attachment)
    }

    override fun fetchAll(): List<Terms> {
        val vo = termsRepository.fetchAll()
        return vo.map { TermsMapper.instance.toDomain(it.termsJpaEntity, it.attachmentJpaEntity) }.toList()
    }
}