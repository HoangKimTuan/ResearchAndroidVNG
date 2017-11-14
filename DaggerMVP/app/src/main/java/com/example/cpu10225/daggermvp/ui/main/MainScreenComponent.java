package com.example.cpu10225.daggermvp.ui.main;

import com.example.cpu10225.daggermvp.data.component.NetComponent;
import com.example.cpu10225.daggermvp.util.anotation.CustomScope;

import dagger.Component;

/**
 * Created by cpu10225 on 14/11/2017.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainActivity activity);
}

