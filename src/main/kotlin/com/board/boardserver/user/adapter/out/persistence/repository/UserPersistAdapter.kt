package com.board.boardserver.user.adapter.out.persistence.repository

import com.board.boardserver.user.adapter.out.persistence.mapper.UserJpaEntityMapper
import com.board.boardserver.user.application.port.`in`.command.UserCommend
import com.board.boardserver.user.application.port.out.UserJpaPort
import com.board.boardserver.user.domain.User
import org.springframework.stereotype.Component

/**
 * @author jinwook.kim
 * @since 2/22/24
 */
@Component
class UserPersistAdapter(
    private val userRepository: UserRepository
) : UserJpaPort {

    override fun saveUser(commend: UserCommend.CreateUser): User {
        val userJpaEntity = userRepository.save(UserJpaEntityMapper.instance.toJpaEntity(commend))
        return UserJpaEntityMapper.instance.toUser(userJpaEntity)
    }

    override fun findById(id: Long): User? {
        val userOptional = userRepository.findById(id)
        return if (userOptional.isPresent) UserJpaEntityMapper.instance.toUser(userOptional.get()) else null
    }

    override fun findByEmail(email: String): User? {
        val userOptional = userRepository.findByEmail(email)
        return if (userOptional.isPresent) UserJpaEntityMapper.instance.toUser(userOptional.get()) else null
    }

}