package com.board.boardserver.friendship.adapter.`in`.rest.dto

import com.board.boardserver.common.exception.CommonException
import com.board.boardserver.common.exception.enum.CommonExceptionCode
import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipStatus
import com.board.boardserver.user.adapter.`in`.rest.dto.UserDto

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
sealed class FriendShipDto {
    data class Request(
        val friendId: Long
    ) : FriendShipDto()
    data class Update(
        val friendId: Long,
        val status: FriendShipStatus
    ) : FriendShipDto() {
        fun validation() {
            if (this.status !in FriendShipStatus.requestValue()) {
                throw CommonException(CommonExceptionCode.INVALID_REQUEST)
            }
        }
    }
    data class ResponsePaging(
        val id: Long,
        val status: FriendShipStatus,
        val friend: UserDto.Response
    ) : FriendShipDto()
}