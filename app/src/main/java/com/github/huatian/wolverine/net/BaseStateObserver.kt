package com.github.huatian.wolverine.net

import android.util.Log
import androidx.lifecycle.Observer

/**
 * description
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */

open class BaseStateObserver<T>(var t: Boolean?) : Observer<BaseResp<T>> {

    override fun onChanged(baseResp: BaseResp<T>) {

        when (baseResp.responseState) {
            BaseResp.ResponseState.REQUEST_START -> {
                Log.d("BaseStateObserver", "Observer: start")
                getRespDataStart()
            }
            BaseResp.ResponseState.REQUEST_SUCCESS -> {
                Log.d("BaseStateObserver", "Observer: success")
                if(baseResp.data==null){
                    getRespSuccess()
                }else{
                    getRespDataSuccess(baseResp.data!!)
                }

            }
            BaseResp.ResponseState.REQUEST_FAILED -> {
                Log.d("BaseStateObserver", "Observer: failed")
                getRespDataEnd()
            }
            BaseResp.ResponseState.REQUEST_ERROR -> {
                Log.d("BaseStateObserver", "Observer: error")
                getRespDataEnd()
            }
            else -> {}
        }
    }

    open fun getRespDataStart() {}
    open fun getRespDataSuccess(it: T) {}
    open fun getRespSuccess() {}
    open fun getRespDataEnd() {}
}