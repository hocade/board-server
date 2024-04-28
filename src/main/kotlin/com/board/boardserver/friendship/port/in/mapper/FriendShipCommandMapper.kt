package com.board.boardserver.friendship.port.`in`.mapper

import com.board.boardserver.friendship.adapter.`in`.rest.dto.FriendShipDto
import com.board.boardserver.friendship.port.`in`.command.FriendShipCommand
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
@Mapper
abstract class FriendShipCommandMapper {
    companion object {
        val instance: FriendShipCommandMapper = Mappers.getMapper(FriendShipCommandMapper::class.java)
    }

    abstract fun toRequest(dto: FriendShipDto.Request): FriendShipCommand.Request

    abstract fun toUpdate(dto: FriendShipDto.Update): FriendShipCommand.Update
}