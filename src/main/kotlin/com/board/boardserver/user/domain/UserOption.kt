package com.board.boardserver.user.domain

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
data class UserOption(
    val id: Long? = null,
    val userId: Long,
    val pushToken: String?,
    val languageCode: String,
    val notice: Boolean
)