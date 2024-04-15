package com.board.boardserver.user.domain


/**
 * @author jinwook.kim
 * @since 3/14/24
 */
data class User(
    val id: Long? = null,
    val email: String,
    val nickName: String,
    val password: String,
    var roles: MutableSet<UserRole> = mutableSetOf(),
    val phone: Phone?,
    val uniqueCode: String?
)