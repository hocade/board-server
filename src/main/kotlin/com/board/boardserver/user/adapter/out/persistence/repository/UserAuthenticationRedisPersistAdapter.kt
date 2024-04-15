package com.board.boardserver.user.adapter.out.persistence.repository

import com.board.boardserver.common.exception.CommonException
import com.board.boardserver.common.exception.enum.CommonExceptionCode
import com.board.boardserver.user.adapter.out.persistence.entity.UserAuthenticationRedisEntityType
import com.board.boardserver.user.adapter.out.persistence.mapper.UserAuthenticationRedisEntityMapper
import com.board.boardserver.user.domain.UserAuthenticationRedis
import com.board.boardserver.user.port.out.UserAuthenticationRedisPort
import org.springframework.stereotype.Component

/**
 * @author jinwook.kim
 * @since 4/15/24
 */
@Component
class UserAuthenticationRedisPersistAdapter(
    private val userAuthenticationRedisRepository: UserAuthenticationRedisRepository
) : UserAuthenticationRedisPort {

    override fun save(key: String, value: String, type: UserAuthenticationRedisEntityType): UserAuthenticationRedis {
        val userAuthenticationRedis = userAuthenticationRedisRepository.save(UserAuthenticationRedisEntityMapper.instance.toEntity(key, value, type.expiration))
        return UserAuthenticationRedisEntityMapper.instance.toDomain(userAuthenticationRedis)
    }

    override fun findByKey(key: String): UserAuthenticationRedis {
        val userAuthenticationRedis = userAuthenticationRedisRepository.findById(key)
            .orElseThrow { CommonException(CommonExceptionCode.NOT_FOUND_RESOURCE) }
        return UserAuthenticationRedisEntityMapper.instance.toDomain(userAuthenticationRedis)
    }
}