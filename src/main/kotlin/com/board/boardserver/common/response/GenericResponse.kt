package com.board.boardserver.common.response

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
class GenericResponse<T>(
    val data: T
) {
    companion object {
        private fun <T> of(
            status: HttpStatus?,
            data: T
        ): ResponseEntity<GenericResponse<T>> {
            return ResponseEntity.status(status!!).body(GenericResponse(data))
        }

        fun <T> ok(data: T): ResponseEntity<GenericResponse<T>> {
            return of(HttpStatus.OK, data)
        }
    }

}