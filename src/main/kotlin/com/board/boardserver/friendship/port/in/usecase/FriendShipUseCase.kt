package com.board.boardserver.friendship.port.`in`.usecase

import com.board.boardserver.friendship.domain.FriendShip
import com.board.boardserver.friendship.port.`in`.command.FriendShipCommand
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
interface FriendShipUseCase {
    fun paging(pageable: Pageable): Page<FriendShip>
    fun request(command: FriendShipCommand.Request): Boolean
    fun update(command: FriendShipCommand.Update): Boolean
    fun delete(command: FriendShipCommand.Update): Boolean
}