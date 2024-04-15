package com.board.boardserver.user.domain

/**
 * @author jinwook.kim
 * @since 4/15/24
 */
data class UserAuthenticationRedis(
    val key: String,
    val value: String
)