package com.board.boardserver.terms.adapter.`in`.rest

import com.board.boardserver.common.constant.EndpointPrefix
import com.board.boardserver.common.response.GenericResponse
import com.board.boardserver.terms.adapter.`in`.rest.dto.TermsDto
import com.board.boardserver.terms.adapter.`in`.rest.mapper.TermsDtoMapper
import com.board.boardserver.terms.port.`in`.usecase.TermsUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author jinwook.kim
 * @since 4/17/24
 */
@RestController
@RequestMapping(value = [EndpointPrefix.guest + "/terms"])
class GuestTermsController(
    private val termsUseCase: TermsUseCase
) {

    @GetMapping
    fun fetch(): ResponseEntity<GenericResponse<List<TermsDto.Response>>> {
        val result = termsUseCase.fetchAll()
        return GenericResponse.ok(result.map { TermsDtoMapper.instance.toResponseDto(it) }.toList())
    }
}