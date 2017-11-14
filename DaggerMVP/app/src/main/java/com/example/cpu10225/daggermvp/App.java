package com.example.cpu10225.daggermvp;

import android.app.Application;

import com.example.cpu10225.daggermvp.data.component.DaggerNetComponent;
import com.example.cpu10225.daggermvp.data.component.NetComponent;
import com.example.cpu10225.daggermvp.data.module.AppModule;
import com.example.cpu10225.daggermvp.data.module.NetModule;
import com.example.cpu10225.daggermvp.util.AppConstants;

/**
 * Created by cpu10225 on 14/11/2017.
 */

public class App extends Application {
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(AppConstants.BASE_URL))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
