package com.board.boardserver.user.application.port.`in`.usecase

import com.board.boardserver.user.application.port.`in`.command.UserCommend
import com.board.boardserver.user.domain.User

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
interface UserUseCase {
    fun create(commend: UserCommend.CreateUser): User
    fun findById(id: Long): User?
    fun findByEmail(email: String): User?
}