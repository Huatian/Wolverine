package com.github.huatian.wolverine.util

/**
 * description
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */
class Constants {
    companion object {
        //profile
        const val USER_ID: String = "user_id"
        const val USER_NAME: String = "user_name"
        const val USER_COOKIE: String = "user_cookie"
        const val TOKEN = "token"
        const val USER_PHONE: String = "user_phone"
        const val HEAD_IMG: String = "head_img"

        //http
        const val HTTP_SUCCESS = 0
//        const val HTTP_AUTH_INVALID = 401
        //常用的token过期code为401，现用的wanandroid api 采用 -1001， 具体开发以自己后台服务为准
        const val HTTP_AUTH_INVALID = -1001
    }
}