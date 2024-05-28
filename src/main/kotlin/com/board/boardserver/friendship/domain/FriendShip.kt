package com.board.boardserver.friendship.domain

import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipStatus
import com.board.boardserver.user.domain.User

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
data class FriendShip(
    val id: Long,
    var status: FriendShipStatus,
    val user: User?,
    val friend: User?
) {

    fun isActive(): Boolean {
        return FriendShipStatus.ACTIVE == this.status
    }

    fun hasRequested(): Boolean {
        return FriendShipStatus.REQUEST == this.status
    }

    fun isWaiting(): Boolean {
        return FriendShipStatus.WAITING == this.status
    }

    fun updateStatus(status: FriendShipStatus) {
        this.status = status
    }

}