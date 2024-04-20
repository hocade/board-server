package com.board.boardserver.terms.port.`in`.usecase

import com.board.boardserver.terms.domain.Terms
import com.board.boardserver.terms.port.`in`.command.TermsCommand

/**
* @author jinwook.kim
* @since 4/17/24
*/
interface TermsUseCase {
    fun create(command: TermsCommand.Create): Terms
    fun fetchAll(): List<Terms>
}