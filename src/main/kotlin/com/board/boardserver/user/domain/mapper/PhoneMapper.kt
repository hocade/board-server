package com.board.boardserver.user.domain.mapper

import com.board.boardserver.user.adapter.`in`.rest.dto.PhoneDto
import com.board.boardserver.user.domain.Phone
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 4/21/24
 */
@Mapper
abstract class PhoneMapper {
    companion object {
        val instance: PhoneMapper = Mappers.getMapper(PhoneMapper::class.java)
    }

    abstract fun toDomain(dto: PhoneDto): Phone
}