package com.board.boardserver.user.adapter.out.persistence.entity

import com.board.boardserver.role.adapter.out.persistence.entity.RoleJpaEntity
import jakarta.persistence.*

/**
 * @author jinwook.kim
 * @since 3/14/24
 */
@Entity
@Table(name = "USER_ROLES")
class UserRoleJpaEntity(
    @EmbeddedId
    val id: UserRoleId,

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    val user: UserJpaEntity,

    @MapsId("roleId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID")
    val role: RoleJpaEntity

)