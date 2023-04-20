package com.github.huatian.wolverine.net

import com.github.huatian.wolverine.entity.ArticleEntity
import com.github.huatian.wolverine.entity.CollectEntity
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

    @GET("article/list/{page}/json")
    suspend fun getArticleList(
        @Path("page") page: Int,
        @Query("page_size") page_size: Int
    ): BaseResp<PageResp<ArticleEntity>>

    @POST("lg/collect/{id}/json")
    suspend fun collect(@Path("id") id: Int): BaseResp<String>

    @POST("lg/uncollect_originId/{id}/json")
    suspend fun unCollect(@Path("id") id: Int): BaseResp<String>

    @GET("lg/collect/list/{page}/json")
    suspend fun getCollectList(
        @Path("page") page: Int,
        @Query("page_size") page_size: Int
    ): BaseResp<PageResp<CollectEntity>>
}