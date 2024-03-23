package com.board.boardserver.user.adapter.`in`.rest.dto

import com.board.boardserver.role.adapter.out.persistence.entity.RoleType

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
sealed class UserDto {
    data class CreateUser(
        val nickName: String,
        val password: String,
        val email: String,
        val roleType: RoleType
    ) : UserDto()
    data class Response(
        val id: Long,
        val nickName: String,
        val email: String
    ) : UserDto()
}