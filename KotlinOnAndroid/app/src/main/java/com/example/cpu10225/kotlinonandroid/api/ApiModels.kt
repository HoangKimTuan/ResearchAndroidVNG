package com.example.cpu10225.kotlinonandroid.api

import android.provider.MediaStore

/**
 * Created by cpu10225 on 04/12/2017.
 */

class RedditNewsResponse(val data: RedditDataResponse)

class RedditDataResponse(
        val children: List<RedditChildrenResponse>,
        val after: String?,
        val before: String?
)

class RedditChildrenResponse(val data: RedditNewsDataResponse)

class RedditNewsDataResponse(
        val author: String,
        val title:String,
        val num_comments: Int,
        val created: Long,
        val thumbnail: String,
        val url:String
)