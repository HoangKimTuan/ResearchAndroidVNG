package com.example.cpu10225.kotlinonandroid

import android.app.Application
import com.example.cpu10225.kotlinonandroid.di.component.ApplicationComponent
import com.example.cpu10225.kotlinonandroid.di.component.DaggerApplicationComponent
import com.example.cpu10225.kotlinonandroid.di.module.ApplicationModule

/**
 * Created by cpu10225 on 05/12/2017.
 */

class MyApp : Application() {

    companion object {
        lateinit var mApplicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build();
    }
}