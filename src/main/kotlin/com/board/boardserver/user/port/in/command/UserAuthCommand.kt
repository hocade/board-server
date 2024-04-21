package com.board.boardserver.user.port.`in`.command

import com.board.boardserver.user.adapter.out.persistence.entity.UserAuthenticationType
import com.board.boardserver.user.domain.Phone

/**
 * @author jinwook.kim
 * @since 4/21/24
 */
sealed class UserAuthCommand {
    data class Request(
        var phone: Phone,
        var type: UserAuthenticationType
    ) : UserAuthCommand()
    data class Code(
        var key: String,
        var value: String
    ) : UserAuthCommand()
}