package com.board.boardserver.common.utils

import com.board.boardserver.common.exception.CommonException
import com.board.boardserver.common.exception.enum.CommonExceptionCode
import com.board.boardserver.user.domain.Phone
import com.google.i18n.phonenumbers.PhoneNumberUtil

/**
 * @author jinwook.kim
 * @since 4/21/24
 */
object PhoneUtils {
    val unknownRegion = "ZZ"
    fun getInstance() = PhoneNumberUtil.getInstance()
    fun isValid(phone: Phone): Boolean {
        val instance = getInstance()
        val region = instance.getRegionCodeForCountryCode(phone.countryCode.toInt())
        if (unknownRegion == region) {
            throw CommonException(CommonExceptionCode.INVALID_COUNTRY_CODE)
        }
        return getInstance().isPossibleNumber(phone.nationalNumber, region)
    }
}