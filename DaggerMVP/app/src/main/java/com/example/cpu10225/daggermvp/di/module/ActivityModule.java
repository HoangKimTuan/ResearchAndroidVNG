package com.example.cpu10225.daggermvp.di.module;

import com.example.cpu10225.daggermvp.ui.base.BaseMvpView;
import com.example.cpu10225.daggermvp.ui.comment.CommentMvpPresenter;
import com.example.cpu10225.daggermvp.ui.comment.CommentMvpView;
import com.example.cpu10225.daggermvp.ui.comment.CommentPresenter;
import com.example.cpu10225.daggermvp.ui.comment.like.CommentLikeMvpPresenter;
import com.example.cpu10225.daggermvp.ui.comment.like.CommentLikeMvpView;
import com.example.cpu10225.daggermvp.ui.comment.like.CommentLikePresenter;
import com.example.cpu10225.daggermvp.ui.main.MainMvpPresenter;
import com.example.cpu10225.daggermvp.ui.main.MainMvpView;
import com.example.cpu10225.daggermvp.ui.main.MainPresenter;
import com.example.cpu10225.daggermvp.ui.photo.PhotoMvpPresenter;
import com.example.cpu10225.daggermvp.ui.photo.PhotoMvpView;
import com.example.cpu10225.daggermvp.ui.photo.PhotoPresenter;
import com.example.cpu10225.daggermvp.ui.photo.like.PhotoLikeMvpPresenter;
import com.example.cpu10225.daggermvp.ui.photo.like.PhotoLikeMvpView;
import com.example.cpu10225.daggermvp.ui.photo.like.PhotoLikePresenter;

import dagger.Module;
import dagger.Provides;

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
    MainMvpPresenter<MainMvpView> provideMainMvpPresenter(MainPresenter<MainMvpView> presenter)
    {
        return presenter;
    }

    @Provides
    CommentMvpPresenter<CommentMvpView> provideCommentMvpPresenter(CommentPresenter<CommentMvpView> presenter)
    {
        return presenter;
    }

    @Provides
    CommentLikeMvpPresenter<CommentLikeMvpView> provideCommentLikeMvpPresenter(CommentLikePresenter<CommentLikeMvpView> presenter) {
        return presenter;
    }

    @Provides
    PhotoMvpPresenter<PhotoMvpView> providePhotoMvpPresenter(PhotoPresenter<PhotoMvpView> presenter) {
        return presenter;
    }

    @Provides
    PhotoLikeMvpPresenter<PhotoLikeMvpView> providePhotoLikeMvpPresenter(PhotoLikePresenter<PhotoLikeMvpView> presenter) {
        return presenter;
    }
}
