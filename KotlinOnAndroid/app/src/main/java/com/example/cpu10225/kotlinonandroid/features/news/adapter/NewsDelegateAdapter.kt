package com.example.cpu10225.kotlinonandroid.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.cpu10225.kotlinonandroid.R
import com.example.cpu10225.kotlinonandroid.commons.RedditNewsItem
import com.example.cpu10225.kotlinonandroid.commons.adapter.ViewType
import com.example.cpu10225.kotlinonandroid.commons.adapter.ViewTypeDelegateAdapter
import com.example.cpu10225.kotlinonandroid.commons.extensions.getFriendlyTime
import com.example.cpu10225.kotlinonandroid.commons.extensions.inflate
import com.example.cpu10225.kotlinonandroid.commons.extensions.loadImg
import kotlinx.android.synthetic.main.news_item.view.*

/**
 * Created by cpu10225 on 04/12/2017.
 */

class NewsDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item)) {

        fun bind(item: RedditNewsItem) = with(itemView) {
            img_thumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()
        }
    }
}