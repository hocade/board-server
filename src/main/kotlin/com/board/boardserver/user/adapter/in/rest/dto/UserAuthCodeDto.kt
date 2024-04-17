package com.board.boardserver.user.adapter.`in`.rest.dto

/**
 * @author jinwook.kim
 * @since 4/17/24
 * 사용자 본인인증
 */
data class UserAuthCodeDto(
    val key: String,
    val value: String
)