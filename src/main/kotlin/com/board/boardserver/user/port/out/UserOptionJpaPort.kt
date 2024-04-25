package com.board.boardserver.user.port.out

import com.board.boardserver.user.domain.UserOption

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
interface UserOptionJpaPort {
    fun create(userId: Long): UserOption
}