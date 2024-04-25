package com.board.boardserver.user.adapter.out.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
@Embeddable
data class UserTermsJpaEntityId(
    @Column(name = "USER_ID")
    val userId: Long,
    @Column(name = "TERMS_ID")
    val termsId: Long,
) : Serializable