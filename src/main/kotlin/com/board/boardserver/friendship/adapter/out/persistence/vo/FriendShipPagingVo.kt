package com.board.boardserver.friendship.adapter.out.persistence.vo

import com.board.boardserver.attachment.adapter.out.persistence.entity.AttachmentJpaEntity
import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipJpaEntity
import com.board.boardserver.user.adapter.out.persistence.entity.UserJpaEntity

/**
 * @author jinwook.kim
 * @since 4/28/24
 */
data class FriendShipPagingVo(
    val friendShip: FriendShipJpaEntity,
    val friend: UserJpaEntity,
    val profile: AttachmentJpaEntity?
) {
}