package com.github.huatian.wolverine.ui.fm

import androidx.lifecycle.ViewModelProvider
import com.github.huatian.common.base.BaseFragment
import com.github.huatian.common.base.BaseVMFragment
import com.github.huatian.wolverine.R
import com.github.huatian.wolverine.databinding.FragmentHomeBinding

class HomeFragment : BaseVMFragment<FragmentHomeBinding>() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    override fun observe() {

    }

    override fun init() {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_home
    }

}