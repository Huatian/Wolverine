package com.github.huatian.wolverine.ui.adapter

import com.github.huatian.wolverine.R
import com.github.huatian.wolverine.entity.Article

class ArticleAdapter : BaseQuickAdapter<Article, BaseViewHolder> {

    constructor(data: MutableList<Article>): this(R.layout.item_article, data)

    constructor(layoutResId: Int, data: MutableList<Article>):super(layoutResId, data) {}

    override fun convert(holder: BaseViewHolder, item: Article) {
        holder.setText(R.id.tv_community_name, item.courtsname)
        holder.setText(R.id.tv_user_no, item.account)
        holder.setText(R.id.tv_time, item.repairstime)

    }
}