package com.example.cpu10225.kotlinonandroid.di.news

import com.example.cpu10225.kotlinonandroid.api.NewsAPI
import com.example.cpu10225.kotlinonandroid.api.NewsRestAPI
import com.example.cpu10225.kotlinonandroid.api.RedditApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by cpu10225 on 05/12/2017.
 */

@Module
class NewsModule {
    @Provides
    @Singleton
    fun provideNewsAPI(redditApi: RedditApi): NewsAPI {
            return NewsRestAPI(redditApi)
        }

    @Provides
    @Singleton
    fun provideRedditApi(retrofit: Retrofit): RedditApi {
            return retrofit.create(RedditApi::class.java)
        }
}