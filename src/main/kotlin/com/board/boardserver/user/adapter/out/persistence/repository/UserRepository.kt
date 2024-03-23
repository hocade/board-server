package com.board.boardserver.user.adapter.out.persistence.repository

import com.board.boardserver.user.adapter.out.persistence.entity.UserJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

/**
 * @author jinwook.kim
 * @since 2/22/24
 */
interface UserRepository : JpaRepository<UserJpaEntity, Long> {
    fun findByEmail(email: String): Optional<UserJpaEntity>
}