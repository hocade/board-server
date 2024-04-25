package com.board.boardserver.user.adapter.out.persistence.mapper

import com.board.boardserver.user.adapter.out.persistence.entity.UserJpaEntity
import com.board.boardserver.user.adapter.out.persistence.entity.UserOptionJpaEntity
import com.board.boardserver.user.domain.UserOption
import com.board.boardserver.user.port.`in`.command.UserOptionCommand
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
@Mapper
abstract class UserOptionJpaEntityMapper {
    companion object {
        val instance: UserOptionJpaEntityMapper = Mappers.getMapper(UserOptionJpaEntityMapper::class.java)
    }

    /**
     * 유저 생성 시 기본 값 설정
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pushToken", ignore = true)
    @Mapping(target = "notice", expression = "java(false)")
    @Mapping(target = "languageCode", source = "command.languageCode")
    @Mapping(target = "user", source = "user")
    abstract fun toJpaEntity(user: UserJpaEntity, command: UserOptionCommand.Create): UserOptionJpaEntity

    @Mapping(target = "id", source = "id")
    @Mapping(target = "pushToken", source = "pushToken")
    @Mapping(target = "notice", source = "notice")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "languageCode", source = "languageCode")
    abstract fun toDomain(entity: UserOptionJpaEntity): UserOption
}