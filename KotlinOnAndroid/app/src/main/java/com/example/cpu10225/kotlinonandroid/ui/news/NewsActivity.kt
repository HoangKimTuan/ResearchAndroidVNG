package com.example.cpu10225.kotlinonandroid.ui.news

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import com.example.cpu10225.kotlinonandroid.KotlinApp
import com.example.cpu10225.kotlinonandroid.R
import com.example.cpu10225.kotlinonandroid.data.network.Children
import com.example.cpu10225.kotlinonandroid.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_news.*
import javax.inject.Inject

/**
 * Created by cpu10225 on 08/12/2017.
 */

class NewsActivity : BaseActivity(), NewsMvpView {

    @Inject lateinit var mPresenter: NewsMvpPresenter<NewsMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        KotlinApp.mainComponent.inject(this)
        mPresenter.onAttach(this)
        mPresenter.loadNews("", "")
    }

    override fun showError(message: String) {
    }

    override fun showComplete() {
    }

    override fun showNews(childrens: List<Children>) {
    }
}