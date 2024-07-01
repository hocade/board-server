package com.board.boardserver.invite.adapter.out.persistence.mapper

import com.board.boardserver.invite.adapter.out.persistence.entity.InviteJpaEntity
import com.board.boardserver.invite.domain.Invite
import com.board.boardserver.user.adapter.out.persistence.entity.UserJpaEntity
import com.board.boardserver.user.adapter.out.persistence.mapper.UserJpaEntityMapper
import org.mapstruct.*
import org.mapstruct.factory.Mappers

/**
 * @author gihyung.lee
 * @since 2024-06-01
 */
@Mapper(uses = [UserJpaEntityMapper::class])
abstract class InviteJpaEntityMapper {
    companion object {
        val instance: InviteJpaEntityMapper = Mappers.getMapper(InviteJpaEntityMapper::class.java)
    }
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "user")
    @Mapping(target = "code", ignore = true, qualifiedByName = ["generateRandomCode"])
    abstract fun toJpaEntity(user: UserJpaEntity): InviteJpaEntity

    abstract fun toJpaEntity(invite: Invite): InviteJpaEntity

    abstract fun toDomain(jpaEntity: InviteJpaEntity): Invite

    @Named("generateRandomCode")
    fun generateRandomCode(): String {
        val digits = (1..9).toList()
        return (1..6)
            .map { digits.random() }
            .joinToString("")
    }
}