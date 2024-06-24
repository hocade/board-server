package com.board.boardserver.invite.adapter.out.persistence.repository;

import com.board.boardserver.common.constant.EndpointPrefix.Companion.user
import com.board.boardserver.common.exception.CommonException
import com.board.boardserver.common.exception.enum.CommonExceptionCode
import com.board.boardserver.invite.adapter.out.persistence.mapper.InviteJpaEntityMapper
import com.board.boardserver.invite.domain.Invite
import com.board.boardserver.invite.port.out.InviteJpaPort
import com.board.boardserver.user.adapter.out.persistence.repository.UserRepository
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Component

/**
 * @author gihyung.lee
 * @since 2024-06-01
 */
@Component
class InvitePersistAdapter(
    private val inviteRepository: InviteRepository,
    private val userRepository: UserRepository
) : InviteJpaPort {

    override fun findByUserId(userId: Long): Invite {
        inviteRepository.findByUserId(userId)?.let {
            return InviteJpaEntityMapper.instance.toDomain(it)
        }
        throw CommonException(CommonExceptionCode.NOT_FOUND_RESOURCE)
    }

    override fun findByCode(code: String): Invite {
        inviteRepository.findByCode(code)?.let {
            return InviteJpaEntityMapper.instance.toDomain(it)
        }
        throw CommonException(CommonExceptionCode.NOT_FOUND_RESOURCE)
    }

    override fun create(userId: Long): Invite {
        var user = userRepository.findById(userId).orElseThrow{CommonException(CommonExceptionCode.NOT_FOUND_RESOURCE)}
        val result = InviteJpaEntityMapper.instance.toJpaEntity(user)
        return InviteJpaEntityMapper.instance.toDomain(inviteRepository.save(result))
    }

    override fun update(invite: Invite): Invite {
        var invite = inviteRepository.save(InviteJpaEntityMapper.instance.toJpaEntity(invite))
        return InviteJpaEntityMapper.instance.toDomain(inviteRepository.save(invite))

        throw CommonException(CommonExceptionCode.NOT_FOUND_RESOURCE)
    }

}
