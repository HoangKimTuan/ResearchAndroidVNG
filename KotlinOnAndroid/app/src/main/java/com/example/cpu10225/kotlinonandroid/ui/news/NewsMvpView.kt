package com.example.cpu10225.kotlinonandroid.ui.news

import com.example.cpu10225.kotlinonandroid.data.network.Children
import com.example.cpu10225.kotlinonandroid.ui.base.BaseMvpView

/**
 * Created by cpu10225 on 08/12/2017.
 */

interface NewsMvpView : BaseMvpView {
    fun showError(message: String)
    fun showComplete()
    fun showNews(childrens: List<Children>)
}