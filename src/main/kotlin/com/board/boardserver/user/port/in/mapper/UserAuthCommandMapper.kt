package com.board.boardserver.user.port.`in`.mapper

import com.board.boardserver.user.adapter.`in`.rest.dto.UserAuthCodeDto
import com.board.boardserver.user.adapter.`in`.rest.dto.UserAuthDto
import com.board.boardserver.user.domain.mapper.PhoneMapper
import com.board.boardserver.user.port.`in`.command.UserAuthCommand
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 4/21/24
 */
@Mapper(uses = [PhoneMapper::class])
abstract class UserAuthCommandMapper {
    companion object {
        val instance: UserAuthCommandMapper = Mappers.getMapper(UserAuthCommandMapper::class.java)
    }

    abstract fun toPhoneCommand(dto: UserAuthDto.Request): UserAuthCommand.Request

    abstract fun toCodeCommand(dto: UserAuthCodeDto): UserAuthCommand.Code
}