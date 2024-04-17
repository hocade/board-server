package com.board.boardserver.user.port.`in`.mapper

import com.board.boardserver.role.adapter.out.persistence.entity.RoleType
import com.board.boardserver.user.adapter.`in`.rest.dto.UserDto
import com.board.boardserver.user.port.`in`.command.UserCommend
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Named
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 3/23/24
 */
@Mapper
abstract class UserCommandMapper {
    companion object {
        val instance: UserCommandMapper = Mappers.getMapper(UserCommandMapper::class.java)
    }

    @Mapping(target = "roleType", source = ".", qualifiedByName = ["userRole"])
    abstract fun toRequestCommand(dto: UserDto.Create): UserCommend.Create

    /**
     * USER 기본 권한
     */
    @Named("userRole")
    fun userRole(dto: UserDto.Create): RoleType {
        return RoleType.ROLE_USER
    }
}