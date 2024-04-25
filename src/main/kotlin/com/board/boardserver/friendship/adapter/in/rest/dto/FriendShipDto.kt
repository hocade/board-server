package com.board.boardserver.friendship.adapter.`in`.rest.dto

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
sealed class FriendShipDto {
    data class Request(
        val friendId: Long
    ) : FriendShipDto()
}