package com.board.boardserver.terms.adapter.out.persistence.mapper

import com.board.boardserver.terms.adapter.out.persistence.entity.TermsJpaEntity
import com.board.boardserver.terms.domain.Terms
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 4/20/24
 */
@Mapper
abstract class TermsJpaEntityMapper {
    companion object {
        val instance: TermsJpaEntityMapper = Mappers.getMapper(TermsJpaEntityMapper::class.java)
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "file", source = "attachment.id")
    abstract fun toJpaEntity(terms: Terms): TermsJpaEntity
}