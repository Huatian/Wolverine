package com.github.huatian.wolverine.ui.fm

import com.github.huatian.common.base.BaseViewModel
import com.github.huatian.wolverine.entity.Article
import com.github.huatian.wolverine.net.PageResp
import com.github.huatian.wolverine.net.RespStateData
import com.github.huatian.wolverine.net.RetrofitManager
import com.github.huatian.wolverine.vm.request

class HomeViewModel : BaseViewModel() {

    val pageList = RespStateData<PageResp<Article>>()

    fun getArticleist(pageNo: Int) {
        launch {
            request(pageList){
                RetrofitManager.service.getArticleList(pageNo, 10)
            }
        }
    }

}