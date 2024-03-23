package com.board.boardserver.common.exception.enum

import org.springframework.http.HttpStatus

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
enum class CommonExceptionCode(
    val status: HttpStatus,
    val code: Int,
    val message: String
) {
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, 1000, "not found user"),
    CLIENT_NOT_FOUND(HttpStatus.BAD_REQUEST, 1001, "not found client"),
    USER_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, 1002, "user already exists")
}