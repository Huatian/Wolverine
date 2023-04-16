package com.github.huatian.common.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * description
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */

typealias vmBLOCK = suspend () -> Unit

open class BaseViewModel : ViewModel() {

    protected fun launch(
        block: vmBLOCK
    ) {
        viewModelScope.launch {
            try {
                block.invoke()
            } catch (e: Exception) {
                onError(e)
            }
        }
    }

    private fun onError(e: Exception) {
        Log.d("onError", "onError: $e")
    }
}

