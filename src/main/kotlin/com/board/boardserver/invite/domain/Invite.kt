package com.board.boardserver.invite.domain

import com.board.boardserver.user.domain.User

/**
 * @author gihyung.lee
 * @since 2024-06-01
 */
data class Invite(
    var id: Long,
    var user: User?,
    var code: String
){
    fun refreshCode() {
        val digits = (1..9).toList()
        this.code = (1..6)
            .map { digits.random() }
            .joinToString("")
    }
}