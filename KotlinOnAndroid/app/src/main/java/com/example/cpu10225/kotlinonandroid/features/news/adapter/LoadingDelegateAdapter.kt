package com.example.cpu10225.kotlinonandroid.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.cpu10225.kotlinonandroid.R
import com.example.cpu10225.kotlinonandroid.commons.adapter.ViewType
import com.example.cpu10225.kotlinonandroid.commons.adapter.ViewTypeDelegateAdapter
import com.example.cpu10225.kotlinonandroid.commons.extensions.inflate

/**
 * Created by cpu10225 on 01/12/2017.
 */

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {

    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
    (parent.inflate(R.layout.news_item_loading))
}