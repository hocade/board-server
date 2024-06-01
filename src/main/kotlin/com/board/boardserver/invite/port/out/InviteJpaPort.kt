package com.board.boardserver.invite.port.out

import com.board.boardserver.invite.domain.Invite

/**
 * @author gihyung.lee
 * @since 2024-06-01
 */
interface InviteJpaPort {

    fun findByUserId(userId: Long): Invite?

    fun findByCode(code: String): Invite?

    fun create(userId: Long): Invite?

    fun update(userId: Long): Invite?
}