package com.board.boardserver.terms.domain

import com.board.boardserver.attachment.domain.Attachment
import com.board.boardserver.terms.adapter.out.persistence.entity.TermsType

/**
* @author jinwook.kim
* @since 4/17/24
*/
data class Terms(
    val id: Long?,
    val type: TermsType,
    val attachment: Attachment,
    val ordinal: Long
)