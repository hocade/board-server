package com.board.boardserver.friendship.adapter.`in`.rest

import com.board.boardserver.common.constant.EndpointPrefix
import com.board.boardserver.common.response.GenericResponse
import com.board.boardserver.friendship.adapter.`in`.rest.dto.FriendShipDto
import com.board.boardserver.friendship.port.`in`.mapper.FriendShipCommandMapper
import com.board.boardserver.friendship.port.`in`.usecase.FriendShipUsecase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
@RestController
@RequestMapping(value = [EndpointPrefix.user + "/friend"])
class FriendShipController(
    private val friendShipUsecase: FriendShipUsecase
) {

    /**
     * 친구 신청
     */
    @PostMapping
    fun create(@RequestBody dto: FriendShipDto.Request): ResponseEntity<GenericResponse<Boolean>> {
        val command = FriendShipCommandMapper.instance.toRequest(dto)
        return GenericResponse.ok(friendShipUsecase.request(command))
    }

    /**
     * 수락, 거절
     */
    @PutMapping
    fun update(@RequestBody dto: FriendShipDto.Update): ResponseEntity<GenericResponse<Boolean>> {
        dto.validation()
        val command = FriendShipCommandMapper.instance.toUpdate(dto)
        return GenericResponse.ok(friendShipUsecase.update(command))
    }

    @DeleteMapping
    fun delete(@RequestBody dto: FriendShipDto.Request): ResponseEntity<GenericResponse<Boolean>> {
        val command = FriendShipCommandMapper.instance.toRequest(dto)
        return GenericResponse.ok(friendShipUsecase.delete(command))
    }
}