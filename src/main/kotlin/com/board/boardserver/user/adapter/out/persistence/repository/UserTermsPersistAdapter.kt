package com.board.boardserver.user.adapter.out.persistence.repository

import com.board.boardserver.user.adapter.out.persistence.mapper.UserTermsJpaEntityMapper
import com.board.boardserver.user.domain.UserTerms
import com.board.boardserver.user.domain.UserTermsId
import com.board.boardserver.user.port.out.UserTermsJpaPort
import org.springframework.stereotype.Component

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
@Component
class UserTermsPersistAdapter(
    private val userTermsRepository: UserTermsRepository
) : UserTermsJpaPort {
    override fun create(userId: Long, termsId: Long): UserTerms {
        val userTerms = userTermsRepository.save(UserTermsJpaEntityMapper.instance.toJpaEntity(UserTermsId(userId, termsId)))
        return UserTermsJpaEntityMapper.instance.toDomain(userTerms)
    }

}