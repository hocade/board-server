package com.board.boardserver.user.application.service

import com.board.boardserver.common.utils.RandomCodeUtils
import com.board.boardserver.user.adapter.`in`.rest.dto.UserAuthCodeDto
import com.board.boardserver.user.adapter.`in`.rest.dto.UserAuthDto
import com.board.boardserver.user.adapter.out.persistence.entity.UserAuthenticationType
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
    override fun auth(dto: UserAuthDto.Request): UserAuthDto.Response {
        // redis 저장
        val userAuth = userAuthenticationRedisPort.save(RandomCodeUtils.uuid(), RandomCodeUtils.sixNumberCode(), UserAuthenticationType.PHONE)
        // todo : Sms 발송

        return UserAuthDto.Response(userAuth.key)
    }

    override fun check(dto: UserAuthCodeDto): Boolean {
        val userAuth = userAuthenticationRedisPort.findByKey(dto.key)
        return userAuth.match(dto.value)
    }
}