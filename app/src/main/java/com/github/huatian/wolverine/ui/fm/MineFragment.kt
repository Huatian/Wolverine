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
import com.github.huatian.wolverine.databinding.FragmentMineBinding

class MineFragment : BaseVMFragment<FragmentMineBinding>() {

    companion object {
        fun newInstance() = MineFragment()
    }

    private lateinit var viewModel: MineViewModel
    override fun observe() {

    }

    override fun init() {
        viewModel = ViewModelProvider(this)[MineViewModel::class.java]
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_mine
    }

}