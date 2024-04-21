package com.board.boardserver.user.application.service

import com.board.boardserver.common.exception.CommonException
import com.board.boardserver.common.exception.enum.CommonExceptionCode
import com.board.boardserver.common.utils.PhoneUtils
import com.board.boardserver.common.utils.RandomCodeUtils
import com.board.boardserver.user.adapter.`in`.rest.dto.UserAuthDto
import com.board.boardserver.user.adapter.out.persistence.entity.UserAuthenticationType
import com.board.boardserver.user.port.`in`.command.UserAuthCommand
import com.board.boardserver.user.port.`in`.usecase.GuestUserAuthUseCase
import com.board.boardserver.user.port.out.UserAuthenticationRedisPort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

/**
 * @author jinwook.kim
 * @since 4/17/24
 */
@Service
class GuestUserAuthService(
    private val userAuthenticationRedisPort: UserAuthenticationRedisPort
) : GuestUserAuthUseCase {

    @Transactional
    override fun auth(command: UserAuthCommand.Request): UserAuthDto.Response {
        if (!PhoneUtils.isValid(command.phone)) {
            throw CommonException(CommonExceptionCode.INVALID_PHONE_NUMBER)
        }
        // redis 저장
        val userAuth = userAuthenticationRedisPort.save(RandomCodeUtils.uuid(), RandomCodeUtils.sixNumberCode(), UserAuthenticationType.PHONE)
        // todo : Sms 발송

        return UserAuthDto.Response(userAuth.key)
    }

    override fun check(command: UserAuthCommand.Code): Boolean {
        val userAuth = userAuthenticationRedisPort.findByKey(command.key)
        return userAuth.match(command.value)
    }
}