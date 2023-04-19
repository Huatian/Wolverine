package com.github.huatian.wolverine.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.github.huatian.wolverine.R
import com.github.huatian.wolverine.entity.Article

class ArticleAdapter : BaseQuickAdapter<Article, BaseViewHolder> {

    constructor(data: MutableList<Article>): this(R.layout.item_article, data)

    constructor(layoutResId: Int, data: MutableList<Article>):super(layoutResId, data) {}

    override fun convert(holder: BaseViewHolder, item: Article) {
        holder.setText(R.id.tv_title, item.title)
        holder.setText(R.id.tv_author, item.author)
        holder.setText(R.id.tv_time, item.niceDate)
        holder.setText(R.id.tv_cate, item.superChapterName)

        holder.setGone(R.id.tv_tag_new, !item.fresh)
        holder.setGone(R.id.tv_tag_pub, item.superChapterId != 408)
    }
}