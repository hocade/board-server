package com.board.boardserver.user.adapter.`in`.rest.dto

import com.board.boardserver.user.adapter.out.persistence.entity.UserAuthenticationType
import jakarta.validation.constraints.NotBlank

/**
 * @author jinwook.kim
 * @since 4/17/24
 * 사용자 본인인증 요청
 */
sealed class UserAuthDto {
    data class Request(
        @field:NotBlank
        val target: String, // 휴대폰 번호, 이메일 등
        val type: UserAuthenticationType
    ) : UserAuthDto()
    data class Response(
        val key: String
    ) : UserAuthDto()
}