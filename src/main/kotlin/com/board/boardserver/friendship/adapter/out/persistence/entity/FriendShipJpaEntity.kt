package com.board.boardserver.friendship.adapter.out.persistence.entity

import com.board.boardserver.common.entity.BaseJpaEntity
import com.board.boardserver.user.adapter.out.persistence.entity.UserJpaEntity
import jakarta.persistence.*

/**
 * @author jinwook.kim
 * @since 4/25/24
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
}