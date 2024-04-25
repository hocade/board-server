package com.board.boardserver.user.adapter.out.persistence.repository

import com.board.boardserver.common.constant.LanguageCodeConstant
import com.board.boardserver.common.exception.CommonException
import com.board.boardserver.common.exception.enum.CommonExceptionCode
import com.board.boardserver.user.adapter.out.persistence.mapper.UserOptionJpaEntityMapper
import com.board.boardserver.user.domain.UserOption
import com.board.boardserver.user.port.`in`.mapper.UserOptionCommandMapper
import com.board.boardserver.user.port.out.UserOptionJpaPort
import org.springframework.stereotype.Component

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
@Component
class UserOptionPersistAdapter(
    private val userOptionRepository: UserOptionRepository,
    private val userRepository: UserRepository
) : UserOptionJpaPort {
    override fun create(userId: Long): UserOption {
        val userJpaEntity = userRepository.findById(userId).orElseThrow{ CommonException(CommonExceptionCode.USER_NOT_FOUND) }
        val userOptionJpaEntity = userOptionRepository.save(UserOptionJpaEntityMapper.instance.toJpaEntity(userJpaEntity, UserOptionCommandMapper.instance.toCreateCommand(LanguageCodeConstant.ko)))
        return UserOptionJpaEntityMapper.instance.toDomain(userOptionJpaEntity)
    }
}