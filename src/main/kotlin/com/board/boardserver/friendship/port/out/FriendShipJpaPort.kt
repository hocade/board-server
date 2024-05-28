package com.board.boardserver.friendship.port.out

import com.board.boardserver.friendship.domain.FriendShip
import com.board.boardserver.friendship.port.`in`.command.FriendShipCommand
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
interface FriendShipJpaPort {
    fun paging(userId: Long, pageable: Pageable): Page<FriendShip>
    fun findByUserIdAndFriendId(userId: Long, friendId: Long): FriendShip?
    fun request(userId: Long, command: FriendShipCommand.Request): Boolean
    fun update(friendShip: FriendShip): Boolean
}