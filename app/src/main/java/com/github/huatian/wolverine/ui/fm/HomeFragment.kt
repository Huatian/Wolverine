package com.github.huatian.wolverine.ui.fm

import androidx.lifecycle.ViewModelProvider
import com.github.huatian.common.base.BaseFragment
import com.github.huatian.common.base.BaseVMFragment
import com.github.huatian.wolverine.R
import com.github.huatian.wolverine.databinding.FragmentHomeBinding
import com.github.huatian.wolverine.entity.Article
import com.github.huatian.wolverine.ui.adapter.ArticleAdapter

class HomeFragment : BaseVMFragment<FragmentHomeBinding>() {

    private lateinit var viewModel: HomeViewModel
    private val dataList = mutableListOf<Article>()

    private lateinit var articleAdapter: ArticleAdapter
    private var rlStatusFlag = 0

    override fun observe() {

    }

    override fun init() {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_home
    }

}