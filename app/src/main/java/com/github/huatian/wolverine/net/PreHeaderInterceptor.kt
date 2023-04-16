package com.github.huatian.wolverine.net

import com.github.huatian.common.util.SharedPreferencesUtil
import com.github.huatian.wolverine.util.Constants
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * description
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */
class PreHeaderInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val builder: Request.Builder = request.newBuilder()

        builder.addHeader("Authorization", "Bearer " + SharedPreferencesUtil.getString(Constants.TOKEN)?:"")
        return chain.proceed(builder.build())
    }
}