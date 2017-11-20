package com.example.cpu10225.daggermvp.di.module;

import com.example.cpu10225.daggermvp.ui.base.BaseMvpView;
import com.example.cpu10225.daggermvp.ui.comment.CommentMvpPresenter;
import com.example.cpu10225.daggermvp.ui.comment.CommentMvpView;
import com.example.cpu10225.daggermvp.ui.comment.CommentPresenter;
import com.example.cpu10225.daggermvp.ui.main.MainMvpPresenter;
import com.example.cpu10225.daggermvp.ui.main.MainMvpView;
import com.example.cpu10225.daggermvp.ui.main.MainPresenter;

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
    BaseMvpView provideBaseMvpView() {
        return mView;
    }

    @Provides
    MainMvpPresenter provideMainMvpPresenter(MainPresenter<MainMvpView> presenter)
    {
        return presenter;
    }

    @Provides
    CommentMvpPresenter provideCommentMvpPresenter(CommentPresenter<CommentMvpView> presenter)
    {
        return presenter;
    }
}
