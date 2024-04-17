package com.board.boardserver.user.port.out

import com.board.boardserver.user.adapter.out.persistence.entity.UserAuthenticationType
import com.board.boardserver.user.domain.UserAuthenticationRedis

/**
 * @author jinwook.kim
 * @since 4/15/24
 */
interface UserAuthenticationRedisPort {
    fun save(key: String, value: String, type: UserAuthenticationType): UserAuthenticationRedis
    fun findByKey(key: String): UserAuthenticationRedis
}