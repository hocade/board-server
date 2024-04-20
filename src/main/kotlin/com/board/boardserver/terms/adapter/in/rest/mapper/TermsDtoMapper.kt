package com.board.boardserver.terms.adapter.`in`.rest.mapper

import com.board.boardserver.attachment.adapter.`in`.rest.mapper.AttachmentDtoMapper
import com.board.boardserver.terms.adapter.`in`.rest.dto.TermsDto
import com.board.boardserver.terms.domain.Terms
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 4/20/24
 */
@Mapper(uses = [AttachmentDtoMapper::class])
abstract class TermsDtoMapper {
    companion object {
        val instance: TermsDtoMapper = Mappers.getMapper(TermsDtoMapper::class.java)
    }

    @Mapping(target = "file", source = "attachment")
    abstract fun toResponseDto(terms: Terms): TermsDto.Response
}