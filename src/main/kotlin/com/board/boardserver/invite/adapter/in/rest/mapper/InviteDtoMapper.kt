package com.board.boardserver.invite.adapter.`in`.rest.mapper

import com.board.boardserver.invite.adapter.rest.dto.InviteDto
import com.board.boardserver.invite.domain.Invite
import com.board.boardserver.user.adapter.`in`.rest.mapper.UserResponseDtoMapper
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

/**
 * @author gihyung.lee
 * @since 2024-06-01
 */
@Mapper(uses = [UserResponseDtoMapper::class])
abstract class InviteDtoMapper {
    companion object {
        val instance: InviteDtoMapper = Mappers.getMapper(InviteDtoMapper::class.java)
    }

    abstract fun toResponseDto(domain: Invite?): InviteDto.Response
}