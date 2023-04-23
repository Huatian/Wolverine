package com.github.huatian.common.util

import org.apache.commons.codec.binary.Hex
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

/**
 * 加密工具
 * @author WangHuatian <br />
 * email 773512457@qq.com
 * @since 2023/4/23
 */
object Encipher {

    fun encodeSha256(data: String, key: String): String {
        val sha256Hmac = Mac.getInstance("HmacSHA256")
        val secretKey = SecretKeySpec(key.toByteArray(), "HmacSHA256")
        sha256Hmac.init(secretKey)

        return Hex.encodeHexString(sha256Hmac.doFinal(data.toByteArray()))
    }
}