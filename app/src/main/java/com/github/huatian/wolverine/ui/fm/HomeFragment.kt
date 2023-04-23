package com.github.huatian.wolverine.ui.fm

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.github.huatian.common.base.BaseVMFragment
import com.github.huatian.common.util.ToastUtil
import com.github.huatian.wolverine.R
import com.github.huatian.wolverine.databinding.FragmentHomeBinding
import com.github.huatian.wolverine.entity.ArticleEntity
import com.github.huatian.wolverine.net.BaseStateObserver
import com.github.huatian.wolverine.net.PageResp
import com.github.huatian.wolverine.ui.adapter.ArticleAdapter

class HomeFragment : BaseVMFragment<FragmentHomeBinding>() {

    private lateinit var viewModel: HomeViewModel
    private val vm: HomeViewModel by viewModels()
    private val dataList = mutableListOf<ArticleEntity>()

    private lateinit var articleAdapter: ArticleAdapter
    private var rlStatusFlag = 0
    var collectPosition: Int = 0

    override fun getLayoutID(): Int {
        return R.layout.fragment_home
    }
    override fun init() {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        articleAdapter = ArticleAdapter(dataList)
        binding.rvArticle.adapter = articleAdapter

        setRefreshLayout()

        articleAdapter.setOnItemClickListener { adapter, view, position ->
            /*val intent = Intent(this, OrderDetailActivity::class.java)
            intent.putExtra("id", dataList[position].id)
            startActivity(intent)*/
        }
        articleAdapter.addChildClickViewIds(R.id.iv_collect)
        articleAdapter.setOnItemChildClickListener { _, view, position ->
            when (view.id) {
                R.id.iv_collect -> {
                    collectPosition = position
                    if (dataList[collectPosition].collect) {
                        viewModel.unCollect(dataList[collectPosition].id)
                    } else {
                        viewModel.collect(dataList[collectPosition].id)
                    }
                }
            }
        }
    }

    override fun lazyLoad() {
        if (!dataList.isNullOrEmpty()){
            articleAdapter.notifyDataSetChanged()
            if (viewModel.pageList.value!!.data!!.isLast){
                binding.refreshLayout.finishLoadMoreWithNoMoreData()
            }
        }else{
            viewModel.getArticleList(0)
        }
    }

    override fun observe() {
        viewModel.pageList.observe(this, object : BaseStateObserver<PageResp<ArticleEntity>>() {

            override fun getRespDataSuccess(it: PageResp<ArticleEntity>) {
                if (it.datas.isNotEmpty()){
                    val list = it.datas
                    val positionStart = dataList.size
                    dataList.addAll(list)
                    if (positionStart == 0) {
                        articleAdapter.notifyDataSetChanged()
                    } else {
                        articleAdapter.notifyItemRangeInserted( positionStart, list.size)
                    }
                }else{
                    ToastUtil.showMsg("没有查到相关数据")
                    articleAdapter.notifyDataSetChanged()
                }

                if (rlStatusFlag == 1) {
                    binding.refreshLayout.finishRefresh()
                } else if (rlStatusFlag == 2) {
                    binding.refreshLayout.finishLoadMore()
                }

                if (it.isLast){
                    binding.refreshLayout.finishLoadMoreWithNoMoreData()
                }

                rlStatusFlag = 0
            }

            override fun getRespDataEnd() {
                binding.refreshLayout.finishLoadMore(false)
            }
        })

        viewModel.collectData.observe(this, object : BaseStateObserver<String>() {
            override fun getRespDataStart() {
                showLoadingDialog()
            }

            override fun getRespDataEnd() {
                dismissLoadingDialog()
            }

            override fun getRespSuccess() {
                dismissLoadingDialog()
                if (dataList[collectPosition].collect) {
                    ToastUtil.showMsg("取消收藏！")
                    dataList[collectPosition].collect = false
                } else {
                    ToastUtil.showMsg("收藏成功！")
                    dataList[collectPosition].collect = true
                }
                articleAdapter.notifyItemChanged(collectPosition)
            }
        })
    }

    private fun setRefreshLayout() {
        binding.refreshLayout.setOnRefreshListener {
            dataList.clear()
            rlStatusFlag = 1
            viewModel.getArticleList(0)
        }
        binding.refreshLayout.setOnLoadMoreListener {
            rlStatusFlag = 2
            viewModel.getArticleList(viewModel.pageList.value!!.data!!.curPage + 1)
        }
    }

}