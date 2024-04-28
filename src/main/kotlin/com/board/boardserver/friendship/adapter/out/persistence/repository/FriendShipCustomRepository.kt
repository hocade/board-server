package com.board.boardserver.friendship.adapter.out.persistence.repository

import com.board.boardserver.friendship.adapter.out.persistence.vo.FriendShipPagingVo
import com.board.boardserver.friendship.adapter.out.persistence.vo.FriendShipUpdateVo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable


/**
 * @author jinwook.kim
 * @since 4/26/24
 */
interface FriendShipCustomRepository {
    fun paging(userId: Long, pageable: Pageable): Page<FriendShipPagingVo>
    fun existsByRequest(userId: Long, friendId: Long): Boolean
    fun fetch(userId: Long, friendId: Long): FriendShipUpdateVo
}