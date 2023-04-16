package com.github.huatian.wolverine.ui.fm

import androidx.lifecycle.ViewModelProvider
import com.github.huatian.common.base.BaseFragment
import com.github.huatian.wolverine.R
import com.github.huatian.wolverine.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private var viewModel: HomeViewModel? = null

    override fun getLayoutID(): Int {
        return R.layout.fragment_home
    }

    init {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }

}