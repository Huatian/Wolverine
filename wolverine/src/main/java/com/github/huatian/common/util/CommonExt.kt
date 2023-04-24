package com.github.huatian.common.util

import android.content.res.Resources
import java.text.SimpleDateFormat
import java.util.*

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

fun Long.toDateTime(timeStamp: Long): String{
    val date = Date(timeStamp)
    val pattern = "yyyy-MM-dd HH:mm:ss"
    val simpleDateFormat = SimpleDateFormat(pattern, Locale.CHINA)
    return simpleDateFormat.format(date)
}
