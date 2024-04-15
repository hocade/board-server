package com.board.boardserver.user.adapter.out.persistence.entity

import com.board.boardserver.common.entity.BaseJpaEntity
import jakarta.persistence.*

/**
 * @author jinwook.kim
 * @since 2/22/24
 */
@Entity
@Table(name = "USER")
class UserJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "EMAIL")
    var email: String,

    @Column(name = "NICK_NAME")
    var nickName: String,

    @Column(name = "PASSWORD")
    var password: String,

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    var roles: MutableSet<UserRoleJpaEntity> = mutableSetOf(),

    @Embedded
    var phone: PhoneJpaEntity?,

    @Column(name = "UNIQUE_CODE")
    var uniqueCode: String?,
    ) : BaseJpaEntity() {
    fun addRoles(role: UserRoleJpaEntity) {
        this.roles.add(role)
    }
}