package com.github.huatian.wolverine.ui.fm

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.huatian.common.base.BaseFragment
import com.github.huatian.common.base.BaseVMFragment
import com.github.huatian.common.util.ToastUtil
import com.github.huatian.wolverine.R
import com.github.huatian.wolverine.databinding.FragmentCollectBinding
import com.github.huatian.wolverine.entity.ArticleEntity
import com.github.huatian.wolverine.entity.CollectEntity
import com.github.huatian.wolverine.net.BaseStateObserver
import com.github.huatian.wolverine.net.PageResp
import com.github.huatian.wolverine.ui.adapter.ArticleAdapter
import com.github.huatian.wolverine.ui.adapter.CollectAdapter

class CollectFragment : BaseVMFragment<FragmentCollectBinding>() {

    private lateinit var viewModel: CollectViewModel
    private val dataList = mutableListOf<CollectEntity>()

    private lateinit var articleAdapter: CollectAdapter
    private var rlStatusFlag = 0

    override fun getLayoutID(): Int {
        return R.layout.fragment_collect
    }

    override fun init() {
        viewModel = ViewModelProvider(this)[CollectViewModel::class.java]

        articleAdapter = CollectAdapter(dataList)
        binding.rvCollect.adapter = articleAdapter

        setRefreshLayout()

        articleAdapter.setOnItemClickListener { adapter, view, position ->
            /*val intent = Intent(this, OrderDetailActivity::class.java)
            intent.putExtra("id", dataList[position].id)
            startActivity(intent)*/
        }
    }

    override fun lazyLoad() {
        if (!dataList.isNullOrEmpty()){
            articleAdapter.notifyDataSetChanged()
            if (viewModel.pageList.value!!.data!!.isLast){
                binding.refreshLayout.finishLoadMoreWithNoMoreData()
            }
        }else{
            viewModel.getCollectList(0)
        }
    }

    override fun observe() {
        viewModel.pageList.observe(this, object : BaseStateObserver<PageResp<CollectEntity>>() {

            override fun getRespDataSuccess(it: PageResp<CollectEntity>) {
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
    }

    private fun setRefreshLayout() {
        binding.refreshLayout.setOnRefreshListener {
            dataList.clear()
            rlStatusFlag = 1
            viewModel.getCollectList(0)
        }
        binding.refreshLayout.setOnLoadMoreListener {
            rlStatusFlag = 2
            viewModel.getCollectList(viewModel.pageList.value!!.data!!.curPage + 1)
        }
    }

}