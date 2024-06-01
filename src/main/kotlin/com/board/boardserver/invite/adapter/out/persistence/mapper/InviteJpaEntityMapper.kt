package com.board.boardserver.invite.adapter.out.persistence.mapper

import com.board.boardserver.invite.adapter.out.persistence.entity.InviteJpaEntity
import com.board.boardserver.invite.domain.Invite
import com.board.boardserver.user.adapter.out.persistence.mapper.UserJpaEntityMapper
import org.mapstruct.Mapper
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

    abstract fun toJpaEntity(domain: Invite): InviteJpaEntity

    abstract fun toDomain(jpaEntity: InviteJpaEntity): Invite
}