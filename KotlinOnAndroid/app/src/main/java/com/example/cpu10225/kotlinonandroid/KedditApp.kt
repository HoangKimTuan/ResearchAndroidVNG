package com.example.cpu10225.kotlinonandroid

import android.app.Application
import com.example.cpu10225.kotlinonandroid.di.AppModule
import com.example.cpu10225.kotlinonandroid.di.news.DaggerNewsComponent
import com.example.cpu10225.kotlinonandroid.di.news.NewsComponent

/**
 * Created by cpu10225 on 05/12/2017.
 */

class KedditApp : Application() {
    companion object {
        lateinit var newsComponent: NewsComponent
    }

    override fun onCreate() {
        super.onCreate()
        newsComponent = DaggerNewsComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}