package com.example.cpu10225.kotlinonandroid.di.news

import com.example.cpu10225.kotlinonandroid.di.AppModule
import com.example.cpu10225.kotlinonandroid.di.NetworkModule
import com.example.cpu10225.kotlinonandroid.features.news.NewsFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by cpu10225 on 05/12/2017.
 */

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NewsModule::class,
        NetworkModule::class)
)
interface NewsComponent {
    fun inject(newsFragment: NewsFragment)
}