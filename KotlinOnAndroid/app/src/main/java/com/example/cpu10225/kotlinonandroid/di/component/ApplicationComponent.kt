package com.example.cpu10225.kotlinonandroid.di.component

import android.app.Application
import com.example.cpu10225.kotlinonandroid.MyApp
import com.example.cpu10225.kotlinonandroid.data.DataManager
import com.example.cpu10225.kotlinonandroid.di.module.ApplicationModule
import com.example.cpu10225.kotlinonandroid.util.annotation.CustomScope
import dagger.Component
import javax.inject.Singleton

/**
 * Created by cpu10225 on 05/12/2017.
 */

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(myApp: MyApp)
    fun application(): Application
    fun dataManager(): DataManager
}