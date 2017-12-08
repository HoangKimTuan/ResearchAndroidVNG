package com.example.cpu10225.kotlinonandroid.api

import retrofit2.Call
import javax.inject.Inject

/**
 * Created by cpu10225 on 04/12/2017.
 */

class NewsRestAPI @Inject constructor(private val redditApi: RedditApi) : NewsAPI {

    override fun getNews(after: String, limit: String): Call<RedditNewsResponse> {
        return redditApi.getTop(after, limit)
    }
}