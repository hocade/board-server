package com.board.boardserver.role.application.port.out

import com.board.boardserver.role.adapter.out.persistence.entity.RoleType
import com.board.boardserver.role.domain.Role

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
interface RoleJpaPort {
    fun findByType(type: RoleType): Role?
}