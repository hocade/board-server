package com.board.boardserver.user.adapter.`in`.rest

import com.board.boardserver.common.exception.CommonException
import com.board.boardserver.common.exception.enum.CommonExceptionCode
import com.board.boardserver.common.response.GenericResponse
import com.board.boardserver.user.adapter.`in`.rest.dto.UserDto
import com.board.boardserver.user.adapter.`in`.rest.mapper.UserResponseDtoMapper
import com.board.boardserver.user.port.`in`.mapper.UserCommandMapper
import com.board.boardserver.user.port.`in`.usecase.UserUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

/**
 * @author jinwook.kim
 * @since 2/22/24
 */
@RestController
@RequestMapping(value = ["/api/user"])
class UserController(
    private val userUseCase: UserUseCase
) {

    @PostMapping
    fun create(@RequestBody dto: UserDto.Create): ResponseEntity<GenericResponse<UserDto.Response>> {
        val command = UserCommandMapper.instance.toRequestCommand(dto)
        val user = userUseCase.create(command)
        return GenericResponse.ok(UserResponseDtoMapper.instance.toDto(user))
    }

    @GetMapping(value = ["/{id}"])
    fun read(@PathVariable id: Long): ResponseEntity<GenericResponse<UserDto.Response>> {
        val user = userUseCase.findById(id)
        user?.let {
            return GenericResponse.ok(UserResponseDtoMapper.instance.toDto(it))
        }
        throw CommonException(CommonExceptionCode.USER_NOT_FOUND)
    }

    @PutMapping(value = ["/{id}"])
    fun update(@PathVariable id: Long,
               @RequestBody dto: UserDto.Update): ResponseEntity<GenericResponse<UserDto.Response>> {
        val command = UserCommandMapper.instance.toUpdateCommand(id, dto)
        val user = userUseCase.update(command)
        return GenericResponse.ok(UserResponseDtoMapper.instance.toDto(user))
    }

    @PutMapping(value = ["/{id}/profile"])
    fun updateProfile(@PathVariable id: Long,
               @RequestPart file: MultipartFile): ResponseEntity<GenericResponse<UserDto.Response>> {
        val user = userUseCase.updateProfile(id, file)
        return GenericResponse.ok(UserResponseDtoMapper.instance.toDto(user))
    }

    @GetMapping(value = ["/exists"])
    fun exist(email: String): ResponseEntity<GenericResponse<Boolean>> {
        val result = userUseCase.findByEmail(email)
        return GenericResponse.ok(result != null)
    }

}