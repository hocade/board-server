package com.board.boardserver.user.adapter.out.persistence.entity

import com.board.boardserver.common.entity.BaseJpaEntity
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
@Entity
@Table(name = "USER_TERMS")
class UserTermsJpaEntity(
    @EmbeddedId
    var id: UserTermsJpaEntityId,
) : BaseJpaEntity() {
}