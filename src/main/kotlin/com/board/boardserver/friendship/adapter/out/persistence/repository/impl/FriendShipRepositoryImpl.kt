package com.board.boardserver.friendship.adapter.out.persistence.repository.impl

import com.board.boardserver.friendship.adapter.out.persistence.entity.QFriendShipJpaEntity
import com.board.boardserver.friendship.adapter.out.persistence.repository.FriendShipCustomRepository
import com.board.boardserver.friendship.domain.FriendShip
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

/**
 * @author jinwook.kim
 * @since 4/26/24
 */
@Repository
class FriendShipRepositoryImpl(

) : QuerydslRepositorySupport(FriendShip::class.java), FriendShipCustomRepository {
    companion object {
        val FRIENDSHIP: QFriendShipJpaEntity = QFriendShipJpaEntity.friendShipJpaEntity
    }

    override fun existsByRequest(userId: Long, friendId: Long): Boolean {
        val query = from(FRIENDSHIP)
            .where(
                (FRIENDSHIP.user.id.eq(userId).and(FRIENDSHIP.friend.id.eq(friendId)))
                    .or(FRIENDSHIP.user.id.eq(friendId).and(FRIENDSHIP.friend.id.eq(userId)))
            )
            return query.fetchFirst() != null
    }

}