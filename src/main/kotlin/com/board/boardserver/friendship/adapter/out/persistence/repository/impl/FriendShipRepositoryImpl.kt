package com.board.boardserver.friendship.adapter.out.persistence.repository.impl

import com.board.boardserver.attachment.adapter.out.persistence.entity.QAttachmentJpaEntity
import com.board.boardserver.common.utils.QueryDslUtil
import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipJpaEntity
import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipStatus
import com.board.boardserver.friendship.adapter.out.persistence.entity.QFriendShipJpaEntity
import com.board.boardserver.friendship.adapter.out.persistence.repository.FriendShipCustomRepository
import com.board.boardserver.friendship.adapter.out.persistence.vo.FriendShipPagingVo
import com.board.boardserver.friendship.adapter.out.persistence.vo.FriendShipUpdateVo
import com.board.boardserver.user.adapter.out.persistence.entity.QUserJpaEntity
import com.querydsl.core.types.Projections
import com.querydsl.jpa.JPAExpressions
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

/**
 * @author jinwook.kim
 * @since 4/26/24
 */
@Repository
class FriendShipRepositoryImpl(

) : QuerydslRepositorySupport(FriendShipJpaEntity::class.java), FriendShipCustomRepository {
    companion object {
        val FRIENDSHIP: QFriendShipJpaEntity = QFriendShipJpaEntity.friendShipJpaEntity
        val USER: QUserJpaEntity = QUserJpaEntity.userJpaEntity
        val ATTACHMENT: QAttachmentJpaEntity = QAttachmentJpaEntity.attachmentJpaEntity
    }

    override fun paging(userId: Long, pageable: Pageable): Page<FriendShipPagingVo> {
        val query = from(FRIENDSHIP)
            .join(FRIENDSHIP.friend, USER)
            .leftJoin(ATTACHMENT).on(USER.profile.eq(ATTACHMENT.id))
            .where(FRIENDSHIP.user.id.eq(userId).and(FRIENDSHIP.status.eq(FriendShipStatus.ACTIVE)))
            .select(Projections.constructor(
                FriendShipPagingVo::class.java,
                FRIENDSHIP,
                USER,
                ATTACHMENT
            ))
        return QueryDslUtil.page(querydsl, query, pageable)
    }

    override fun existsByRequest(userId: Long, friendId: Long): Boolean {
        val query = from(FRIENDSHIP)
            .where(
                (FRIENDSHIP.user.id.eq(userId).and(FRIENDSHIP.friend.id.eq(friendId)))
                    .or(FRIENDSHIP.user.id.eq(friendId).and(FRIENDSHIP.friend.id.eq(userId)))
            )
            return query.fetchFirst() != null
    }

}