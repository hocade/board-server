package com.board.boardserver.role.adapter.out.persistence.repository

import com.board.boardserver.role.adapter.out.persistence.entity.RoleType
import com.board.boardserver.role.adapter.out.persistence.mapper.RoleJpaEntityMapper
import com.board.boardserver.role.application.port.out.RoleJpaPort
import com.board.boardserver.role.domain.Role
import org.springframework.stereotype.Component

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
@Component
class RolePersistAdapter(
    private val roleRepository: RoleRepository
) : RoleJpaPort {

    override fun findByType(type: RoleType): Role? {
        val roleOptional = roleRepository.findByType(type)
        return if (roleOptional.isPresent) RoleJpaEntityMapper.instance.toRole(roleOptional.get()) else null
    }
}