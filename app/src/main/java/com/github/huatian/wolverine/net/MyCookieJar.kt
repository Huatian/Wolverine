package com.github.huatian.wolverine.net

import android.util.Log
import com.github.huatian.common.util.SharedPreferencesUtil
import com.github.huatian.wolverine.util.Constants
import com.google.gson.Gson
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

/**
 * description
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */

class MyCookieJar : CookieJar {

    private val gson = Gson()

    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        val s = SharedPreferencesUtil.getString(Constants.USER_COOKIE)
        if (s != null && s.isNotEmpty()) {
            val l = gson.fromJson(s, CookieBean::class.java).list
            Log.d("OkHttp", "loadForRequest: $l")
            return l
        }
        return arrayListOf()
    }

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        Log.d("OkHttp", "saveFromResponse:1")

        if (!SharedPreferencesUtil.getString(Constants.USER_COOKIE).isNullOrEmpty()) {
            Log.d("OkHttp", "saveFromResponse:2")
            return
        }

        for (item in cookies) {
            if (item.toString().contains("loginUserName")) {
                Log.d("OkHttp", "saveFromResponse:3")
                SharedPreferencesUtil.putString(Constants.USER_COOKIE, gson.toJson(CookieBean(list = cookies)))
                break
            }
        }
    }

}