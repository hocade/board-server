package com.board.boardserver.invite.application.service

import com.board.boardserver.common.exception.CommonException
import com.board.boardserver.common.exception.enum.CommonExceptionCode
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
    override fun findByUserId(userId: Long): Invite? {
        inviteJpaPort.findByUserId(userId)?.let {
            return it
        }
        return null;
    }

    override fun create(command: InviteCommand.Create): Invite {
        findByUserId(command.userId)?.let {
            throw CommonException(CommonExceptionCode.INVITE_ALREADY_EXISTS)
        }
        return inviteJpaPort.create(command.userId)
    }

    override fun update(command: InviteCommand.Update): Invite {
        findByUserId(command.userId)?.let {
            it.refreshCode()
            return inviteJpaPort.update(it)
        }
        throw CommonException(CommonExceptionCode.INVITE_ALREADY_EXISTS)
    }

    override fun request(command: InviteCommand.Request): Boolean {
        TODO("Not yet implemented")
    }

}