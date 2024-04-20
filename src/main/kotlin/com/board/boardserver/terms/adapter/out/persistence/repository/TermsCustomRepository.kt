package com.board.boardserver.terms.adapter.out.persistence.repository

import com.board.boardserver.terms.adapter.out.persistence.vo.TermsVo

/**
 * @author jinwook.kim
 * @since 4/20/24
 */
interface TermsCustomRepository {
    fun fetchAll(): List<TermsVo>
}