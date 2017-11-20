package com.example.cpu10225.daggermvp.ui.base;

import com.example.cpu10225.daggermvp.data.DataManager;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by cpu10225 on 17/11/2017.
 */

public class BasePresenter<V extends BaseMvpView> implements BaseMvpPresenter {
    private final DataManager mDataManager;
    private final V mView;

    @Inject
    public BasePresenter(DataManager mDataManager, V mView) {
        this.mDataManager = mDataManager;
        this.mView = mView;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public V getMvpView() {
        return mView;
    }
}
