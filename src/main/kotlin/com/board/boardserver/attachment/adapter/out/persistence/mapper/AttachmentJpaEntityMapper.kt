package com.board.boardserver.attachment.adapter.out.persistence.mapper

import com.board.boardserver.attachment.adapter.out.persistence.entity.AttachmentJpaEntity
import com.board.boardserver.attachment.domain.Attachment
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 4/19/24
 */
@Mapper
abstract class AttachmentJpaEntityMapper {
    companion object {
        val instance: AttachmentJpaEntityMapper = Mappers.getMapper(AttachmentJpaEntityMapper::class.java)
    }

    abstract fun toJpaEntity(domain: Attachment): AttachmentJpaEntity

    abstract fun toDomain(entity: AttachmentJpaEntity): Attachment

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ext", source = "ext")
    @Mapping(target = "uploadFileName", source = "uploadFileName")
    @Mapping(target = "originalFileName", source = "originalFileName")
    @Mapping(target = "resourceUrl", source = "resourceUrl")
    @Mapping(target = "fullPath", source = "fullPath")
    abstract fun toDomain(ext: String, uploadFileName: String, originalFileName: String, resourceUrl: String, fullPath: String): Attachment

}