package com.board.boardserver.friendship.port.`in`.command

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
sealed class FriendShipCommand {
    data class Request(
        val friendId: Long
    ) : FriendShipCommand()
}