package com.example.cpu10225.kotlinonandroid.di

import android.content.Context
import com.example.cpu10225.kotlinonandroid.KedditApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by cpu10225 on 05/12/2017.
 */

@Module
class AppModule(val app: KedditApp) {
    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideAplication(): KedditApp = app
}