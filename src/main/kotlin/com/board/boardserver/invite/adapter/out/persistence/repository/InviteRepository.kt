package com.board.boardserver.invite.adapter.out.persistence.repository

import com.board.boardserver.invite.adapter.out.persistence.entity.InviteJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author gihyung.lee
 * @since 2024-06-01
 */
interface InviteRepository : JpaRepository<InviteJpaEntity, Long> {
    fun findByUserId(userId: Long): InviteJpaEntity

    fun findByCode(code: String): InviteJpaEntity
}