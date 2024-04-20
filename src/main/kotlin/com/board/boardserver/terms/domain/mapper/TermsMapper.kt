package com.board.boardserver.terms.domain.mapper

import com.board.boardserver.attachment.adapter.out.persistence.entity.AttachmentJpaEntity
import com.board.boardserver.attachment.domain.Attachment
import com.board.boardserver.terms.adapter.out.persistence.entity.TermsJpaEntity
import com.board.boardserver.terms.domain.Terms
import com.board.boardserver.terms.port.`in`.command.TermsCommand
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 4/20/24
 */
@Mapper
abstract class TermsMapper {
    companion object {
        val instance: TermsMapper = Mappers.getMapper(TermsMapper::class.java)
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ordinal", source = "command.ordinal")
    @Mapping(target = "type", source = "command.type")
    @Mapping(target = "attachment", source = "attachment")
    abstract fun toDomain(command: TermsCommand.Create, attachment: Attachment): Terms

    @Mapping(target = "id", source = "termsJpaEntity.id")
    @Mapping(target = "type", source = "termsJpaEntity.type")
    @Mapping(target = "ordinal", source = "termsJpaEntity.ordinal")
    @Mapping(target = "attachment", source = "attachment")
    abstract fun toDomain(termsJpaEntity: TermsJpaEntity, attachment: AttachmentJpaEntity): Terms
}