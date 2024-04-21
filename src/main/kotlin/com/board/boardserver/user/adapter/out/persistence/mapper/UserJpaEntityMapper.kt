package com.board.boardserver.user.adapter.out.persistence.mapper

import com.board.boardserver.user.adapter.out.persistence.entity.UserJpaEntity
import com.board.boardserver.user.adapter.out.persistence.entity.UserRoleJpaEntity
import com.board.boardserver.user.adapter.out.persistence.entity.UserStatus
import com.board.boardserver.user.domain.User
import com.board.boardserver.user.domain.UserRole
import com.board.boardserver.user.port.`in`.command.UserCommand
import org.mapstruct.*
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
@Mapper(uses = [PhoneJpaEntityMapper::class])
abstract class UserJpaEntityMapper {
    companion object {
        val instance: UserJpaEntityMapper = Mappers.getMapper(UserJpaEntityMapper::class.java)
    }


    abstract fun toJpaEntity(command: UserCommand.Create): UserJpaEntity

    @Mapping(target = "roles", source = "roles", qualifiedByName = ["userRoleJpaEntities"])
    abstract fun toJpaEntity(user: User): UserJpaEntity

    @Mapping(target = "roles", source = "roles", qualifiedByName = ["userRoles"])
    abstract fun toUser(userJpaEntity: UserJpaEntity): User

    @Named("userRoleJpaEntities")
    fun userRoleJpaEntities(roles: MutableSet<UserRole>): Set<UserRoleJpaEntity> {
        return roles.map { UserRoleJpaEntityMapper.instance.toJpaEntity(it) }.toSet()
    }

    @Named("userRoles")
    fun userRoles(roles: MutableSet<UserRoleJpaEntity>): Set<UserRole> {
        return roles.map { UserRoleJpaEntityMapper.instance.toUserRole(it.id!!) }.toSet()
    }

    @AfterMapping
    private fun after(command: UserCommand.Create, @MappingTarget entity: UserJpaEntity) {
        entity.status = UserStatus.ACTIVATION
        entity.roles = mutableSetOf()
    }

}