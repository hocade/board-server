package com.board.boardserver.user.adapter.out.persistence.mapper

import com.board.boardserver.role.adapter.out.persistence.entity.RoleJpaEntity
import com.board.boardserver.user.adapter.out.persistence.entity.UserJpaEntity
import com.board.boardserver.user.adapter.out.persistence.entity.UserRoleJpaEntity
import com.board.boardserver.user.adapter.out.persistence.entity.UserRoleJpaEntityId
import com.board.boardserver.user.domain.UserRole
import org.mapstruct.AfterMapping
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 4/6/24
 */
@Mapper
abstract class UserRoleJpaEntityMapper {
    companion object {
        val instance: UserRoleJpaEntityMapper = Mappers.getMapper(UserRoleJpaEntityMapper::class.java)
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "user")
    @Mapping(target = "role", source = "role")
    abstract fun toJpaEntity(user: UserJpaEntity, role: RoleJpaEntity): UserRoleJpaEntity

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "role", ignore = true)
    abstract fun toJpaEntity(userRole: UserRole): UserRoleJpaEntity

    @Mapping(target = "userId", source = "id.userId")
    @Mapping(target = "roleId", source = "id.roleId")
    abstract fun toUserRole(id: UserRoleJpaEntityId): UserRole

    @AfterMapping
    fun after(user: UserJpaEntity, role: RoleJpaEntity, @MappingTarget entity: UserRoleJpaEntity) {
        entity.id = UserRoleJpaEntityId(user.id!!, role.id!!)
    }

    @AfterMapping
    fun after(userRole: UserRole, @MappingTarget entity: UserRoleJpaEntity) {
        entity.id = UserRoleJpaEntityId(userRole.userId, userRole.roleId)
    }

}