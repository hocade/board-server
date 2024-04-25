package com.board.boardserver.user.adapter.out.persistence.repository

import com.board.boardserver.user.adapter.out.persistence.entity.UserTermsJpaEntity
import com.board.boardserver.user.adapter.out.persistence.entity.UserTermsJpaEntityId
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
interface UserTermsRepository : JpaRepository<UserTermsJpaEntity, UserTermsJpaEntityId> {
}