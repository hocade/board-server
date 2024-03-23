package com.board.boardserver.user.application.service

import com.board.boardserver.common.exception.CommonException
import com.board.boardserver.common.exception.enum.CommonExceptionCode
import com.board.boardserver.role.application.port.out.RoleJpaPort
import com.board.boardserver.user.application.port.`in`.command.UserCommend
import com.board.boardserver.user.application.port.`in`.usecase.UserUseCase
import com.board.boardserver.user.application.port.out.UserJpaPort
import com.board.boardserver.user.domain.User
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

/**
 * @author jinwook.kim
 * @since 2/22/24
 */
@Service
class UserService(
    private val userJpaPort: UserJpaPort,
    private val roleJpaPort: RoleJpaPort
) : UserUseCase {

    @Transactional
    override fun create(commend: UserCommend.CreateUser): User {
        // todo : 샘플 작성이며 추후 Security 적용 시 password 암호화, role 추가 등 구현 필요
        if (findByEmail(commend.email) != null) {
            throw CommonException(CommonExceptionCode.USER_ALREADY_EXISTS)
        }
        return userJpaPort.saveUser(commend)
    }

    override fun findById(id: Long): User? {
        return userJpaPort.findById(id)
    }

    override fun findByEmail(email: String): User? {
        return userJpaPort.findByEmail(email)
    }
}