package com.example.cpu10225.daggermvp.di;

import com.example.cpu10225.daggermvp.data.component.NetComponent;
import com.example.cpu10225.daggermvp.ui.comment.CommentActivity;
import com.example.cpu10225.daggermvp.ui.main.MainActivity;
import com.example.cpu10225.daggermvp.util.anotation.CustomScope;

import dagger.Component;

/**
 * Created by cpu10225 on 14/11/2017.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
    void inject(CommentActivity commentActivity);
}
