package com.tuanhk;

import android.app.Application;
import android.support.annotation.Nullable;

import com.tuanhk.di.component.ApplicationComponent;
import com.tuanhk.di.component.DaggerApplicationComponent;
import com.tuanhk.di.component.DaggerUserComponent;
import com.tuanhk.di.component.UserComponent;
import com.tuanhk.di.module.ApplicationModule;
import com.tuanhk.di.module.UserModule;

import java.util.Set;

import javax.inject.Inject;

/**
 * Created by cpu10225 on 14/11/2017.
 */

public class TuanHKApp extends Application {
    public static ApplicationComponent mApplicationComponent;
    public static UserComponent mUserComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mUserComponent = DaggerUserComponent.builder()
                .userModule(new UserModule()).build();
    }

    public static ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    public static UserComponent getUserComponent() {
        return mUserComponent;
    }
}
