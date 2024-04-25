package com.board.boardserver.user.port.`in`.command

import com.board.boardserver.role.adapter.out.persistence.entity.RoleType
import com.board.boardserver.user.domain.Phone

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
sealed class UserCommand {
    data class Create(
        val nickName: String,
        var password: String,
        val email: String,
        val roleType: RoleType,
        val phone: Phone,
        val terms: List<Long>
    ) : UserCommand() {
        fun encryptPassword(encryptedPassword: String) {
            this.password = encryptedPassword
        }
    }
    data class Update(
        var id: Long,
        var password: String?,
    ) : UserCommand()
}