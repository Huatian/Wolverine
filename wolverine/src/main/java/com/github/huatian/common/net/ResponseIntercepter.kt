package com.github.huatian.common.net

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

/**
 * description
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */

class ResponseIntercepter : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        return kotlin.runCatching { chain.proceed(chain.request()) }
            .onSuccess {
                if (it.isSuccessful) {
                    Log.d("ResponseIntercepter", it.message)
                } else {
                    Log.d("ResponseIntercepter", it.message)
                }
            }
            .onFailure {
                Log.d("ResponseIntercepter", it.message?:"")
            }
            .getOrThrow()
    }
}