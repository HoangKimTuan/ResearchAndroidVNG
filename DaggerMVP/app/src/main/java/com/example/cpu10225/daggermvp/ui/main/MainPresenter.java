package com.example.cpu10225.daggermvp.ui.main;

import android.content.Intent;

import com.example.cpu10225.daggermvp.data.db.Post;
import com.example.cpu10225.daggermvp.service.DataService;
import com.example.cpu10225.daggermvp.ui.base.BaseMvpView;
import com.example.cpu10225.daggermvp.ui.base.BasePresenter;
import com.example.cpu10225.daggermvp.ui.comment.CommentActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cpu10225 on 14/11/2017.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter implements MainMvpPresenter {
    private V view;

    @Inject
    public MainPresenter(Retrofit retrofit, BaseMvpView mView) {
        super(retrofit, mView);
        view = (V) mView;
    }

    @Override
    public void loadPost() {
        getRetrofit().create(DataService.PostService.class).getPostList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onCompleted() {
                        view.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        view.showPost(posts);
                    }
                });
    }

    @Override
    public void clickPost(Integer id) {
        EventBus.getDefault().postSticky(id);
    }
}
