package com.board.boardserver.friendship.adapter.out.persistence.entity

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
enum class FriendShipStatus {
    REQUEST,
    WAITING,
    REJECT,
    REMOVE,
    ACTIVE;

    companion object {
        fun requestValue(): List<FriendShipStatus> {
            return listOf(REJECT, ACTIVE)
        }
    }
}