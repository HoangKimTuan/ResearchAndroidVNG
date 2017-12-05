package com.example.cpu10225.kotlinonandroid.ui.news

import android.os.Bundle
import com.example.cpu10225.kotlinonandroid.MyApp
import com.example.cpu10225.kotlinonandroid.R
import com.example.cpu10225.kotlinonandroid.ui.base.BaseActivity
import javax.inject.Inject

class NewsActivity : BaseActivity(), NewsMvpView {

//    @Inject
//    lateinit var mPresenter: NewsMvpPresenter<NewsMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
    }
}
