package com.example.cpu10225.daggermvp.di.component;

import android.app.Application;
import android.content.Context;

import com.example.cpu10225.daggermvp.App;
import com.example.cpu10225.daggermvp.data.DataManager;
import com.example.cpu10225.daggermvp.di.module.ApplicationModule;
import com.example.cpu10225.daggermvp.util.anotation.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by cpu10225 on 17/11/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(App app);
    Application application();
    DataManager dataManager();
    @ApplicationContext
    Context context();
}