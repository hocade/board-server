package com.board.boardserver.user.adapter.out.persistence.repository

import com.board.boardserver.common.exception.CommonException
import com.board.boardserver.common.exception.enum.CommonExceptionCode
import com.board.boardserver.role.adapter.out.persistence.entity.RoleType
import com.board.boardserver.role.adapter.out.persistence.repository.RoleRepository
import com.board.boardserver.user.adapter.out.persistence.mapper.UserJpaEntityMapper
import com.board.boardserver.user.adapter.out.persistence.mapper.UserRoleJpaEntityMapper
import com.board.boardserver.user.port.`in`.command.UserCommend
import com.board.boardserver.user.port.out.UserJpaPort
import com.board.boardserver.user.domain.User
import org.springframework.stereotype.Component

/**
 * @author jinwook.kim
 * @since 2/22/24
 */
@Component
class UserPersistAdapter(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository
) : UserJpaPort {

    override fun updateRole(id: Long, roleType: RoleType): User {
        val user = userRepository.findById(id).orElseThrow { CommonException(CommonExceptionCode.USER_NOT_FOUND) }
        val role = roleRepository.findByType(roleType).orElseThrow { CommonException(CommonExceptionCode.NOT_FOUND_RESOURCE) }
        val userRoleJpaEntity = UserRoleJpaEntityMapper.instance.toJpaEntity(user, role)
        user.addRoles(userRoleJpaEntity)
        return UserJpaEntityMapper.instance.toUser(userRepository.save(user))
    }

    override fun saveUser(commend: UserCommend.Create): User {
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