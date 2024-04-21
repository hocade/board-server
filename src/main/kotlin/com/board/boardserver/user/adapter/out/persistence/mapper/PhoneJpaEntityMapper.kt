package com.board.boardserver.user.adapter.out.persistence.mapper

import com.board.boardserver.user.adapter.out.persistence.entity.PhoneJpaEntity
import com.board.boardserver.user.domain.Phone
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 4/21/24
 */
@Mapper
abstract class PhoneJpaEntityMapper {
    companion object {
        val instance: PhoneJpaEntityMapper = Mappers.getMapper(PhoneJpaEntityMapper::class.java)
    }

    abstract fun toJpaEntity(phone: Phone): PhoneJpaEntity
}