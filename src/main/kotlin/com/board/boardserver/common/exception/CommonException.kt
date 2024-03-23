package com.board.boardserver.common.exception

import com.board.boardserver.common.exception.enum.CommonExceptionCode

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
class CommonException(
    val exceptionCode: CommonExceptionCode
) : RuntimeException() {
}