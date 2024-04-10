package com.board.boardserver.role.application.service

import com.board.boardserver.role.adapter.out.persistence.entity.RoleType
import com.board.boardserver.role.domain.Role
import com.board.boardserver.role.port.`in`.RoleUseCase
import com.board.boardserver.role.port.out.RoleJpaPort
import org.springframework.stereotype.Service

/**
 * @author jinwook.kim
 * @since 4/6/24
 */
@Service
class RoleService(
    private val roleJpaPort: RoleJpaPort
) : RoleUseCase {

    override fun findByType(type: RoleType): Role? {
        return roleJpaPort.findByType(type)
    }
}