package com.board.boardserver.friendship.port.`in`.command

import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipStatus

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
sealed class FriendShipCommand {
    data class Request(
        val friendId: Long
    ) : FriendShipCommand()
    data class Update(
        val friendId: Long,
        val status: FriendShipStatus
    ) : FriendShipCommand()
}