package com.github.huatian.wolverine.entity

data class UserInfoEntity(
    var admin: Boolean,
    var chapterTops: List<Any>,
    var coinCount: Int,
    var collectIds: List<Int>,
    var email: String,
    var icon: String,
    var id: String,
    var nickname: String,
    var password: String,
    var publicName: String,
    var token: String,
    var type: Int,
    var username: String
)

data class CoinInfoEntity(
    var coinCount: Int,
    var level: Int,
    var nickname: String,
    var rank: Int,
    var userId: Long,
    var username: String
)

data class ProfileEntity(
    var coinInfo: CoinInfoEntity,
    var userInfo: UserInfoEntity
)

data class ArticleEntity(
    val author: String,
    val fresh: Boolean,
    val id: Int,
    val link: String,
    var niceDate: String,
    val shareUser: String,
    val title: String,
    val superChapterId: Int,
    val superChapterName: String,
    var collect: Boolean
)

data class CollectEntity(
    val author: String,
    val chapterName: String,
    val niceDate: String,
    val title: String,
    val link: String,
    val id: Int
)