package com.board.boardserver.user.application.port.`in`.mapper

import com.board.boardserver.user.adapter.`in`.rest.dto.UserDto
import com.board.boardserver.user.application.port.`in`.command.UserCommend
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
@Mapper
abstract class UserCommandMapper {
    companion object {
        val instance: UserCommandMapper = Mappers.getMapper(UserCommandMapper::class.java)
    }

    abstract fun toCreateUserCommand(dto: UserDto.CreateUser): UserCommend.CreateUser
}