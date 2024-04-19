package com.board.boardserver.terms.adapter.out.persistence.repository

import com.board.boardserver.terms.adapter.out.persistence.entity.TermsJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author jinwook.kim
 * @since 4/17/24
 */
interface TermsRepository : JpaRepository<TermsJpaEntity, Long> {
}