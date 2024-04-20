package com.board.boardserver.terms.adapter.`in`.rest

import com.board.boardserver.common.constant.EndpointPrefix
import com.board.boardserver.common.response.GenericResponse
import com.board.boardserver.terms.adapter.`in`.rest.dto.TermsDto
import com.board.boardserver.terms.adapter.`in`.rest.mapper.TermsDtoMapper
import com.board.boardserver.terms.port.`in`.mapper.TermsCommandMapper
import com.board.boardserver.terms.port.`in`.usecase.TermsUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

/**
 * @author jinwook.kim
 * @since 4/20/24
 */
@RestController
@RequestMapping(value = [EndpointPrefix.admin + "/terms"])
class AdminTermsController(
    private val termsUseCase: TermsUseCase
) {
    @PostMapping
    fun create(@RequestPart file: MultipartFile, @RequestPart dto: TermsDto.Create): ResponseEntity<GenericResponse<TermsDto.Response>> {
        val terms = termsUseCase.create(TermsCommandMapper.instance.toDto(dto, file))
        return GenericResponse.ok(TermsDtoMapper.instance.toResponseDto(terms))
    }
}