package com.github.huatian.wolverine.ui


import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.github.huatian.common.base.BaseActivity
import com.github.huatian.wolverine.MainActivity
import com.github.huatian.wolverine.R
import com.github.huatian.wolverine.databinding.ActivitySplashBinding
import com.github.huatian.wolverine.entity.ProfileEntity
import com.github.huatian.wolverine.net.BaseStateObserver
import com.github.huatian.wolverine.vm.SplashViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    private lateinit var viewModel: SplashViewModel

    override fun getLayoutID(): Int {
        return R.layout.activity_splash
    }

    override fun init() {
        viewModel = ViewModelProvider(this)[SplashViewModel::class.java]

        viewModel.profileData.observe(this, object : BaseStateObserver<ProfileEntity>(null) {

            override fun getRespDataSuccess(it: ProfileEntity) {
                super.getRespDataSuccess(it)

                lifecycleScope.launch{
                    flow {
                        emit(1)
                        delay(1000)
                    }.onCompletion{
                        runOnUiThread {
                            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                            finish()
                        }
                    }.collect()
                }
            }

            override fun getRespDataEnd() {
                super.getRespDataEnd()
                finish()
            }
        })

        viewModel.getProfile()
    }

}