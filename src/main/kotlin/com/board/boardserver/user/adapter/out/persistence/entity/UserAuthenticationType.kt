package com.board.boardserver.user.adapter.out.persistence.entity

/**
 * @author jinwook.kim
 * @since 4/15/24
 */
enum class UserAuthenticationType(val expiration: Long) {
    PHONE(180);
}