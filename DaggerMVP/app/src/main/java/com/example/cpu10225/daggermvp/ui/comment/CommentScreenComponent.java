package com.example.cpu10225.daggermvp.ui.comment;

import com.example.cpu10225.daggermvp.data.component.NetComponent;
import com.example.cpu10225.daggermvp.util.anotation.CustomScope;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by cpu10225 on 14/11/2017.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = {CommentScreenModule.class})
public interface CommentScreenComponent {
    void inject(CommentActivity activity);
}
