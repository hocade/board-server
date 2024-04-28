package com.board.boardserver.friendship.adapter.out.persistence.repository


/**
 * @author jinwook.kim
 * @since 4/26/24
 */
interface FriendShipCustomRepository {
    fun existsByRequest(userId: Long, friendId: Long): Boolean
}