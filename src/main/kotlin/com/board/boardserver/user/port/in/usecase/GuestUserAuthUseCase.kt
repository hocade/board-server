package com.board.boardserver.user.port.`in`.usecase

import com.board.boardserver.user.adapter.`in`.rest.dto.UserAuthCodeDto
import com.board.boardserver.user.adapter.`in`.rest.dto.UserAuthDto

/**
 * @author jinwook.kim
 * @since 4/17/24
 */
interface GuestUserAuthUseCase {
    fun auth(dto: UserAuthDto.Request): UserAuthDto.Response
    fun check(dto: UserAuthCodeDto): Boolean
}