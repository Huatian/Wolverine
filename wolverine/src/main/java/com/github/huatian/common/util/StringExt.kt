package com.github.huatian.common.util

import org.apache.commons.codec.binary.Hex
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

fun String.isPhone(): Boolean{
    return this.matches(Regex("1[3-9]\\d{9}"))
}

fun String.encodeSha256(key: String): String {
    val sha256Hmac = Mac.getInstance("HmacSHA256")
    val secretKey = SecretKeySpec(key.toByteArray(), "HmacSHA256")
    sha256Hmac.init(secretKey)

    return Hex.encodeHexString(sha256Hmac.doFinal(this.toByteArray()))
}