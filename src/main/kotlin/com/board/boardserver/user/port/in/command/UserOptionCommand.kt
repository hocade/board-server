package com.board.boardserver.user.port.`in`.command

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
sealed class UserOptionCommand {
    data class Create(
        val languageCode: String
    ) : UserOptionCommand()
    data class Update(
        val languageCode: String,
        val pushToken: String,
        val notice: Boolean,
    ) : UserOptionCommand()
}