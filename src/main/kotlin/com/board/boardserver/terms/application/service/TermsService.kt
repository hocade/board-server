package com.board.boardserver.terms.application.service

import com.board.boardserver.attachment.port.`in`.usecase.AttachmentUseCase
import com.board.boardserver.terms.domain.Terms
import com.board.boardserver.terms.domain.mapper.TermsMapper
import com.board.boardserver.terms.port.`in`.command.TermsCommand
import com.board.boardserver.terms.port.`in`.usecase.TermsUseCase
import com.board.boardserver.terms.port.out.TermsJpaPort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

/**
 * @author jinwook.kim
 * @since 4/17/24
 */
@Service
class TermsService(
    private val termsJpaPort: TermsJpaPort,
    private val attachmentUseCase: AttachmentUseCase
) : TermsUseCase {

    @Transactional
    override fun create(command: TermsCommand.Create): Terms {
        val attachment = attachmentUseCase.upload(command.file)
        val terms = TermsMapper.instance.toDomain(command, attachment)
        return termsJpaPort.save(terms)
    }

    override fun fetchAll(): List<Terms> {
        return termsJpaPort.fetchAll()
    }
}