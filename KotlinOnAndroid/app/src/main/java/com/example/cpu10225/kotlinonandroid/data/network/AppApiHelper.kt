package com.example.cpu10225.kotlinonandroid.data.network

import retrofit2.Retrofit
import rx.Observable
import javax.inject.Singleton
import rx.schedulers.Schedulers
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject


/**
 * Created by cpu10225 on 05/12/2017.
 */

@Singleton
class AppApiHelper
@Inject constructor(private val mRetrofit: Retrofit)
    : ApiHelper {
    override fun getTop(after: String, limit: String): Observable<News> {
        return mRetrofit.create<ApiHelper>(ApiHelper::class.java).getTop(after, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
    }
}