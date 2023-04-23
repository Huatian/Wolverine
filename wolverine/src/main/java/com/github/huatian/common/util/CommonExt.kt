package com.github.huatian.common.util

import android.content.res.Resources

/**
 * description 扩展函数文件
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */

object CommonExt {

    fun Number.px2dp(): Float {
        val f = toFloat()
        val scale: Float = Resources.getSystem().displayMetrics.density
        return (f / scale + 0.5f)
    }

    fun Number.dp2px(): Int {
        val f = toFloat()
        val scale: Float = Resources.getSystem().displayMetrics.density
        return (f * scale + 0.5f).toInt()
    }
}