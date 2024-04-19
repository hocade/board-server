package com.board.boardserver.attachment.adapter.`in`.rest.dto

/**
 * @author jinwook.kim
 * @since 4/19/24
 */
sealed class AttachmentDto {
    data class Response(
        var id: Long?,
        val ext: String,
        val uploadFileName: String,
        val originalFileName: String,
        val resourceUrl: String,
        val fullPath: String
    ) : AttachmentDto()
}