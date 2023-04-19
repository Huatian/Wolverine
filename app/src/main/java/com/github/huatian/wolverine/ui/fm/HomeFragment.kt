package com.github.huatian.wolverine.ui.fm

import androidx.lifecycle.ViewModelProvider
import com.github.huatian.common.base.BaseVMFragment
import com.github.huatian.common.util.ToastUtil
import com.github.huatian.wolverine.R
import com.github.huatian.wolverine.databinding.FragmentHomeBinding
import com.github.huatian.wolverine.entity.Article
import com.github.huatian.wolverine.ui.adapter.ArticleAdapter

class HomeFragment : BaseVMFragment<FragmentHomeBinding>() {

    private lateinit var viewModel: HomeViewModel
    private val dataList = mutableListOf<Article>()

    private lateinit var articleAdapter: ArticleAdapter
    private var rlStatusFlag = 0

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
    }

    override fun lazyLoad() {
        super.lazyLoad()
        viewModel.getArticleist(0)
    }

    override fun observe() {
        viewModel.pageList.observe(this){
            if (it.data!= null){
                val list = it.data!!.datas
                if (list != null && list.isNotEmpty()){
                    val positionStart = dataList.size
                    dataList.addAll(it.data!!.datas!!)
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

                if (it.data!!.isLast){
                    binding.refreshLayout.finishLoadMoreWithNoMoreData()
                }

                rlStatusFlag = 0
            }
        }
    }

    private fun setRefreshLayout() {
        binding.refreshLayout.setOnRefreshListener {
            dataList.clear()
            rlStatusFlag = 1
            viewModel.getArticleist(0)
        }
        binding.refreshLayout.setOnLoadMoreListener {
            rlStatusFlag = 2
            viewModel.getArticleist(viewModel.pageList.value!!.data!!.curPage + 1)
        }
    }

}