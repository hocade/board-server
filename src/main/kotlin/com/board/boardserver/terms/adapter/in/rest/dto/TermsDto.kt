package com.board.boardserver.terms.adapter.`in`.rest.dto

import com.board.boardserver.attachment.adapter.`in`.rest.dto.AttachmentDto
import com.board.boardserver.terms.adapter.out.persistence.entity.TermsType
import java.io.Serializable

/**
 * @author jinwook.kim
 * @since 4/20/24
 */
sealed class TermsDto() : Serializable {
    data class Create(
        val type: TermsType,
//        val file: MultipartFile,
        val ordinal: Long
    ) : TermsDto()
    data class Response(
        val id: Long,
        val type: TermsType,
        val file: AttachmentDto.Response,
        val ordinal: Long
    ) : TermsDto()
}