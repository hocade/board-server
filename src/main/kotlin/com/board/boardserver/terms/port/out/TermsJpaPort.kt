package com.board.boardserver.terms.port.out

import com.board.boardserver.terms.domain.Terms

/**
 * @author jinwook.kim
 * @since 4/17/24
 */
interface TermsJpaPort {
    fun save(terms: Terms): Terms
    fun fetchAll(): List<Terms>
}