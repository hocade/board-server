package com.board.boardserver.invite.application.service

import com.board.boardserver.invite.application.port.command.InviteCommand
import com.board.boardserver.invite.domain.Invite
import com.board.boardserver.invite.port.`in`.usecase.InviteUseCase
import com.board.boardserver.invite.port.out.InviteJpaPort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

/**
 * @author gihyung.lee
 * @since 2024-06-01
 */
@Service
class InviteService (
    private val inviteJpaPort: InviteJpaPort
) : InviteUseCase {
    @Transactional
    override fun findByUserId(userId: Long): Invite {
        TODO("Not yet implemented")
    }

    override fun create(command: InviteCommand.Create): Invite {
        TODO("Not yet implemented")
    }

    override fun update(command: InviteCommand.Update): Invite {
        TODO("Not yet implemented")
    }

    override fun request(command: InviteCommand.Request): Boolean {
        TODO("Not yet implemented")
    }

}