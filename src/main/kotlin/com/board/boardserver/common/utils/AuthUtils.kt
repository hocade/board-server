package com.board.boardserver.common.utils

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder

/**
 * @author jinwook.kim
 * @since 4/21/24
 */
object AuthUtils {
    fun getAuth(): Authentication = SecurityContextHolder.getContext().authentication
    fun me(email: String) = getAuth().name == email
}