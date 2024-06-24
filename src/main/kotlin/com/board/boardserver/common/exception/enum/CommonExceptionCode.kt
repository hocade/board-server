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
    ACCESS_DENIED(HttpStatus.UNAUTHORIZED, 401, "access denied"),
    NOT_FOUND_RESOURCE(HttpStatus.BAD_REQUEST, 1000, "not found resource"),
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, 1001, "not found user"),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, 1002, "invalid request"),
    USER_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, 1003, "user already exists"),
    INVALID_PHONE_NUMBER(HttpStatus.BAD_REQUEST, 1004, "invalid phone number"),
    INVALID_COUNTRY_CODE(HttpStatus.BAD_REQUEST, 1005, "invalid country code"),
    ALREADY_REQUESTED(HttpStatus.BAD_REQUEST, 1006, "already requested"),
    INVITE_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, 1007, "invite code already exists");
}