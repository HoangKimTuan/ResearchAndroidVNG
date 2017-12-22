package com.example.cpu10225.dagger2mockitojunitruleandroidtest;

import android.app.Application;

/**
 * Created by cpu10225 on 22/12/2017.
 */

public class App extends Application {
    private MyComponent mMyComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mMyComponent = DaggerMyComponent.builder()
                .myModule(new MyModule()).build();
    }

    public MyComponent getComponent() {
        return mMyComponent;
    }
}