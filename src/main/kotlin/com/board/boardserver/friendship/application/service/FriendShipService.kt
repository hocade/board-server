package com.board.boardserver.friendship.application.service

import com.board.boardserver.common.exception.CommonException
import com.board.boardserver.common.exception.enum.CommonExceptionCode
import com.board.boardserver.common.utils.AuthUtils
import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipStatus
import com.board.boardserver.friendship.domain.FriendShip
import com.board.boardserver.friendship.port.`in`.command.FriendShipCommand
import com.board.boardserver.friendship.port.`in`.usecase.FriendShipUseCase
import com.board.boardserver.friendship.port.out.FriendShipJpaPort
import com.board.boardserver.user.port.`in`.usecase.UserUseCase
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
@Service
class FriendShipService(
    private val friendShipJpaPort: FriendShipJpaPort,
    private val userUseCase: UserUseCase
) : FriendShipUseCase {
    override fun paging(pageable: Pageable): Page<FriendShip> {
        val user = userUseCase.findByEmail(AuthUtils.getAuth().name)
        user?.let {
            return friendShipJpaPort.paging(it.id, pageable)
        }
        throw CommonException(CommonExceptionCode.NOT_FOUND_RESOURCE)
    }

    @Transactional
    override fun request(command: FriendShipCommand.Request): Boolean {
        val user = userUseCase.findByEmail(AuthUtils.getAuth().name)
        user?.let {
            val myFriendShip = friendShipJpaPort.findByUserIdAndFriendId(it.id, command.friendId)
            val targetFriendShip = friendShipJpaPort.findByUserIdAndFriendId(command.friendId, it.id)

            if (myFriendShip != null && targetFriendShip != null) {
                // 이미 친구로 등록 되어 있을 때 || 상대방이 이미 친구 신청을 한 상태
                if ((myFriendShip.isActive() && targetFriendShip.isActive()) || myFriendShip.isWaiting()) {
                    throw CommonException(CommonExceptionCode.INVALID_REQUEST)
                }
                // 거절 한 이력 이후 재신청
                if (!myFriendShip.hasRequested()) {
                    myFriendShip.updateStatus(FriendShipStatus.REQUEST)
                    targetFriendShip.updateStatus(FriendShipStatus.WAITING)

                    friendShipJpaPort.update(myFriendShip)
                    friendShipJpaPort.update(targetFriendShip)
                    return true
                }
            } else {
                // 신규 등록
                return friendShipJpaPort.request(it.id, command)
            }
        }
        return false
    }

    @Transactional
    override fun update(command: FriendShipCommand.Update): Boolean {
        val user = userUseCase.findByEmail(AuthUtils.getAuth().name)
        user?.let {
            val myFriendShip = friendShipJpaPort.findByUserIdAndFriendId(it.id, command.friendId)
            val targetFriendShip = friendShipJpaPort.findByUserIdAndFriendId(command.friendId, it.id)

            if (myFriendShip != null && targetFriendShip != null) {
                myFriendShip.updateStatus(command.status)
                targetFriendShip.updateStatus(command.status)

                friendShipJpaPort.update(myFriendShip)
                friendShipJpaPort.update(targetFriendShip)
                return true
            }
        }
        throw CommonException(CommonExceptionCode.NOT_FOUND_RESOURCE)
    }

    @Transactional
    override fun delete(command: FriendShipCommand.Update): Boolean {
        return update(command)
    }

}