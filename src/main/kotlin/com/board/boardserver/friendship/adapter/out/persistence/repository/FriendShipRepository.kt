package com.board.boardserver.friendship.adapter.out.persistence.repository

import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
interface FriendShipRepository : JpaRepository<FriendShipJpaEntity, Long> {
}