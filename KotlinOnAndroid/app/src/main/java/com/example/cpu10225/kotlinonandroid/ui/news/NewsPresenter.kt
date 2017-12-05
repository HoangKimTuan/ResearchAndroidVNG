package com.example.cpu10225.kotlinonandroid.ui.news

import com.example.cpu10225.kotlinonandroid.data.DataManager
import com.example.cpu10225.kotlinonandroid.ui.base.BasePresenter
import javax.inject.Inject

/**
 * Created by cpu10225 on 05/12/2017.
 */

class NewsPresenter<V : NewsMvpView> @Inject constructor(mDataManager: DataManager) : BasePresenter<V>(mDataManager), NewsMvpPresenter<V> {
    override fun getNews(after: String, limit: String) {

    }

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
    }
}