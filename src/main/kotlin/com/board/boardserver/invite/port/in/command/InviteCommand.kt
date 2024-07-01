package com.board.boardserver.invite.application.port.`in`.command;

/**
 * @author gihyung.lee
 * @since 2024-06-01
 */
sealed class InviteCommand {
    data class Request(
        val code: String
    ) : InviteCommand()
    data class Create(
        val userId: Long
    ) : InviteCommand()
    data class Update(
        val userId: Long
    ) : InviteCommand()
}
