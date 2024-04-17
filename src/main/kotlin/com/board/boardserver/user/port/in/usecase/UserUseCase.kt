package com.board.boardserver.user.port.`in`.usecase

import com.board.boardserver.user.domain.User
import com.board.boardserver.user.port.`in`.command.UserCommend

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
interface UserUseCase {
    fun create(commend: UserCommend.Create): User
    fun findById(id: Long): User?
    fun findByEmail(email: String): User?
}