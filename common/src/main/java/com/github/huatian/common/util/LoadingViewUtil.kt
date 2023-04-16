package com.github.huatian.common.util

import android.app.Activity
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.github.huatian.common.R

/**
 * description 加载对话框工具类
 *
 * date 2023/4/9
 * @author WangHuatian <br />
 * email 773512457@qq.com
 */

object LoadingViewUtil {

    private var dialog: AlertDialog? = null

    fun showLoadingDialog(context: Context, isCancel: Boolean) {

        if (context is Activity) {
            if (context.isFinishing) {
                return
            }
        }

        if (dialog == null) {
            val builder = AlertDialog.Builder(context)
            builder.setView(
                LayoutInflater.from(context).inflate(R.layout.dialog_loading, null)
            )

            builder.setCancelable(isCancel)
            dialog = builder.create()

            if (dialog?.window == null) {
                return
            }

            dialog?.window?.setBackgroundDrawable(ColorDrawable(0))
        }

        if (dialog != null && !(dialog!!.isShowing)) {
            dialog!!.show()
        }

    }

    fun dismissLoadingDialog() {
        if (dialog != null && dialog!!.isShowing) {
            dialog?.dismiss()
            dialog = null
        }
    }

}