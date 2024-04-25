package com.board.boardserver.user.port.out

import com.board.boardserver.user.domain.UserTerms

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
interface UserTermsJpaPort {
    fun create(userId: Long, termsId: Long): UserTerms
}