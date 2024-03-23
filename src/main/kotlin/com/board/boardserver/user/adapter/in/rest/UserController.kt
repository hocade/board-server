package com.board.boardserver.user.adapter.`in`.rest

import com.board.boardserver.common.response.GenericResponse
import com.board.boardserver.user.adapter.`in`.rest.dto.UserDto
import com.board.boardserver.user.adapter.`in`.rest.mapper.UserResponseDtoMapper
import com.board.boardserver.user.application.port.`in`.mapper.UserCommandMapper
import com.board.boardserver.user.application.port.`in`.usecase.UserUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author jinwook.kim
 * @since 2/22/24
 */
@RestController
@RequestMapping(value = ["/user"])
class UserController(
    private val userUseCase: UserUseCase
) {

    @PostMapping
    fun create(@RequestBody dto: UserDto.CreateUser): ResponseEntity<GenericResponse<UserDto.Response>> {
        val command = UserCommandMapper.instance.toCreateUserCommand(dto)
        val user = userUseCase.create(command)
        return GenericResponse.ok(UserResponseDtoMapper.instance.toDto(user))
    }
}