package com.board.boardserver.common.properties

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * @author jinwook.kim
 * @since 4/15/24
 */
@ConfigurationProperties(prefix = "spring.redis")
class RedisProperties(
    val host: String,
    val port: Int,
)