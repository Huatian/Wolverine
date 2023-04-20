package com.github.huatian.wolverine.ui.fm

import com.github.huatian.common.base.BaseViewModel
import com.github.huatian.wolverine.entity.CollectEntity
import com.github.huatian.wolverine.net.PageResp
import com.github.huatian.wolverine.net.RespStateData
import com.github.huatian.wolverine.net.RetrofitManager
import com.github.huatian.wolverine.vm.request

class CollectViewModel : BaseViewModel() {

    val pageList = RespStateData<PageResp<CollectEntity>>()

    fun getCollectList(pageNo: Int) {
        launch {
            request(pageList){
                RetrofitManager.service.getCollectList(pageNo, 10)
            }
        }
    }
}