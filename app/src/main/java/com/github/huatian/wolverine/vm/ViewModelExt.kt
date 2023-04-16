package com.github.huatian.wolverine.vm

import android.content.Intent
import android.util.Log
import com.github.huatian.common.base.BaseViewModel
import com.github.huatian.common.util.ToastUtil
import com.github.huatian.wolverine.MyApplication
import com.github.huatian.wolverine.net.BaseResp
import com.github.huatian.wolverine.net.RespStateData
import com.github.huatian.wolverine.ui.LoginActivity
import com.github.huatian.wolverine.util.Constants
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

suspend fun <T> BaseViewModel.request(liveData: RespStateData<T>, block: suspend () -> BaseResp<T>) {

    var result = BaseResp<T>()
    result.responseState = BaseResp.ResponseState.REQUEST_START
    liveData.value = result

    try {

        //---------------------//
        result = block.invoke()
        //---------------------//

        Log.d("BaseRepository", result.errorCode.toString() + "/" + result.errorMsg)
        when (result.errorCode) {
            Constants.HTTP_SUCCESS -> {
                result.responseState = BaseResp.ResponseState.REQUEST_SUCCESS
            }
            Constants.HTTP_AUTH_INVALID -> {
                result.responseState = BaseResp.ResponseState.REQUEST_FAILED
                ToastUtil.showMsg("认证过期，请重新登录！")
                if (MyApplication.instance!!.topAct !is LoginActivity){
                    val intent = Intent(MyApplication.instance!!.topAct, LoginActivity::class.java)
                    MyApplication.instance!!.topAct!!.startActivity(intent)
                }
            }
            else -> {
                result.responseState = BaseResp.ResponseState.REQUEST_FAILED
                ToastUtil.showMsg("code:" + result.errorCode.toString() + " / msg:" + result.errorMsg)
            }
        }

    } catch (e: Exception) {
        Log.d("BaseRepository", "dealResp: Exception$e")
        when (e) {
            is UnknownHostException,
            is HttpException,
            is ConnectException,
            -> {
                //网络error
                ToastUtil.showMsg("网络错误！")
            }
            else -> {
                ToastUtil.showMsg("未知错误！")
            }
        }
        result.responseState = BaseResp.ResponseState.REQUEST_ERROR
    } finally {
        liveData.value = result
    }
}