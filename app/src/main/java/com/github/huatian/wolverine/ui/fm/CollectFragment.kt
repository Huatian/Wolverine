package com.github.huatian.wolverine.ui.fm

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.huatian.common.base.BaseFragment
import com.github.huatian.common.base.BaseVMFragment
import com.github.huatian.wolverine.R
import com.github.huatian.wolverine.databinding.FragmentCollectBinding

class CollectFragment : BaseVMFragment<FragmentCollectBinding>() {

    companion object {
        fun newInstance() = CollectFragment()
    }

    private lateinit var viewModel: CollectViewModel
    override fun observe() {

    }

    override fun init() {
        viewModel = ViewModelProvider(this)[CollectViewModel::class.java]
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_collect
    }

}