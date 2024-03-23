package com.board.boardserver.role.adapter.out.persistence.repository

import com.board.boardserver.role.adapter.out.persistence.entity.RoleJpaEntity
import com.board.boardserver.role.adapter.out.persistence.entity.RoleType
import com.board.boardserver.role.domain.Role
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
interface RoleRepository : JpaRepository<RoleJpaEntity, Long> {
    fun findByType(type: RoleType): Optional<Role>
}