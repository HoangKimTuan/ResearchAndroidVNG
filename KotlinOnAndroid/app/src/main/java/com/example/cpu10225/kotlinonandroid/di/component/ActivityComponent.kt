package com.example.cpu10225.kotlinonandroid.di.component

import com.example.cpu10225.kotlinonandroid.di.module.ActivityModule
import com.example.cpu10225.kotlinonandroid.ui.news.NewsActivity
import com.example.cpu10225.kotlinonandroid.util.annotation.CustomScope
import dagger.Component

/**
 * Created by cpu10225 on 05/12/2017.
 */

@CustomScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(newsActivity: NewsActivity)
}