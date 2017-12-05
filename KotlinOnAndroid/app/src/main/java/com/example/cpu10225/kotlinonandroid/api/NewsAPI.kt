package com.example.cpu10225.kotlinonandroid.api

import retrofit2.Call

/**
 * Created by cpu10225 on 05/12/2017.
 */

interface NewsAPI {
    fun getNews(after: String, limit: String): Call<RedditNewsResponse>
}