package com.board.boardserver.terms.adapter.out.persistence.entity

import com.board.boardserver.common.entity.BaseJpaEntity
import jakarta.persistence.*

/**
 * @author jinwook.kim
 * @since 4/17/24
 */
@Entity
@Table(name = "TERMS")
class TermsJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    var type: TermsType,

    // todo : 파일 entity and CRUD
    @Column(name = "FILE_ID")
    var file: Long

) : BaseJpaEntity() {
}