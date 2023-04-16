package com.github.huatian.wolverine

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.github.huatian.common.util.SharedPreferencesUtil
import com.github.huatian.common.util.ToastUtil

/**
 * description
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */

class MyApplication: Application() {

    var topAct: Activity? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        SharedPreferencesUtil.init(this)
        ToastUtil.init(this)

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity) {
                topAct = null
            }

            override fun onActivityResumed(activity: Activity) {
                topAct = activity
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityDestroyed(activity: Activity) {
            }

            override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
            }
        })
    }

    companion object {
        var instance: MyApplication? = null
    }

}