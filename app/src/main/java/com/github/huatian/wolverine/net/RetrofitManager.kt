package com.github.huatian.wolverine.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * description
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */

object RetrofitManager {

    const val BASE_URL = "https://www.wanandroid.com"

    private var retrofit: Retrofit

    lateinit var service: ServiceApi

    init {

        /*val logInterceptor = HttpLoggingInterceptor {
            Log.d("OkHttp Log : ", it)
        }.setLevel(HttpLoggingInterceptor.Level.BODY)*/

        val okHttpClient = OkHttpClient().newBuilder()
            .callTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .followRedirects(false)
            .cookieJar(MyCookieJar())
//            .addInterceptor(PreHeaderInterceptor())
            .addInterceptor(LogInterceptor())
//            .addInterceptor(ResponseIntercepter())
            .build()

        retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(ServiceApi::class.java)
    }

    fun <T> getService(service: Class<T>): T {
        return retrofit.create(service)
    }
}