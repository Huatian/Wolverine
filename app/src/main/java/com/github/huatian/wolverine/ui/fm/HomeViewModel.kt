package com.github.huatian.wolverine.ui.fm

import com.github.huatian.common.base.BaseViewModel
import com.github.huatian.wolverine.entity.ArticleEntity
import com.github.huatian.wolverine.net.PageResp
import com.github.huatian.wolverine.net.RespStateData
import com.github.huatian.wolverine.net.RetrofitManager
import com.github.huatian.wolverine.vm.request

class HomeViewModel : BaseViewModel() {

    val pageList = RespStateData<PageResp<ArticleEntity>>()
    val collectData = RespStateData<String>()

    fun getArticleList(pageNo: Int) {
        launch {
            request(pageList){
                RetrofitManager.service.getArticleList(pageNo, 10)
            }
        }
    }

    fun collect(id: Int) = launch {
        request(collectData){
            RetrofitManager.service.collect(id)
        }
    }
    fun unCollect(id: Int) = launch {
        request(collectData){
            RetrofitManager.service.unCollect(id)
        }
    }

}