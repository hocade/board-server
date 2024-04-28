package com.board.boardserver.user.adapter.`in`.rest.dto

import com.board.boardserver.attachment.domain.Attachment
import com.board.boardserver.role.adapter.out.persistence.entity.RoleType
import com.board.boardserver.user.adapter.out.persistence.entity.UserStatus

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
sealed class UserDto {
    data class Create(
        val nickName: String,
        val password: String,
        val email: String,
        val roleType: RoleType?,
        val phone: PhoneDto,
        val terms: List<Long>
    ) : UserDto()
    data class Update(
        val password: String?
    ) : UserDto()
    data class Response(
        val id: Long,
        val nickName: String,
        val email: String,
        val status: UserStatus,
        val profile: Attachment?
    ) : UserDto()
}