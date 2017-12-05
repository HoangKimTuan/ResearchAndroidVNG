package com.example.cpu10225.kotlinonandroid.di.module

import com.example.cpu10225.kotlinonandroid.util.AppConstants
import dagger.Module
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import com.google.gson.Gson
import javax.inject.Singleton
import dagger.Provides
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import android.app.Application
import android.content.Context
import okhttp3.Cache
import android.preference.PreferenceManager
import android.content.SharedPreferences
import com.example.cpu10225.kotlinonandroid.MyApp
import com.example.cpu10225.kotlinonandroid.data.AppDataManager
import com.example.cpu10225.kotlinonandroid.data.DataManager
import com.example.cpu10225.kotlinonandroid.data.network.AppApiHelper
import com.example.cpu10225.kotlinonandroid.data.network.ApiHelper
import com.example.cpu10225.kotlinonandroid.data.db.AppDbHelper
import com.example.cpu10225.kotlinonandroid.data.db.DbHelper
import com.example.cpu10225.kotlinonandroid.data.prefs.AppPreferencesHelper
import com.example.cpu10225.kotlinonandroid.data.prefs.PreferencesHelper
import com.example.cpu10225.kotlinonandroid.util.annotation.CustomScope


/**
 * Created by cpu10225 on 05/12/2017.
 */

@Module
class ApplicationModule(val mApplication: MyApp) {
    @Provides
    @Singleton
    fun provideContext(): Context = mApplication

    @Provides
    @Singleton
    fun provideApplication(): Application = mApplication

    @Provides
    @Singleton
    fun providesSharedPreferences(application: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Provides
    @Singleton
    fun provideHttpCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(cache: Cache): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.cache(cache)
        return client.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(AppConstants.BASE_URL)
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun providePrefences(appPreferences: AppPreferencesHelper): PreferencesHelper {
        return  appPreferences
    }

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
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }
}