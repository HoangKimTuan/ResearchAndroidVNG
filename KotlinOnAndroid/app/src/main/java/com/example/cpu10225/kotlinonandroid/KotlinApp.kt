package com.example.cpu10225.kotlinonandroid

import android.app.Application
import com.example.cpu10225.kotlinonandroid.di.component.DaggerMainComponent
import com.example.cpu10225.kotlinonandroid.di.component.MainComponent
import com.example.cpu10225.kotlinonandroid.di.module.AppModule

/**
 * Created by cpu10225 on 08/12/2017.
 */

class KotlinApp: Application() {
    companion object {
        lateinit var mainComponent: MainComponent
    }

    override fun onCreate() {
        super.onCreate()
        mainComponent = DaggerMainComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}