package com.github.huatian.common.util

import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.Executors

/**
 * @Package: com.aipuer.feeling
 * @Class: ThreadPool
 * @Author: WangHuatian
 * @Time: 2023/3/9 15:18
 * @Remark: 线程池调度类
 */
class MyExecutorCoroutineDispatcher {

    companion object {
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            Executors.newFixedThreadPool(3).asCoroutineDispatcher()
        }
    }
}