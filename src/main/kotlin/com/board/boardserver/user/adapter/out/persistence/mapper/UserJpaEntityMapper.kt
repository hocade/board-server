package com.board.boardserver.user.adapter.out.persistence.mapper

import com.board.boardserver.user.adapter.out.persistence.entity.UserJpaEntity
import com.board.boardserver.user.adapter.out.persistence.entity.UserRoleJpaEntity
import com.board.boardserver.user.port.`in`.command.UserCommend
import com.board.boardserver.user.domain.User
import com.board.boardserver.user.domain.UserRole
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Named
import org.mapstruct.factory.Mappers
import java.util.stream.Collectors

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
@Mapper
abstract class UserJpaEntityMapper {
    companion object {
        val instance: UserJpaEntityMapper = Mappers.getMapper(UserJpaEntityMapper::class.java)
    }


    @Mapping(target = "roles", source = ".", qualifiedByName = ["initRoles"])
    abstract fun toJpaEntity(commend: UserCommend.Request): UserJpaEntity

    @Mapping(target = "roles", source = "roles", qualifiedByName = ["userRoles"])
    abstract fun toUser(userJpaEntity: UserJpaEntity): User

    @Named("initRoles")
    fun initRoles(commend: UserCommend.Request): MutableSet<UserRoleJpaEntity> {
        return mutableSetOf()
    }

    @Named("userRoles")
    fun userRoles(roles: MutableSet<UserRoleJpaEntity>): MutableSet<UserRole> {
        return roles.stream().map { UserRoleJpaEntityMapper.instance.toUserRole(it.id!!) }.collect(Collectors.toSet())
    }

}