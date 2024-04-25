package com.board.boardserver.friendship.port.out

import com.board.boardserver.friendship.port.`in`.command.FriendShipCommand

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
interface FriendShipJpaPort {
    fun request(userId: Long, command: FriendShipCommand.Request): Boolean
}