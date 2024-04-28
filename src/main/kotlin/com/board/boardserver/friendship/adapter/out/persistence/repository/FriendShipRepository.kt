package com.board.boardserver.friendship.adapter.out.persistence.repository

import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipJpaEntity
import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipStatus
import com.board.boardserver.user.adapter.out.persistence.entity.UserJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
interface FriendShipRepository : JpaRepository<FriendShipJpaEntity, Long>, FriendShipCustomRepository {
    fun findByUserAndFriend(userJpaEntity: UserJpaEntity, friend: UserJpaEntity): Optional<FriendShipJpaEntity>
    fun findByUserAndFriendAndStatus(userJpaEntity: UserJpaEntity, friend: UserJpaEntity, status: FriendShipStatus): Optional<FriendShipJpaEntity>
}