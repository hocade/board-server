package com.board.boardserver.role.port.`in`

import com.board.boardserver.role.adapter.out.persistence.entity.RoleType
import com.board.boardserver.role.domain.Role

/**
 * @author jinwook.kim
 * @since 4/6/24
 */
interface RoleUseCase {
    fun findByType(type: RoleType): Role?
}