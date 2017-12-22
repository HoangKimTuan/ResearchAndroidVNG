package com.example.cpu10225.dagger2mockitojunitruleandroidtest;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cpu10225 on 22/12/2017.
 */

@Module
public class MyModule {
    @Provides
    @Singleton
    public RestService provideRestService() {
        return new RestService();
    }

    @Provides
    @Singleton
    public MyPrinter provideMyPrinter() {
        return new MyPrinter();
    }
}