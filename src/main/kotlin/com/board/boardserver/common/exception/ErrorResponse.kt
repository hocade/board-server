package com.board.boardserver.common.exception

import com.querydsl.core.types.Projections.constructor
import java.time.LocalDateTime

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
data class ErrorResponse(
    val timeStamp: LocalDateTime,
    val status: Int,
    val error: String,
    val code: Int,
    val message: Map<String, String>?
) {
    constructor(status: Int, error: String, code: Int) : this(LocalDateTime.now(), status, error, code, emptyMap())
}