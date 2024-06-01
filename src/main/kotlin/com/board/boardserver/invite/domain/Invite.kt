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
        this.code = "";
    }
}