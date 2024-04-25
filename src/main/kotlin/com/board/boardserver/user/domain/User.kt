package com.board.boardserver.user.domain

import com.board.boardserver.user.adapter.out.persistence.entity.UserStatus
import com.board.boardserver.user.port.`in`.command.UserCommand


/**
 * @author jinwook.kim
 * @since 3/14/24
 */
data class User(
    val id: Long,
    val email: String,
    val nickName: String,
    var password: String,
    var status: UserStatus,
    var profile: Long?,
    var roles: MutableSet<UserRole> = mutableSetOf(),
    val phone: Phone?,
    val uniqueCode: String?
) {
    fun update(command: UserCommand.Update) {
        this.password = command.password ?: this.password
    }
    fun updateProfile(profile: Long) {
        this.profile = profile
    }
    fun checkPassword(encryptedPassword: String): Boolean {
        return this.password == encryptedPassword
    }
}