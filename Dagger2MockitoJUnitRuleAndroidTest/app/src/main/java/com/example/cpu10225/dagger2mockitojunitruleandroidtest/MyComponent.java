package com.example.cpu10225.dagger2mockitojunitruleandroidtest;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by cpu10225 on 22/12/2017.
 */

@Singleton
@Component(modules = MyModule.class)
public interface MyComponent {
    MainService mainService();

    void inject(MainActivity mainActivity);
}