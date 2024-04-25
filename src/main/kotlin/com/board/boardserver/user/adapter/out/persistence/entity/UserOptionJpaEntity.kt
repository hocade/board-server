package com.board.boardserver.user.adapter.out.persistence.entity

import com.board.boardserver.common.entity.BaseJpaEntity
import jakarta.persistence.*

/**
 * @author jinwook.kim
 * @since 4/25/24
 * 푸쉬 토큰, 설정 정보 저장
 */
@Entity
@Table(name = "USER_OPTION")
class UserOptionJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long? = null,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    val user: UserJpaEntity?,

    @Column(name = "PUSH_TOKEN")
    var pushToken: String?,

    // 설정 언어
    @Column(name = "LANGUAGE_CODE")
    var languageCode: String?,

    // 푸쉬 알림 on/off
    @Column(name = "NOTICE")
    var notice: Boolean = false,

) : BaseJpaEntity() {
}