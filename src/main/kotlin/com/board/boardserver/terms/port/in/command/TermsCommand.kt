package com.board.boardserver.terms.port.`in`.command

import com.board.boardserver.terms.adapter.out.persistence.entity.TermsType
import org.springframework.web.multipart.MultipartFile

/**
 * @author jinwook.kim
 * @since 4/20/24
 */
sealed class TermsCommand {
    data class Create(
        val type: TermsType,
        val file: MultipartFile,
        val ordinal: Long
    ) : TermsCommand()
}