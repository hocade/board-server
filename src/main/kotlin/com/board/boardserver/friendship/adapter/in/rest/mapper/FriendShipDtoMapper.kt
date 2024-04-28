package com.board.boardserver.friendship.adapter.`in`.rest.mapper

import com.board.boardserver.friendship.adapter.`in`.rest.dto.FriendShipDto
import com.board.boardserver.friendship.domain.FriendShip
import com.board.boardserver.user.adapter.`in`.rest.mapper.UserResponseDtoMapper
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 4/28/24
 */
@Mapper(uses = [UserResponseDtoMapper::class])
abstract class FriendShipDtoMapper {
    companion object {
        val instance: FriendShipDtoMapper = Mappers.getMapper(FriendShipDtoMapper::class.java)
    }

    @Mapping(target = "id", source = "id")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "friend", source = "friend")
    abstract fun toResponsePagingDto(domain: FriendShip): FriendShipDto.ResponsePaging

}