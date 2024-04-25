package com.board.boardserver.friendship.adapter.out.persistence.mapper

import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipJpaEntity
import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipStatus
import com.board.boardserver.user.adapter.out.persistence.entity.UserJpaEntity
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
@Mapper
abstract class FriendShipJpaEntityMapper {
    companion object {
        val instance: FriendShipJpaEntityMapper = Mappers.getMapper(FriendShipJpaEntityMapper::class.java)
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "user")
    @Mapping(target = "friend", source = "friend")
    @Mapping(target = "status", source = "status")
    abstract fun toJpaEntity(user: UserJpaEntity, friend: UserJpaEntity, status: FriendShipStatus): FriendShipJpaEntity
}