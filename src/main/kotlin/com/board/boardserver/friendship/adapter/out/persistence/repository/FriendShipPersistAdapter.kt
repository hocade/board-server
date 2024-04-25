package com.board.boardserver.friendship.adapter.out.persistence.repository

import com.board.boardserver.common.exception.CommonException
import com.board.boardserver.common.exception.enum.CommonExceptionCode
import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipStatus
import com.board.boardserver.friendship.adapter.out.persistence.mapper.FriendShipJpaEntityMapper
import com.board.boardserver.friendship.port.`in`.command.FriendShipCommand
import com.board.boardserver.friendship.port.out.FriendShipJpaPort
import com.board.boardserver.user.adapter.out.persistence.repository.UserRepository
import org.springframework.stereotype.Component

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
@Component
class FriendShipPersistAdapter(
    private val friendShipRepository: FriendShipRepository,
    private val userRepository: UserRepository
) : FriendShipJpaPort {
    override fun request(userId: Long, command: FriendShipCommand.Request): Boolean {
        val user = userRepository.findById(userId).orElseThrow { CommonException(CommonExceptionCode.NOT_FOUND_RESOURCE) }
        val target = userRepository.findById(command.friendId).orElseThrow { CommonException(CommonExceptionCode.NOT_FOUND_RESOURCE) }
        friendShipRepository.save(FriendShipJpaEntityMapper.instance.toJpaEntity(user, target, FriendShipStatus.REQUEST))
        friendShipRepository.save(FriendShipJpaEntityMapper.instance.toJpaEntity(target, user, FriendShipStatus.WAITING))
        return true
    }
}