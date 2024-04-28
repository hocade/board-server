package com.board.boardserver.friendship.adapter.out.persistence.repository

import com.board.boardserver.common.exception.CommonException
import com.board.boardserver.common.exception.enum.CommonExceptionCode
import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipStatus
import com.board.boardserver.friendship.adapter.out.persistence.mapper.FriendShipJpaEntityMapper
import com.board.boardserver.friendship.port.`in`.command.FriendShipCommand
import com.board.boardserver.friendship.port.out.FriendShipJpaPort
import com.board.boardserver.user.adapter.out.persistence.entity.UserJpaEntity
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
        val user = findUser(userId)
        val target = findUser(command.friendId)

        val myFriendShipOpt = friendShipRepository.findByUserAndFriend(user, target)
        val targetFriendShipOpt = friendShipRepository.findByUserAndFriend(target, user)

        if (myFriendShipOpt.isPresent && targetFriendShipOpt.isPresent) {
            val myFriendShip = myFriendShipOpt.get()
            val targetFriendShip = targetFriendShipOpt.get()
            // 이미 친구로 등록 되어 있을 때 || 상대방이 이미 친구 신청을 한 상태
            if ((myFriendShip.isActive() && targetFriendShip.isActive()) || myFriendShip.isWaiting()) {
                throw CommonException(CommonExceptionCode.INVALID_REQUEST)
            }
            // 거절 한 이력 이후 재신청
            if (!myFriendShip.hasRequested()) {
                myFriendShip.updateStatus(FriendShipStatus.REQUEST)
                targetFriendShip.updateStatus(FriendShipStatus.WAITING)
                friendShipRepository.saveAll(listOf(myFriendShip, targetFriendShip))
            }
            return true
        }

        // 새로운 친구 신청
        friendShipRepository.save(FriendShipJpaEntityMapper.instance.toJpaEntity(user, target, FriendShipStatus.REQUEST))
        friendShipRepository.save(FriendShipJpaEntityMapper.instance.toJpaEntity(target, user, FriendShipStatus.WAITING))
        return true
    }

    override fun update(userId: Long, command: FriendShipCommand.Update): Boolean {
        val user = findUser(userId)
        val target = findUser(command.friendId)
        // 나와 상대방의 친구 entity 조회
        val myFriendship = friendShipRepository.findByUserAndFriendAndStatus(user, target, FriendShipStatus.WAITING).orElseThrow { CommonException(CommonExceptionCode.INVALID_REQUEST) }
        val targetFriendship = friendShipRepository.findByUserAndFriendAndStatus(target, user, FriendShipStatus.REQUEST).orElseThrow { CommonException(CommonExceptionCode.INVALID_REQUEST) }
        // 친구 상태 업데이트
        myFriendship.updateStatus(command.status)
        targetFriendship.updateStatus(command.status)
        friendShipRepository.saveAll(listOf(myFriendship, targetFriendship))
        // todo : 상태 변경에 대한 이력이 필요하다면 이력 테이블 생성, 현재는 필요하지 않음
        return true
    }

    override fun delete(userId: Long, command: FriendShipCommand.Request): Boolean {
        val user = findUser(userId)
        val target = findUser(command.friendId)
        // 나와 상대방의 친구 entity 조회
        val myFriendship = friendShipRepository.findByUserAndFriendAndStatus(user, target, FriendShipStatus.ACTIVE).orElseThrow { CommonException(CommonExceptionCode.INVALID_REQUEST) }
        val targetFriendship = friendShipRepository.findByUserAndFriendAndStatus(target, user, FriendShipStatus.ACTIVE).orElseThrow { CommonException(CommonExceptionCode.INVALID_REQUEST) }
        // 친구 상태 업데이트
        myFriendship.updateStatus(FriendShipStatus.REMOVE)
        targetFriendship.updateStatus(FriendShipStatus.REMOVE)
        friendShipRepository.saveAll(listOf(myFriendship, targetFriendship))
        return true
    }

    private fun findUser(userId: Long): UserJpaEntity {
        return userRepository.findById(userId).orElseThrow { CommonException(CommonExceptionCode.NOT_FOUND_RESOURCE) }
    }
}