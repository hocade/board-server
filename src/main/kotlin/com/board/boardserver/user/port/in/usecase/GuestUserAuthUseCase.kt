package com.board.boardserver.user.port.`in`.usecase

import com.board.boardserver.user.adapter.`in`.rest.dto.UserAuthDto
import com.board.boardserver.user.port.`in`.command.UserAuthCommand

/**
 * @author jinwook.kim
 * @since 4/17/24
 */
interface GuestUserAuthUseCase {
    fun auth(command: UserAuthCommand.Request): UserAuthDto.Response
    fun check(command: UserAuthCommand.Code): Boolean
}