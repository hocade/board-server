package com.board.boardserver.user.adapter.`in`.rest.mapper

import com.board.boardserver.user.adapter.`in`.rest.dto.UserDto
import com.board.boardserver.user.domain.User
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
@Mapper
abstract class UserResponseDtoMapper {
    companion object {
        val instance: UserResponseDtoMapper = Mappers.getMapper(UserResponseDtoMapper::class.java)
    }
    abstract fun toDto(user: User): UserDto.Response
}