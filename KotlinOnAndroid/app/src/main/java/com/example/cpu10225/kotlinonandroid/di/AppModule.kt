package com.example.cpu10225.kotlinonandroid.di

import android.app.Application
import android.content.Context
import com.example.cpu10225.kotlinonandroid.KotlinApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by cpu10225 on 05/12/2017.
 */

@Module
class AppModule(val app: KotlinApp) {
    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideAplication(): Application = app
}