package com.board.boardserver.friendship.domain

import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipStatus
import com.board.boardserver.user.domain.User

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
data class FriendShip(
    val id: Long,
    val status: FriendShipStatus,
    val user: User?,
    val friend: User
) {
}