package com.example.cpu10225.kotlinonandroid.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by cpu10225 on 04/12/2017.
 */

class RestAPI() {
    private val redditApi: RedditApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        redditApi = retrofit.create(RedditApi::class.java)
    }

    fun  getNews(after: String, limit: String):Call<RedditNewsResponse> {
        return redditApi.getTop(after, limit)
    }
}