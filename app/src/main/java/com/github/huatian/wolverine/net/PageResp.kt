package com.github.huatian.wolverine.net

/**
 * description
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */
class PageResp<T> {

    var datas: List<T>? = null
    var curPage: Int = 0
    var isLast: Boolean = false
}