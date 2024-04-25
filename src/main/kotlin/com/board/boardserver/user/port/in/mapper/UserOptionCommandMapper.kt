package com.board.boardserver.user.port.`in`.mapper

import com.board.boardserver.user.port.`in`.command.UserOptionCommand
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
@Mapper
abstract class UserOptionCommandMapper {
    companion object {
        val instance: UserOptionCommandMapper = Mappers.getMapper(UserOptionCommandMapper::class.java)
    }

    @Mapping(target = "languageCode", source = "languageCode")
    abstract fun toCreateCommand(languageCode: String): UserOptionCommand.Create
}