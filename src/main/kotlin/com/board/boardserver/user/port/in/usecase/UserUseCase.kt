package com.board.boardserver.user.port.`in`.usecase

import com.board.boardserver.user.domain.User
import com.board.boardserver.user.port.`in`.command.UserCommand
import org.springframework.web.multipart.MultipartFile

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
interface UserUseCase {
    fun create(command: UserCommand.Create): User
    fun update(command: UserCommand.Update): User
    fun updateProfile(id: Long, file: MultipartFile): User
    fun findById(id: Long): User?
    fun findByEmail(email: String): User?
}