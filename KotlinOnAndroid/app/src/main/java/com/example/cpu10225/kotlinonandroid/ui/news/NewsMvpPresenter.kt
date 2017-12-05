package com.example.cpu10225.kotlinonandroid.ui.news

import com.example.cpu10225.kotlinonandroid.data.network.RedditNews
import com.example.cpu10225.kotlinonandroid.ui.base.BaseMvpPresenter
import rx.Observable

/**
 * Created by cpu10225 on 05/12/2017.
 */

interface NewsMvpPresenter<V: NewsMvpView> : BaseMvpPresenter<V> {
    fun getNews(after: String, limit: String = "10")
}