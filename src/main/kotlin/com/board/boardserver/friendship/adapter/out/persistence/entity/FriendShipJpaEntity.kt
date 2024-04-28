package com.board.boardserver.friendship.adapter.out.persistence.entity

import com.board.boardserver.common.entity.BaseJpaEntity
import com.board.boardserver.user.adapter.out.persistence.entity.UserJpaEntity
import jakarta.persistence.*

/**
 * @author jinwook.kim
 * @since 4/25/24
 * 본인, 친구 row 각각 생성
 */
@Entity
@Table(name = "FRIENDSHIP")
class FriendShipJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    var user: UserJpaEntity?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FRIEND_ID")
    var friend: UserJpaEntity?,

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS")
    var status: FriendShipStatus
) : BaseJpaEntity() {

    fun hasRejected(): Boolean {
        return FriendShipStatus.REJECT == this.status
    }

    fun isActive(): Boolean {
        return FriendShipStatus.ACTIVE == this.status
    }

    fun hasRequested(): Boolean {
        return FriendShipStatus.REQUEST == this.status
    }

    fun isWaiting(): Boolean {
        return FriendShipStatus.WAITING == this.status
    }

    fun updateStatus(status: FriendShipStatus) {
        this.status = status
    }
}