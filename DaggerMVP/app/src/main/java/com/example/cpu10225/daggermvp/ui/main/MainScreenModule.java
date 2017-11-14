package com.example.cpu10225.daggermvp.ui.main;

import com.example.cpu10225.daggermvp.util.anotation.CustomScope;
import com.example.cpu10225.daggermvp.ui.main.MainScreenContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cpu10225 on 14/11/2017.
 */

@Module
public class MainScreenModule {
    private final MainScreenContract.View mView;

    public MainScreenModule(MainScreenContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    MainScreenContract.View provideMainScreenContractView() {
        return mView;
    }
}
