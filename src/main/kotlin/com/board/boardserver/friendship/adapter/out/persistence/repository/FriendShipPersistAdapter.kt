package com.board.boardserver.friendship.adapter.out.persistence.repository

import com.board.boardserver.common.exception.CommonException
import com.board.boardserver.common.exception.enum.CommonExceptionCode
import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipStatus
import com.board.boardserver.friendship.adapter.out.persistence.mapper.FriendShipJpaEntityMapper
import com.board.boardserver.friendship.domain.FriendShip
import com.board.boardserver.friendship.domain.mapper.FriendShipMapper
import com.board.boardserver.friendship.port.`in`.command.FriendShipCommand
import com.board.boardserver.friendship.port.out.FriendShipJpaPort
import com.board.boardserver.user.adapter.out.persistence.entity.UserJpaEntity
import com.board.boardserver.user.adapter.out.persistence.repository.UserRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
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
    override fun paging(userId: Long, pageable: Pageable): Page<FriendShip> {
        val vo = friendShipRepository.paging(userId, pageable)
        return vo.map { FriendShipMapper.instance.toDomain(it.friendShip, it.friend, it.profile) }
    }

    override fun findByUserIdAndFriendId(userId: Long, friendId: Long): FriendShip? {
        friendShipRepository.findByUserIdAndFriendId(userId, friendId)?.let {
                return FriendShipMapper.instance.toDomain(it)
            }
        return null
    }

    override fun request(userId: Long, command: FriendShipCommand.Request): Boolean {
        val user = findUser(userId)
        val target = findUser(command.friendId)
        // 새로운 친구 신청
        friendShipRepository.save(FriendShipJpaEntityMapper.instance.toJpaEntity(user, target, FriendShipStatus.REQUEST))
        friendShipRepository.save(FriendShipJpaEntityMapper.instance.toJpaEntity(target, user, FriendShipStatus.WAITING))
        return true
    }

    override fun update(friendShip: FriendShip): Boolean {
        val friendShipJpaEntity = friendShipRepository.findById(friendShip.id).orElseThrow { CommonException(CommonExceptionCode.INVALID_REQUEST) }
        friendShipJpaEntity.updateStatus(friendShip.status)
        friendShipRepository.save(friendShipJpaEntity)
        return true
    }

    private fun findUser(userId: Long): UserJpaEntity {
        return userRepository.findById(userId).orElseThrow { CommonException(CommonExceptionCode.NOT_FOUND_RESOURCE) }
    }
}