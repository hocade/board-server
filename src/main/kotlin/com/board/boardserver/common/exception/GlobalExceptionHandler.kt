package com.board.boardserver.common.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(CommonException::class)
    fun handle(e: CommonException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            e.exceptionCode.status.value(),
            e.exceptionCode.message,
            e.exceptionCode.code
            )
        return ResponseEntity(errorResponse, e.exceptionCode.status)
    }
}