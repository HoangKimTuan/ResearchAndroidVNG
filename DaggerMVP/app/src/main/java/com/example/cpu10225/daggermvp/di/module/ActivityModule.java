package com.example.cpu10225.daggermvp.di.module;

import com.example.cpu10225.daggermvp.ui.base.BaseMvpView;
import com.example.cpu10225.daggermvp.ui.comment.CommentMvpPresenter;
import com.example.cpu10225.daggermvp.ui.comment.CommentPresenter;
import com.example.cpu10225.daggermvp.ui.main.MainMvpPresenter;
import com.example.cpu10225.daggermvp.ui.main.MainPresenter;
import com.example.cpu10225.daggermvp.util.anotation.CustomScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by cpu10225 on 14/11/2017.
 */

@Module
public class ActivityModule {
    private BaseMvpView mView;

    public ActivityModule(BaseMvpView mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    BaseMvpView provideBaseMvpView() {
        return mView;
    }

    @Provides
    @CustomScope
    MainMvpPresenter provideMainMvpPresenter(Retrofit retrofit)
    {
        return new MainPresenter<>(retrofit, mView);
    }

    @Provides
    @CustomScope
    CommentMvpPresenter provideCommentMvpPresenter(Retrofit retrofit)
    {
        return new CommentPresenter<>(retrofit, mView);
    }
}
