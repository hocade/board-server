package com.board.boardserver.user.adapter.`in`.rest

import com.board.boardserver.common.constant.EndpointPrefix
import com.board.boardserver.common.response.GenericResponse
import com.board.boardserver.user.adapter.`in`.rest.dto.UserAuthCodeDto
import com.board.boardserver.user.adapter.`in`.rest.dto.UserAuthDto
import com.board.boardserver.user.port.`in`.usecase.GuestUserAuthUseCase
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

/**
 * @author jinwook.kim
 * @since 4/17/24
 */
@RestController
@RequestMapping(value = [EndpointPrefix.guest + EndpointPrefix.user])
class GuestUserAuthController(
    private val guestUserAuthUseCase: GuestUserAuthUseCase
) {

    /**
     * 사용자 본인 인증 코드 발급
     */
    @PostMapping(value = ["/auth"])
    fun auth(@RequestBody @Validated dto: UserAuthDto.Request): ResponseEntity<GenericResponse<UserAuthDto.Response>> {
        return GenericResponse.ok(guestUserAuthUseCase.auth(dto))
    }

    /**
     * 사용자 본인 인증 확인
     */
    @PutMapping(value = ["/auth"])
    fun auth(@RequestBody dto: UserAuthCodeDto): ResponseEntity<GenericResponse<Boolean>> {
        return GenericResponse.ok(guestUserAuthUseCase.check(dto))
    }

}