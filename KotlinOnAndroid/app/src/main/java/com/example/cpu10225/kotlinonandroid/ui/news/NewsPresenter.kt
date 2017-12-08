package com.example.cpu10225.kotlinonandroid.ui.news

import com.example.cpu10225.kotlinonandroid.data.DataManager
import com.example.cpu10225.kotlinonandroid.ui.base.BasePresenter
import javax.inject.Inject

/**
 * Created by cpu10225 on 08/12/2017.
 */

class NewsPresenter<V : NewsMvpView> @Inject constructor(mDataManager: DataManager) : BasePresenter<V>(mDataManager), NewsMvpPresenter<V> {

    override fun loadNews(after: String, limit: String) {
        getDataManager().getTop(after, limit).subscribe(
                {
                    news -> {}
                }
        )
    }
}