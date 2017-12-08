package com.example.cpu10225.kotlinonandroid.di.component

import com.example.cpu10225.kotlinonandroid.di.module.ActivityModule
import com.example.cpu10225.kotlinonandroid.di.module.AppModule
import com.example.cpu10225.kotlinonandroid.di.module.NetworkModule
import com.example.cpu10225.kotlinonandroid.features.news.NewsFragment
import com.example.cpu10225.kotlinonandroid.ui.news.NewsActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by cpu10225 on 08/12/2017.
 */

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        ActivityModule::class,
        NetworkModule::class)
)
interface MainComponent {
    fun inject(newsFragment: NewsFragment)
    fun inject(newsActivity: NewsActivity)
}