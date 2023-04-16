package com.github.huatian.common.util

import android.app.Application
import android.widget.Toast

/**
 * description Toast工具类
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */
object ToastUtil {

    lateinit var context:Application

    fun init(context: Application){
        this.context = context
    }

    fun showMsg(str:String){
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show()
    }
}