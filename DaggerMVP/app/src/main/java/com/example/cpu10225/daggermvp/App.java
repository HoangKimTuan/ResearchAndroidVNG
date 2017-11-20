package com.example.cpu10225.daggermvp;

import android.app.Application;

import com.example.cpu10225.daggermvp.di.component.ApplicationComponent;
import com.example.cpu10225.daggermvp.di.component.DaggerApplicationComponent;
import com.example.cpu10225.daggermvp.di.module.ApplicationModule;

/**
 * Created by cpu10225 on 14/11/2017.
 */

public class App extends Application {
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
