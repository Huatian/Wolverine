package com.github.huatian.wolverine.vm

import com.github.huatian.common.base.BaseViewModel
import com.github.huatian.wolverine.entity.UserInfoEntity
import com.github.huatian.wolverine.net.RespStateData
import com.github.huatian.wolverine.net.RetrofitManager

/**
 * description
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */
class LoginViewModel : BaseViewModel() {

    var userInfo = RespStateData<UserInfoEntity>()

    fun login(username: String, password: String) {
        launch {
            request(userInfo){
                RetrofitManager.service.login(username, password)
            }
        }
    }
}