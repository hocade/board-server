package com.board.boardserver.user.port.`in`.command

import com.board.boardserver.role.adapter.out.persistence.entity.RoleType

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
sealed class UserCommend {
    data class Request(
        val nickName: String,
        var password: String,
        val email: String,
        val roleType: RoleType
    ) : UserCommend() {
        fun encryptPassword(encryptedPassword: String) {
            this.password = encryptedPassword
        }
    }
}