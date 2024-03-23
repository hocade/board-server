package com.board.boardserver.user.domain

import com.board.boardserver.user.adapter.out.persistence.entity.Phone

/**
 * @author jinwook.kim
 * @since 3/14/24
 */
data class User(
    val id: Long? = null,
    val email: String,
    val nickName: String,
    val password: String,
    val roles: List<UserRole>? = mutableListOf(),
    val phone: Phone?,
    val uniqueCode: String?,
) {
}