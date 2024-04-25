package com.board.boardserver.user.adapter.out.persistence.mapper

import com.board.boardserver.user.adapter.out.persistence.entity.UserTermsJpaEntity
import com.board.boardserver.user.adapter.out.persistence.entity.UserTermsJpaEntityId
import com.board.boardserver.user.domain.UserTerms
import com.board.boardserver.user.domain.UserTermsId
import org.mapstruct.*
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 4/25/24
 */
@Mapper
abstract class UserTermsJpaEntityMapper {
    companion object {
        val instance: UserTermsJpaEntityMapper = Mappers.getMapper(UserTermsJpaEntityMapper::class.java)
    }

    @Mapping(target = "id", source = ".", qualifiedByName = ["userTermsId"])
    abstract fun toJpaEntity(userTermsId: UserTermsId): UserTermsJpaEntity

    @Mapping(target = "userId", source = "id.userId")
    @Mapping(target = "termsId", source = "id.termsId")
    abstract fun toDomain(userTerms: UserTermsJpaEntity): UserTerms


    @Named("userTermsId")
    fun userTermsId(userTermsId: UserTermsId): UserTermsJpaEntityId {
        return UserTermsJpaEntityId(userTermsId.userId, userTermsId.termsId)
    }
}