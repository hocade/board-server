package com.board.boardserver.invite.adapter.in.rest.dto;

import com.board.boardserver.user.adapter.`in`.rest.dto.UserDto

/**
 * @author gihyung.lee
 * @since 2024-06-01
 */
sealed class InviteDto {
    data class Create(
        val userId: Long
    ) : InviteDto()
    data class Update(
        val userId: Long,
        val code: String
    ) : InviteDto()
    data class Request(
        val code: String
    ) : InviteDto()
    data class Response(
        val id: Long,
        val user: UserDto.Response,
        val code: String
    ) : InviteDto()
}
