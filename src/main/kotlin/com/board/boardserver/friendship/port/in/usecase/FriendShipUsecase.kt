package com.board.boardserver.friendship.port.`in`.usecase

import com.board.boardserver.friendship.port.`in`.command.FriendShipCommand

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
interface FriendShipUsecase {
    fun request(command: FriendShipCommand.Request): Boolean
}