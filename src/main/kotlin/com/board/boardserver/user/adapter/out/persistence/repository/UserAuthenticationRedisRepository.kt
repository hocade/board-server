package com.board.boardserver.user.adapter.out.persistence.repository

import com.board.boardserver.user.adapter.out.persistence.entity.UserAuthenticationRedisEntity
import org.springframework.data.repository.CrudRepository

/**
 * @author jinwook.kim
 * @since 4/15/24
 */
interface UserAuthenticationRedisRepository : CrudRepository<UserAuthenticationRedisEntity, String> {
}