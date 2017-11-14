package com.example.cpu10225.daggermvp.di;

import com.example.cpu10225.daggermvp.util.anotation.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cpu10225 on 14/11/2017.
 */

@Module
public class ActivityModule {
    private final ActivityContract.View mView;

    public ActivityModule(ActivityContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    ActivityContract.View provideActivityContractView() {
        return mView;
    }
}
