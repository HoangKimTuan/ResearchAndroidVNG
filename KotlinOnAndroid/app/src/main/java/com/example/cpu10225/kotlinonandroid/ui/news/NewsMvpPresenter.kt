package com.example.cpu10225.kotlinonandroid.ui.news

import com.example.cpu10225.kotlinonandroid.ui.base.BaseMvpPresenter

/**
 * Created by cpu10225 on 08/12/2017.
 */

interface NewsMvpPresenter<V : NewsMvpView> : BaseMvpPresenter<V> {
    fun loadNews(after: String, limit: String)
}