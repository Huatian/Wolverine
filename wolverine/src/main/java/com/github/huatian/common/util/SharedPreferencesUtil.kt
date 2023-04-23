package com.github.huatian.common.util

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

/**
 * description 键值对存储工具类
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */
object SharedPreferencesUtil {

    private lateinit var context: Application
    private lateinit var preferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    fun init(context: Application){
        SharedPreferencesUtil.context = context
        preferences = SharedPreferencesUtil.context.getSharedPreferences("elem", Context.MODE_PRIVATE)
        editor = preferences.edit()
    }

    // 存入数据
    fun putString(key: String, value: String) {
        editor.putString(key, value)
        editor.commit()
    }

    fun getString(key: String): String? {
        return preferences.getString(key, "")
    }

    // 获取数据
    fun getString(key: String, defaultValue: String): String? {
        return preferences.getString(key, defaultValue)
    }

    // 移除数据
    fun removeSP(key: String) {
        editor.remove(key)
        editor.commit()
    }
}