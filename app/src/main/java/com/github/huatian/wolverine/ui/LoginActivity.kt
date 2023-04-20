package com.github.huatian.wolverine.ui

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import com.github.huatian.common.base.BaseActivity
import com.github.huatian.common.util.SharedPreferencesUtil
import com.github.huatian.common.util.ToastUtil
import com.github.huatian.wolverine.MainActivity
import com.github.huatian.wolverine.R
import com.github.huatian.wolverine.databinding.ActivityLoginBinding
import com.github.huatian.wolverine.entity.UserInfoEntity
import com.github.huatian.wolverine.net.BaseStateObserver
import com.github.huatian.wolverine.util.Constants
import com.github.huatian.wolverine.vm.LoginViewModel

/**
 * description
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */

class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private lateinit var viewModel: LoginViewModel

    override fun getLayoutID(): Int {
        return R.layout.activity_login
    }

    override fun init() {

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        viewModel.userInfo.observe(this, object : BaseStateObserver<UserInfoEntity>(){
            override fun getRespDataSuccess(it: UserInfoEntity) {
                SharedPreferencesUtil.putString(Constants.USER_ID, it.id)
                SharedPreferencesUtil.putString(Constants.USER_NAME, it.nickname)
                SharedPreferencesUtil.putString(Constants.TOKEN, it.token)
                if (it.icon != null) {
                    SharedPreferencesUtil.putString(Constants.HEAD_IMG, it.icon)
                }
                ToastUtil.showMsg("登陆成功！")
                finish()
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            }
        })

        binding.btnLogin.setOnClickListener {
            if (binding.etUser.text!!.isNotEmpty() && binding.etPassword.text!!.isNotEmpty()) {
                viewModel.login(binding.etUser.text.toString(), binding.etPassword.text.toString())
            } else {
                ToastUtil.showMsg("输入有误！")
            }
        }
        binding.btnBack.setOnClickListener { finish() }
    }

}