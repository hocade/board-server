package com.board.boardserver.friendship.adapter.`in`.rest

import com.board.boardserver.common.constant.EndpointPrefix
import com.board.boardserver.common.response.GenericResponse
import com.board.boardserver.friendship.adapter.`in`.rest.dto.FriendShipDto
import com.board.boardserver.friendship.adapter.`in`.rest.mapper.FriendShipDtoMapper
import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipStatus
import com.board.boardserver.friendship.port.`in`.mapper.FriendShipCommandMapper
import com.board.boardserver.friendship.port.`in`.usecase.FriendShipUseCase
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
@RestController
@RequestMapping(value = [EndpointPrefix.user + "/friend"])
class FriendShipController(
    private val friendShipUseCase: FriendShipUseCase
) {


    /**
     * 친구 목록 조회
     */
    @GetMapping
    fun paging(pageable: Pageable): ResponseEntity<GenericResponse<Page<FriendShipDto.ResponsePaging>>> {
        val page = friendShipUseCase.paging(pageable)
        return GenericResponse.ok(page.map { FriendShipDtoMapper.instance.toResponsePagingDto(it) })
    }

    /**
     * 친구 신청
     */
    @PostMapping
    fun create(@RequestBody dto: FriendShipDto.Request): ResponseEntity<GenericResponse<Boolean>> {
        val command = FriendShipCommandMapper.instance.toRequest(dto)
        return GenericResponse.ok(friendShipUseCase.request(command))
    }

    /**
     * 수락, 거절
     */
    @PutMapping
    fun update(@RequestBody dto: FriendShipDto.Update): ResponseEntity<GenericResponse<Boolean>> {
        dto.validation()
        val command = FriendShipCommandMapper.instance.toUpdate(dto)
        return GenericResponse.ok(friendShipUseCase.update(command))
    }

    /**
     * 친구 삭제
     */
    @DeleteMapping
    fun delete(@RequestBody dto: FriendShipDto.Request): ResponseEntity<GenericResponse<Boolean>> {
        val command = FriendShipCommandMapper.instance.toUpdate(FriendShipDto.Update(dto.friendId, FriendShipStatus.REMOVE))
        return GenericResponse.ok(friendShipUseCase.delete(command))
    }
}