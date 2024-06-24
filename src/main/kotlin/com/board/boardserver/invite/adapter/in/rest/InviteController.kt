package com.board.boardserver.invite.adapter.in.rest;

import com.board.boardserver.common.constant.EndpointPrefix
import com.board.boardserver.common.response.GenericResponse
import com.board.boardserver.friendship.adapter.`in`.rest.dto.FriendShipDto
import com.board.boardserver.friendship.adapter.`in`.rest.mapper.FriendShipDtoMapper
import com.board.boardserver.friendship.adapter.in.rest.dto.FriendShipDto;
import com.board.boardserver.friendship.adapter.out.persistence.entity.FriendShipStatus;
import com.board.boardserver.friendship.port.`in`.mapper.FriendShipCommandMapper
import com.board.boardserver.friendship.port.`in`.usecase.FriendShipUseCase
import com.board.boardserver.invite.adapter.`in`.rest.mapper.InviteDtoMapper
import com.board.boardserver.invite.adapter.rest.dto.InviteDto
import com.board.boardserver.invite.application.port.command.InviteCommand
import com.board.boardserver.invite.domain.Invite
import com.board.boardserver.invite.port.`in`.mapper.InviteCommandMapper
import com.board.boardserver.invite.port.`in`.usecase.InviteUseCase
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*;

/**
 * @author gihyung.lee
 * @since 2024-06-01
 */
@RestController
@RequestMapping(value = [EndpointPrefix.user + "/invite"])
class InviteController(
    private val inviteUseCase: InviteUseCase
) {
    /**
     * 초대 코드 조회
     */
    @GetMapping
    fun read(userId: Long): ResponseEntity<GenericResponse<InviteDto.Response>> {
        val domain = inviteUseCase.findByUserId(userId)
        return GenericResponse.ok(InviteDtoMapper.instance.toResponseDto(domain))
    }

    /**
     * 초대 코드 입력
     */
    @PostMapping(value = ["/request"])
    fun request(@RequestBody dto: InviteDto.Request):ResponseEntity<GenericResponse<Boolean>> {
        val command = InviteCommandMapper.instance.toRequest(dto)
        return GenericResponse.ok(inviteUseCase.request(command))
    }

    /**
     * 초대 코드 등록
     */
    @PostMapping
    fun create(@RequestBody dto: InviteDto.Create): ResponseEntity<GenericResponse<Invite>> {
        val command = InviteCommandMapper.instance.toCreate(dto)
        val domain = inviteUseCase.create(command);
        return GenericResponse.ok(InviteDtoMapper.instance.toResponseDto(domain))
    }

    /**
     * 초대 코드 갱신
     */
    @PutMapping
    fun update(@RequestBody dto: InviteDto.Update): ResponseEntity<GenericResponse<Boolean>> {
        val command = InviteCommandMapper.instance.toUpdate(dto)
        val domain = inviteUseCase.update(command);
        return GenericResponse.ok(InviteDtoMapper.instance.toResponseDto(domain))
    }


}
