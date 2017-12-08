package com.example.cpu10225.kotlinonandroid.di.module

import android.app.Application
import android.content.Context
import com.example.cpu10225.kotlinonandroid.KotlinApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import com.example.cpu10225.kotlinonandroid.data.AppDataManager
import com.example.cpu10225.kotlinonandroid.data.DataManager
import com.example.cpu10225.kotlinonandroid.data.network.AppApiHelper
import com.example.cpu10225.kotlinonandroid.data.network.ApiHelper
import com.example.cpu10225.kotlinonandroid.data.db.AppDbHelper
import com.example.cpu10225.kotlinonandroid.data.db.DbHelper
import android.preference.PreferenceManager
import android.content.SharedPreferences
import com.example.cpu10225.kotlinonandroid.api.NewsAPI
import com.example.cpu10225.kotlinonandroid.api.NewsRestAPI
import com.example.cpu10225.kotlinonandroid.api.RedditApi
import com.example.cpu10225.kotlinonandroid.data.prefs.AppPreferencesHelper
import com.example.cpu10225.kotlinonandroid.data.prefs.PreferencesHelper
import retrofit2.Retrofit


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

    @Provides
    @Singleton
    fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }

    @Provides
    @Singleton
    fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }

    @Provides
    @Singleton
    fun providesSharedPreferences(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    fun provideNewsAPI(redditApi: RedditApi): NewsAPI = NewsRestAPI(redditApi)

    @Provides
    @Singleton
    fun provideRedditApi(retrofit: Retrofit): RedditApi = retrofit.create(RedditApi::class.java)
}