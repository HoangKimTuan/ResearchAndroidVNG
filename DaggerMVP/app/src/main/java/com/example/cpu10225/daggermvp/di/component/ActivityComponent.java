package com.example.cpu10225.daggermvp.di.component;

import com.example.cpu10225.daggermvp.di.module.ActivityModule;
import com.example.cpu10225.daggermvp.ui.comment.CommentActivity;
import com.example.cpu10225.daggermvp.ui.comment.like.CommentLikeActivity;
import com.example.cpu10225.daggermvp.ui.main.MainActivity;
import com.example.cpu10225.daggermvp.ui.photo.PhotoActivity;
import com.example.cpu10225.daggermvp.util.anotation.CustomScope;

import dagger.Component;

/**
 * Created by cpu10225 on 14/11/2017.
 */

@CustomScope
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
    void inject(CommentActivity commentActivity);
    void inject(CommentLikeActivity commentLikeActivity);
    void inject(PhotoActivity photoActivity);
}
