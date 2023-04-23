package com.github.huatian.common.base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.github.huatian.common.R
import com.github.huatian.common.util.LoadingViewUtil

/**
 * description
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */
abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    val TAG: String = this.javaClass.simpleName
    lateinit var binding: T

    abstract fun getLayoutID(): Int

    abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {

        window.statusBarColor = resources.getColor(R.color.transparent, null)
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.isAppearanceLightStatusBars = true
        WindowCompat.setDecorFitsSystemWindows(window, false)

        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        binding = DataBindingUtil.setContentView(this, getLayoutID())
        init()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
        binding.unbind()
    }

    fun showLoadingDialog() {
        LoadingViewUtil.showLoadingDialog(this, true)
    }

    fun dismissLoadingDialog() {
        LoadingViewUtil.dismissLoadingDialog()
    }
}