package com.board.boardserver.user.port.out

import com.board.boardserver.role.adapter.out.persistence.entity.RoleType
import com.board.boardserver.user.domain.User
import com.board.boardserver.user.port.`in`.command.UserCommand

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
interface UserJpaPort {
    fun updateRole(id: Long, roleType: RoleType): User
    fun createUser(command: UserCommand.Create): User
    fun save(user: User): User
    fun findById(id: Long): User?
    fun findByEmail(email: String): User?
}