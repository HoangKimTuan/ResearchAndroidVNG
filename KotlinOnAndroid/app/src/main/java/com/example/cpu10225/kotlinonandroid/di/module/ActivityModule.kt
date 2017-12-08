package com.example.cpu10225.kotlinonandroid.di.module

import com.example.cpu10225.kotlinonandroid.KotlinApp
import com.example.cpu10225.kotlinonandroid.ui.news.NewsMvpPresenter
import com.example.cpu10225.kotlinonandroid.ui.news.NewsMvpView
import com.example.cpu10225.kotlinonandroid.ui.news.NewsPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by cpu10225 on 08/12/2017.
 */

@Module
class ActivityModule() {
    @Provides
    @Singleton
    fun provideNewsMvpPresenter(presenter: NewsPresenter<NewsMvpView>): NewsMvpPresenter<NewsMvpView> = presenter
}