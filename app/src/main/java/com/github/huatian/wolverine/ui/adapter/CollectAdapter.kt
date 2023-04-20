package com.github.huatian.wolverine.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.github.huatian.wolverine.R
import com.github.huatian.wolverine.entity.ArticleEntity
import com.github.huatian.wolverine.entity.CollectEntity

class CollectAdapter : BaseQuickAdapter<CollectEntity, BaseViewHolder> {

    constructor(data: MutableList<CollectEntity>): this(R.layout.item_collect, data)

    constructor(layoutResId: Int, data: MutableList<CollectEntity>):super(layoutResId, data) {}

    override fun convert(holder: BaseViewHolder, item: CollectEntity) {
        holder.setText(R.id.tv_title, item.title)
        holder.setText(R.id.tv_author, item.author.ifEmpty { "无名" })
        holder.setText(R.id.tv_time, item.niceDate)
    }
}