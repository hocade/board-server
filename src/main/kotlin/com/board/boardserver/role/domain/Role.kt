package com.board.boardserver.role.domain

import com.board.boardserver.role.adapter.out.persistence.entity.RoleType

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
data class Role(
    val id: Long? = null,
    val name: String,
    val type: RoleType,
) {
}