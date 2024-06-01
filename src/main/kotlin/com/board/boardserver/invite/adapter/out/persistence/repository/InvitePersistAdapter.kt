package com.board.boardserver.invite.adapter.out.persistence.repository;

import com.board.boardserver.invite.adapter.out.persistence.mapper.InviteJpaEntityMapper
import com.board.boardserver.invite.domain.Invite
import com.board.boardserver.invite.port.out.InviteJpaPort
import org.springframework.stereotype.Component

/**
 * @author gihyung.lee
 * @since 2024-06-01
 */
@Component
class InvitePersistAdapter(
    private val inviteRepository: InviteRepository
) : InviteJpaPort {

    override fun findByUserId(userId: Long): Invite? {
        inviteRepository.findByUserId(userId)?.let {
            return InviteJpaEntityMapper.instance.toDomain(it)
        }
        return null
    }

    override fun findByCode(code: String): Invite? {
        inviteRepository.findByCode(code)?.let {
            return InviteJpaEntityMapper.instance.toDomain(it)
        }
        return null;
    }

    override fun create(userId: Long): Invite? {
        val result = InviteJpaEntityMapper.instance.toJpaEntity()
    }

    override fun update(userId: Long): Invite? {
        TODO("Not yet implemented")
    }

}
