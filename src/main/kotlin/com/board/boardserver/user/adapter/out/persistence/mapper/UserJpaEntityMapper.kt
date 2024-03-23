package com.board.boardserver.user.adapter.out.persistence.mapper

import com.board.boardserver.user.adapter.out.persistence.entity.UserJpaEntity
import com.board.boardserver.user.application.port.`in`.command.UserCommend
import com.board.boardserver.user.domain.User
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
@Mapper
abstract class UserJpaEntityMapper {
    companion object {
        val instance: UserJpaEntityMapper = Mappers.getMapper(UserJpaEntityMapper::class.java)
    }

    abstract fun toJpaEntity(comment: UserCommend.CreateUser): UserJpaEntity

    @Mapping(target = "roles", ignore = true)
    abstract fun toUser(userJpaEntity: UserJpaEntity): User
}