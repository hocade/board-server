package com.board.boardserver.invite.port.`in`.mapper

import com.board.boardserver.invite.adapter.rest.dto.InviteDto
import com.board.boardserver.invite.application.port.command.InviteCommand
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

/**
 * @author gihyung.lee
 * @since 2024-06-01
 */
@Mapper
abstract class InviteCommandMapper {
    companion object {
        val instance: InviteCommandMapper = Mappers.getMapper(InviteCommandMapper::class.java)
    }

    abstract fun toRequest(dto: InviteDto.Request): InviteCommand.Request

    abstract fun toCreate(dto: InviteDto.Create): InviteCommand.Create
    abstract fun toUpdate(dto: InviteDto.Update): InviteCommand.Update
}