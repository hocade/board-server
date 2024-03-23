package com.board.boardserver.user.application.port.out

import com.board.boardserver.user.application.port.`in`.command.UserCommend
import com.board.boardserver.user.domain.User

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
interface UserJpaPort {
    fun saveUser(commend: UserCommend.CreateUser): User
    fun findById(id: Long): User?
    fun findByEmail(email: String): User?
}