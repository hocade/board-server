package com.board.boardserver.user.adapter.out.persistence.mapper

import com.board.boardserver.attachment.adapter.out.persistence.entity.AttachmentJpaEntity
import com.board.boardserver.common.exception.CommonException
import com.board.boardserver.common.exception.enum.CommonExceptionCode
import com.board.boardserver.common.utils.PhoneUtils
import com.board.boardserver.user.adapter.out.persistence.entity.PhoneJpaEntity
import com.board.boardserver.user.adapter.out.persistence.entity.UserJpaEntity
import com.board.boardserver.user.adapter.out.persistence.entity.UserRoleJpaEntity
import com.board.boardserver.user.domain.Phone
import com.board.boardserver.user.domain.User
import com.board.boardserver.user.domain.UserRole
import com.board.boardserver.user.port.`in`.command.UserCommand
import org.mapstruct.*
import org.mapstruct.factory.Mappers
import java.util.*


/**
 * @author jinwook.kim
 * @since 3/23/24
 */
@Mapper(uses = [PhoneJpaEntityMapper::class])
abstract class UserJpaEntityMapper {
    companion object {
        val instance: UserJpaEntityMapper = Mappers.getMapper(UserJpaEntityMapper::class.java)
    }


    @Mapping(target = "phone", source = "phone", qualifiedByName = ["phone"])
    @Mapping(target = "status", expression = "java(UserStatus.ACTIVATION)")
    @Mapping(target = "roles", source = ".", qualifiedByName = ["initRoles"])
    abstract fun toJpaEntity(command: UserCommand.Create): UserJpaEntity

    @Mapping(target = "roles", source = "roles", qualifiedByName = ["userRoleJpaEntities"])
    @Mapping(target = "profile", source = "profile.id")
    abstract fun toJpaEntity(user: User): UserJpaEntity

    @Mapping(target = "roles", source = "roles", qualifiedByName = ["userRoles"])
    @Mapping(target = "profile", ignore = true)
    abstract fun toUser(userJpaEntity: UserJpaEntity): User

    @Mapping(target = "roles", source = "userJpaEntity.roles", qualifiedByName = ["userRoles"])
    @Mapping(target = "profile", source = "profile")
    @Mapping(target = "id", source = "userJpaEntity.id")
    @Mapping(target = "email", source = "userJpaEntity.email")
    @Mapping(target = "nickName", source = "userJpaEntity.nickName")
    @Mapping(target = "status", source = "userJpaEntity.status")
    @Mapping(target = "phone", source = "userJpaEntity.phone")
    @Mapping(target = "uniqueCode", source = "userJpaEntity.uniqueCode")
    abstract fun toUser(userJpaEntity: UserJpaEntity, profile: AttachmentJpaEntity): User

    @Named("phone")
    fun phone(phone: Phone): PhoneJpaEntity {
        if (!PhoneUtils.isValid(phone)) {
            throw CommonException(CommonExceptionCode.INVALID_PHONE_NUMBER)
        }
        return PhoneJpaEntityMapper.instance.toJpaEntity(phone)
    }

    @Named("initRoles")
    fun initRoles(command: UserCommand.Create): MutableSet<UserRoleJpaEntity> {
        return mutableSetOf()
    }

    @Named("userRoleJpaEntities")
    fun userRoleJpaEntities(roles: MutableSet<UserRole>): Set<UserRoleJpaEntity> {
        return roles.map { UserRoleJpaEntityMapper.instance.toJpaEntity(it) }.toSet()
    }

    @Named("userRoles")
    fun userRoles(roles: MutableSet<UserRoleJpaEntity>): Set<UserRole> {
        return roles.map { UserRoleJpaEntityMapper.instance.toUserRole(it.id!!) }.toSet()
    }

}