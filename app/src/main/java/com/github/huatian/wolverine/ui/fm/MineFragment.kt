package com.github.huatian.wolverine.ui.fm

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.github.huatian.common.base.BaseVMFragment
import com.github.huatian.wolverine.MainActivity
import com.github.huatian.wolverine.R
import com.github.huatian.wolverine.databinding.FragmentMineBinding
import com.github.huatian.wolverine.entity.ProfileEntity
import com.github.huatian.wolverine.net.BaseStateObserver
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch

class MineFragment : BaseVMFragment<FragmentMineBinding>() {


    private lateinit var viewModel: MineViewModel
    override fun observe() {

    }

    override fun init() {
        viewModel = ViewModelProvider(this)[MineViewModel::class.java]

        viewModel.profileData.observe(this, object : BaseStateObserver<ProfileEntity>() {

            override fun getRespDataStart() {
                showLoadingDialog()
            }

            override fun getRespDataSuccess(it: ProfileEntity) {
                dismissLoadingDialog()
                binding.tvUser.text = it.userInfo.nickname
                binding.tvInfo.text = "lv${it.coinInfo.level}  积分${it.coinInfo.coinCount}"
            }

            override fun getRespDataEnd() {
                dismissLoadingDialog()
            }
        })

        viewModel.getProfile()
    }

    override fun getLayoutID(): Int {
        return R.layout.fragment_mine
    }

}