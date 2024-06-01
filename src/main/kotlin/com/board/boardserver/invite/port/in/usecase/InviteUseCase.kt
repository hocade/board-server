package com.board.boardserver.invite.port.`in`.usecase

import com.board.boardserver.invite.application.port.command.InviteCommand
import com.board.boardserver.invite.domain.Invite

/**
 * @author gihyung.lee
 * @since 2024-06-01
 */
interface InviteUseCase {
    fun findByUserId(userId: Long): Invite?
    fun create(command: InviteCommand.Create): Invite?
    fun update(command: InviteCommand.Update): Invite?
    fun request(command: InviteCommand.Request): Boolean

}