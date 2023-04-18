package com.github.huatian.common.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding

/**
 * description
 *
 * date 2023/4/9
 * @author WangHuatian <br /> 773512457@qq.com
 */
abstract class BaseVMFragment<T : ViewDataBinding> : BaseFragment<T>() {

    private var isFirstLoad: Boolean = true

    abstract fun observe()
    abstract fun init()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        init()
    }

    override fun onResume() {
        super.onResume()
        if (isFirstLoad) {
            isFirstLoad = false
            lazyLoad()
        }
    }

    open fun lazyLoad() {}

    open fun resetState() {}
}