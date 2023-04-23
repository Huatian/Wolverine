package com.github.huatian.wolverine.net

/**
 * 
 * @author WangHuatian <br />
 * email 773512457@qq.com
 * @since 2023/4/9
 */
class BaseResp<T> {
    var errorCode: Int = -1
    var errorMsg: String = ""
    var data: T? = null
    var responseState: ResponseState? = null

    enum class ResponseState {
        REQUEST_START,
        REQUEST_SUCCESS,
        REQUEST_FAILED,
        REQUEST_ERROR
    }
}