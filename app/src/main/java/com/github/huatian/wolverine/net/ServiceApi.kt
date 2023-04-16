package com.github.huatian.wolverine.net

import com.github.huatian.wolverine.entity.ProfileEntity
import com.github.huatian.wolverine.entity.UserInfoEntity
import retrofit2.http.*

/**
 * description
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */

interface ServiceApi {

    @FormUrlEncoded
    @POST("/user/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): BaseResp<UserInfoEntity>

    @POST("/user/lg/userinfo/json")
    suspend fun getProfile(): BaseResp<ProfileEntity>
}