package com.github.huatian.common.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.github.huatian.common.util.LoadingViewUtil

/**
 * description
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    val TAG: String = this.javaClass.simpleName
    lateinit var binding: T

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    abstract fun getLayoutID(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")
        binding = DataBindingUtil.inflate(inflater, getLayoutID(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
        binding.unbind()
    }

    fun showLoadingDialog() {
        context?.let { LoadingViewUtil.showLoadingDialog(it, true) }
    }

    fun dismissLoadingDialog() {
        LoadingViewUtil.dismissLoadingDialog()
    }
}