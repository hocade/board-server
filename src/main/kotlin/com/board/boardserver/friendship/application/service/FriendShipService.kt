package com.board.boardserver.friendship.application.service

import com.board.boardserver.common.utils.AuthUtils
import com.board.boardserver.friendship.port.`in`.command.FriendShipCommand
import com.board.boardserver.friendship.port.`in`.usecase.FriendShipUsecase
import com.board.boardserver.friendship.port.out.FriendShipJpaPort
import com.board.boardserver.user.port.`in`.usecase.UserUseCase
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
@Service
class FriendShipService(
    private val friendShipJpaPort: FriendShipJpaPort,
    private val userUseCase: UserUseCase
) : FriendShipUsecase {

    @Transactional
    override fun request(command: FriendShipCommand.Request): Boolean {
        val user = userUseCase.findByEmail(AuthUtils.getAuth().name)
        user?.let {
            return friendShipJpaPort.request(it.id, command)
        }
        return false
    }
}