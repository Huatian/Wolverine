package com.github.huatian.wolverine.vm

import com.github.huatian.common.base.BaseViewModel
import com.github.huatian.wolverine.entity.ProfileEntity
import com.github.huatian.wolverine.net.RespStateData
import com.github.huatian.wolverine.net.RetrofitManager

/**
 * description
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */

class SplashViewModel : BaseViewModel(){

    var profileData = RespStateData<ProfileEntity>()

    fun getProfile(){
        launch {
            request(profileData){
                RetrofitManager.service.getProfile()
            }
        }
    }

}