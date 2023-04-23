package com.github.huatian.wolverine

import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.github.huatian.common.base.BaseActivity
import com.github.huatian.wolverine.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutID(): Int {
        return R.layout.activity_main
    }

    override fun init() {

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        val fragmentNavigator = HideShowFragmentNavigator(this, supportFragmentManager, R.id.nav_host_fragment_activity_main)
//        navController.navigatorProvider.addNavigator(fragmentNavigator)

        binding.navView.setupWithNavController(navController)
    }

}