package com.board.boardserver.common.utils

import java.util.*

/**
 * @author jinwook.kim
 * @since 4/17/24
 */
object RandomCodeUtils {

    fun uuid() = UUID.randomUUID().toString().replace("-", "")
    // 랜덤 6자리 숫자 발급
    fun sixNumberCode() = (0..999999).random().toString().padStart(999999.toString().length, '0')

}