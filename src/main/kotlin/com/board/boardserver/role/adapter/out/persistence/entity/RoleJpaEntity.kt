package com.board.boardserver.role.adapter.out.persistence.entity

import jakarta.persistence.*

/**
 * @author jinwook.kim
 * @since 3/14/24
 */
@Entity
@Table(name = "ROLE")
class RoleJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "NAME")
    var name: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    var type: RoleType,
) {
}