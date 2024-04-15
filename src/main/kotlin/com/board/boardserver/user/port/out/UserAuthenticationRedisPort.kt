package com.board.boardserver.user.port.out

import com.board.boardserver.user.adapter.out.persistence.entity.UserAuthenticationRedisEntityType
import com.board.boardserver.user.domain.UserAuthenticationRedis

/**
 * @author jinwook.kim
 * @since 4/15/24
 */
interface UserAuthenticationRedisPort {
    fun save(key: String, value: String, type: UserAuthenticationRedisEntityType): UserAuthenticationRedis
    fun findByKey(key: String): UserAuthenticationRedis
}