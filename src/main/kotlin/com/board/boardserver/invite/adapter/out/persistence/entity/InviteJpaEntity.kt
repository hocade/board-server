package com.board.boardserver.invite.adapter.out.persistence.entity;

import com.board.boardserver.user.adapter.out.persistence.entity.UserJpaEntity
import jakarta.persistence.*;

/**
 * @author gihyung.lee
 * @since 2024-06-01
 */
@Entity
@Table(name = "INVITE")
class InviteJpaEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    var user: UserJpaEntity?,

    @Column(name = "CODE")
    var code: String? = null
) {

    fun refreshCode() {
        this.code = "";
    }
}
