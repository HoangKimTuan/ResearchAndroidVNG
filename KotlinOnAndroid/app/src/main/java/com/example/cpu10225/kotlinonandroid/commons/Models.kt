package com.example.cpu10225.kotlinonandroid.commons

import com.example.cpu10225.kotlinonandroid.commons.adapter.AdapterConstants
import com.example.cpu10225.kotlinonandroid.commons.adapter.ViewType

/**
 * Created by cpu10225 on 01/12/2017.
 */

data class RedditNewsItem (
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}