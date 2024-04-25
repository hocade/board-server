package com.board.boardserver.user.application.service

import com.board.boardserver.attachment.port.`in`.usecase.AttachmentUseCase
import com.board.boardserver.common.exception.CommonException
import com.board.boardserver.common.exception.enum.CommonExceptionCode
import com.board.boardserver.common.utils.AuthUtils
import com.board.boardserver.user.domain.User
import com.board.boardserver.user.port.`in`.command.UserCommand
import com.board.boardserver.user.port.`in`.usecase.UserUseCase
import com.board.boardserver.user.port.out.UserJpaPort
import com.board.boardserver.user.port.out.UserTermsJpaPort
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

/**
 * @author jinwook.kim
 * @since 2/22/24
 */
@Service
class UserService(
    private val userJpaPort: UserJpaPort,
    private val userTermsJpaPort: UserTermsJpaPort,
    private val attachmentUseCase: AttachmentUseCase,
    private val passwordEncoder: PasswordEncoder
) : UserUseCase {

    @Transactional
    override fun create(command: UserCommand.Create): User {
        if (findByEmail(command.email) != null) {
            throw CommonException(CommonExceptionCode.USER_ALREADY_EXISTS)
        }
        command.encryptPassword(passwordEncoder.encode(command.password))
        val user = userJpaPort.createUser(command)
        command.terms.forEach { termsId -> userTermsJpaPort.create(user.id!!, termsId) }
        return userJpaPort.updateRole(user.id!!, command.roleType)
    }

    @Transactional
    override fun update(command: UserCommand.Update): User {
        var user = findMyInfo(command.id)
        if (command.password != null && !passwordEncoder.matches(command.password, user.password)) {
            command.password = passwordEncoder.encode(command.password)
        }
        user.update(command)
        return userJpaPort.save(user)
    }

    @Transactional
    override fun updateProfile(id: Long, file: MultipartFile): User {
        var user = findMyInfo(id)
        val attachment = attachmentUseCase.upload(file)
        user.updateProfile(attachment.id!!)
        return userJpaPort.save(user)
    }

    override fun findById(id: Long): User? {
        return userJpaPort.findById(id)
    }

    override fun findByEmail(email: String): User? {
        return userJpaPort.findByEmail(email)
    }

    private fun findMyInfo(id: Long): User {
        findById(id)?.let {
            if (!AuthUtils.me(it.email)) {
                throw CommonException(CommonExceptionCode.ACCESS_DENIED)
            }
            return it
        }
        throw CommonException(CommonExceptionCode.USER_NOT_FOUND)
    }
}