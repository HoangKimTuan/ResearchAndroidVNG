package com.example.cpu10225.daggermvp.ui.main;

import com.example.cpu10225.daggermvp.data.db.BaseGetData;
import com.example.cpu10225.daggermvp.data.db.Post;
import com.example.cpu10225.daggermvp.di.ActivityContract;
import com.example.cpu10225.daggermvp.service.DataService;
import com.example.cpu10225.daggermvp.util.AppConstants;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cpu10225 on 14/11/2017.
 */

public class MainScreenPresenter implements ActivityContract.Presenter {
    Retrofit mRetrofit;
    ActivityContract.View mView;

    @Inject
    public MainScreenPresenter(Retrofit mRetrofit, ActivityContract.View mView) {
        this.mRetrofit = mRetrofit;
        this.mView = mView;
    }

    @Override
    public void loadData() {
        mRetrofit.create(DataService.PostService.class).getPostlist().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Post>>() {
                           @Override
                           public void onCompleted() {
                               mView.showComplete();
                           }

                           @Override
                           public void onError(Throwable e) {
                               mView.showError(e.getMessage());
                           }

                           @Override
                           public void onNext(List<Post> posts) {
                                mView.showData(posts);
                           }
                       }
                );
    }
}
