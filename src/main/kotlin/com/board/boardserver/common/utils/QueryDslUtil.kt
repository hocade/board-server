package com.board.boardserver.common.utils

import com.querydsl.jpa.JPQLQuery
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.support.Querydsl

/**
 * @author jinwook.kim
 * @since 4/28/24
 */
class QueryDslUtil {
    companion object {
        fun <T> page(queryDsl: Querydsl?, query: JPQLQuery<T>, pageable: Pageable): Page<T> {
            if (queryDsl == null) {
                return PageImpl(emptyList<T>(), pageable, 0L)
            }
            val total: Long = query.fetchCount()
            val list: List<T> = queryDsl.applyPagination(pageable, query).fetch()
            return PageImpl(list, pageable, total)
        }
    }
}