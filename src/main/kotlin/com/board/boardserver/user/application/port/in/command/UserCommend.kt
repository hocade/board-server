package com.board.boardserver.user.application.port.`in`.command

import com.board.boardserver.role.adapter.out.persistence.entity.RoleType

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
sealed class UserCommend {
    data class CreateUser(
        val nickName: String,
        val password: String,
        val email: String,
        val roleType: RoleType
    ) : UserCommend()
}