package com.example.cpu10225.kotlinonandroid.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by cpu10225 on 04/12/2017.
 */

interface RedditApi {
    @GET("/top.json")
    fun getTop(@Query("after") after: String, @Query("limit") limit: String): Call<RedditNewsResponse>
}