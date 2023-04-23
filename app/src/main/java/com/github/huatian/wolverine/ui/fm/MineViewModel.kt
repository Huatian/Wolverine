package com.github.huatian.wolverine.ui.fm

import com.github.huatian.common.base.BaseViewModel
import com.github.huatian.wolverine.entity.ProfileEntity
import com.github.huatian.wolverine.net.RespStateData
import com.github.huatian.wolverine.net.RetrofitManager
import com.github.huatian.wolverine.vm.request

class MineViewModel : BaseViewModel() {

    var profileData = RespStateData<ProfileEntity>()

    fun getProfile(){
        launch {
            request(profileData){
                RetrofitManager.service.getProfile()
            }
        }
    }
}