package com.example.cpu10225.daggermvp.ui.base;

import com.example.cpu10225.daggermvp.data.db.Post;
import com.example.cpu10225.daggermvp.service.DataService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cpu10225 on 17/11/2017.
 */

public class BasePresenter<V extends BaseMvpView> implements BaseMvpPresenter {
    private final Retrofit mRetrofit;
    private V mView;

    @Inject
    public BasePresenter(Retrofit retrofit, V mView) {
        this.mRetrofit = retrofit;
        this.mView = mView;
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public V getMvpView() {
        return mView;
    }
}
