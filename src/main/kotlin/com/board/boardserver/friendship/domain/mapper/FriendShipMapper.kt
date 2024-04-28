package com.board.boardserver.friendship.domain.mapper

import com.board.boardserver.attachment.adapter.out.persistence.entity.AttachmentJpaEntity
import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipJpaEntity
import com.board.boardserver.friendship.adapter.out.persistence.mapper.FriendShipJpaEntityMapper
import com.board.boardserver.friendship.domain.FriendShip
import com.board.boardserver.user.adapter.out.persistence.entity.UserJpaEntity
import com.board.boardserver.user.adapter.out.persistence.mapper.UserJpaEntityMapper
import com.board.boardserver.user.domain.User
import org.mapstruct.Context
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Named
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 4/28/24
 */
@Mapper(uses = [FriendShipJpaEntityMapper::class])
abstract class FriendShipMapper {
    companion object {
        val instance: FriendShipMapper = Mappers.getMapper(FriendShipMapper::class.java)
    }

    @Mapping(target = "id", source = "friendShip.id")
    @Mapping(target = "status", source = "friendShip.status")
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "friend", source = ".", qualifiedByName = ["friend"])
    abstract fun toDomain(friendShip: FriendShipJpaEntity, @Context friend: UserJpaEntity, @Context profile: AttachmentJpaEntity?): FriendShip

    @Named("friend")
    fun friend(friendShip: FriendShipJpaEntity, @Context friend: UserJpaEntity, @Context profile: AttachmentJpaEntity?): User {
        return UserJpaEntityMapper.instance.toUser(friend, profile)
    }
}