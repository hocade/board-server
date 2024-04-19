package com.board.boardserver.attachment.domain

/**
 * @author jinwook.kim
 * @since 4/19/24
 */
data class Attachment(
    var id: Long?,
    val ext: String,
    val uploadFileName: String,
    val originalFileName: String,
    val resourceUrl: String,
    val fullPath: String
)