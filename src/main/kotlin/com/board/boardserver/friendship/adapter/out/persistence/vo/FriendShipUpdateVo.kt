package com.board.boardserver.friendship.adapter.out.persistence.vo

import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipJpaEntity

/**
 * @author jinwook.kim
 * @since 4/28/24
 */
data class FriendShipUpdateVo(
    val myFriendShip: FriendShipJpaEntity,
    val targetFriendShip: FriendShipJpaEntity,
) {
}