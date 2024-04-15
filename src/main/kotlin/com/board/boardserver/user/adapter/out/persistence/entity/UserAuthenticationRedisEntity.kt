package com.board.boardserver.user.adapter.out.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive

/**
 * @author jinwook.kim
 * @since 4/15/24
 */
@RedisHash
class UserAuthenticationRedisEntity(
    @Id
    val key: String,
    val value: String,
    @TimeToLive
    val expiration: Long
)