package com.github.huatian.wolverine.ui.fm

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.huatian.common.base.BaseFragment
import com.github.huatian.wolverine.R
import com.github.huatian.wolverine.databinding.FragmentMineBinding

class MineFragment : BaseFragment<FragmentMineBinding>() {

    companion object {
        fun newInstance() = MineFragment()
    }

    private var viewModel: MineViewModel = ViewModelProvider(this)[MineViewModel::class.java]

    override fun getLayoutID(): Int {
        return R.layout.fragment_mine
    }

    init {

    }

}