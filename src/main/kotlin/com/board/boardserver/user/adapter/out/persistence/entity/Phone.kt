package com.board.boardserver.user.adapter.out.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.io.Serializable

/**
 * @author jinwook.kim
 * @since 3/14/24
 */
@Embeddable
data class Phone(
    @Column(name = "PHONE_COUNTRY_CODE")
    val countryCode: String,
    @Column(name = "PHONE_NATIONAL_NUMBER")
    val nationalNumber: String
) : Serializable