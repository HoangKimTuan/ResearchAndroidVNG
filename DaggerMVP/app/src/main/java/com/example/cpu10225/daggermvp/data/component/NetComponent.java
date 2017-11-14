package com.example.cpu10225.daggermvp.data.component;

import com.example.cpu10225.daggermvp.data.module.AppModule;
import com.example.cpu10225.daggermvp.data.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by cpu10225 on 14/11/2017.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
}
