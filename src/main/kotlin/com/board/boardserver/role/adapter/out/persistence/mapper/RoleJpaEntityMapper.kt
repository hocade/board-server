package com.board.boardserver.role.adapter.out.persistence.mapper

import com.board.boardserver.role.domain.Role
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
@Mapper
abstract class RoleJpaEntityMapper {
    companion object {
        val instance: RoleJpaEntityMapper = Mappers.getMapper(RoleJpaEntityMapper::class.java)
    }

    abstract fun toRole(roleJpaEntity: Role): Role
}