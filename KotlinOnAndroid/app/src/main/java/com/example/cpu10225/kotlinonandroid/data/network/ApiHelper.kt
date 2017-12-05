package com.example.cpu10225.kotlinonandroid.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by cpu10225 on 05/12/2017.
 */

interface ApiHelper {
    @GET(ApiEndPoint.GET_TOP)
    fun getTop(@Query("after") after: String, @Query("limit") limit: String): Observable<RedditNewsItem>
}