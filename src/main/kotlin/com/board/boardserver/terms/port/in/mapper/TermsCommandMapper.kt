package com.board.boardserver.terms.port.`in`.mapper

import com.board.boardserver.terms.adapter.`in`.rest.dto.TermsDto
import com.board.boardserver.terms.port.`in`.command.TermsCommand
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers
import org.springframework.web.multipart.MultipartFile

/**
 * @author jinwook.kim
 * @since 4/20/24
 */
@Mapper
abstract class TermsCommandMapper {
    companion object {
        val instance: TermsCommandMapper = Mappers.getMapper(TermsCommandMapper::class.java)
    }

    @Mapping(target = "type", source = "dto.type")
    @Mapping(target = "ordinal", source = "dto.ordinal")
    @Mapping(target = "file", source = "file")
    abstract fun toDto(dto: TermsDto.Create, file: MultipartFile): TermsCommand.Create
}