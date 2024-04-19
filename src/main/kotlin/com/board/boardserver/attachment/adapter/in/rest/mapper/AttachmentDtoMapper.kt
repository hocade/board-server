package com.board.boardserver.attachment.adapter.`in`.rest.mapper

import com.board.boardserver.attachment.adapter.`in`.rest.dto.AttachmentDto
import com.board.boardserver.attachment.domain.Attachment
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 4/19/24
 */
@Mapper
abstract class AttachmentDtoMapper {
    companion object {
        val instance: AttachmentDtoMapper = Mappers.getMapper(AttachmentDtoMapper::class.java)
    }

    abstract fun toDto(attachment: Attachment): AttachmentDto.Response
}