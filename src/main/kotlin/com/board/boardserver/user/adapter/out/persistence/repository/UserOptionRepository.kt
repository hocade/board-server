package com.board.boardserver.user.adapter.out.persistence.repository

import com.board.boardserver.user.adapter.out.persistence.entity.UserOptionJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
interface UserOptionRepository : JpaRepository<UserOptionJpaEntity, Long> {
}