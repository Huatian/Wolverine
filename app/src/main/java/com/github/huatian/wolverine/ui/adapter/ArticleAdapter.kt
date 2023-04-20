package com.github.huatian.wolverine.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.github.huatian.wolverine.R
import com.github.huatian.wolverine.entity.ArticleEntity

class ArticleAdapter : BaseQuickAdapter<ArticleEntity, BaseViewHolder> {

    constructor(data: MutableList<ArticleEntity>): this(R.layout.item_article, data)

    constructor(layoutResId: Int, data: MutableList<ArticleEntity>):super(layoutResId, data) {}

    override fun convert(holder: BaseViewHolder, item: ArticleEntity) {
        holder.setText(R.id.tv_title, item.title)
        holder.setText(R.id.tv_author, item.author.ifEmpty { "无名" })
        holder.setText(R.id.tv_time, item.niceDate)
        holder.setText(R.id.tv_cate, item.superChapterName)

        holder.setGone(R.id.tv_tag_new, !item.fresh)
        holder.setGone(R.id.tv_tag_pub, item.superChapterId != 408)

        if (item.collect) {
            holder.setImageResource(R.id.iv_collect, R.drawable.ic_favorite)
        } else {
            holder.setImageResource(R.id.iv_collect, R.drawable.ic_favorite_un)
        }
    }
}