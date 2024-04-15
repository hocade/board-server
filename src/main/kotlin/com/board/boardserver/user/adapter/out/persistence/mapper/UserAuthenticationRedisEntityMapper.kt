package com.board.boardserver.user.adapter.out.persistence.mapper

import com.board.boardserver.user.adapter.out.persistence.entity.UserAuthenticationRedisEntity
import com.board.boardserver.user.domain.UserAuthenticationRedis
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 4/15/24
 */
@Mapper
abstract class UserAuthenticationRedisEntityMapper {
    companion object {
        val instance: UserAuthenticationRedisEntityMapper = Mappers.getMapper(UserAuthenticationRedisEntityMapper::class.java)
    }

    @Mapping(target = "key", source = "key")
    @Mapping(target = "value", source = "value")
    @Mapping(target = "expiration", source = "expiration")
    abstract fun toEntity(key: String, value: String, expiration: Long): UserAuthenticationRedisEntity

    abstract fun toDomain(userAuthenticationRedisEntity: UserAuthenticationRedisEntity): UserAuthenticationRedis

}