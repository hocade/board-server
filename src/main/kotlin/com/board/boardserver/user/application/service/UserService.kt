package com.board.boardserver.user.application.service

import com.board.boardserver.common.exception.CommonException
import com.board.boardserver.common.exception.enum.CommonExceptionCode
import com.board.boardserver.user.port.`in`.command.UserCommend
import com.board.boardserver.user.port.`in`.usecase.UserUseCase
import com.board.boardserver.user.port.out.UserJpaPort
import com.board.boardserver.user.domain.User
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

/**
 * @author jinwook.kim
 * @since 2/22/24
 */
@Service
class UserService(
    private val userJpaPort: UserJpaPort,
    private val passwordEncoder: PasswordEncoder
) : UserUseCase {

    @Transactional
    override fun create(commend: UserCommend.Request): User {
        if (findByEmail(commend.email) != null) {
            throw CommonException(CommonExceptionCode.USER_ALREADY_EXISTS)
        }
        commend.encryptPassword(passwordEncoder.encode(commend.password))
        val user = userJpaPort.saveUser(commend)
        return userJpaPort.updateRole(user.id!!, commend.roleType)
    }

    override fun findById(id: Long): User? {
        return userJpaPort.findById(id)
    }

    override fun findByEmail(email: String): User? {
        return userJpaPort.findByEmail(email)
    }
}