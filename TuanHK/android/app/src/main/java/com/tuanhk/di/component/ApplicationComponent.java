package com.tuanhk.di.component;

import android.app.Application;
import android.content.Context;

import com.tuanhk.data.DataManager;
import com.tuanhk.di.module.ApplicationModule;
import com.tuanhk.util.anotation.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by cpu10225 on 17/11/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(com.tuanhk.TuanHKApp app);
    Application application();
    DataManager dataManager();
    @ApplicationContext
    Context context();
}