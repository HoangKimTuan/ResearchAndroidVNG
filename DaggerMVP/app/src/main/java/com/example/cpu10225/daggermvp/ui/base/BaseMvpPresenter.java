package com.example.cpu10225.daggermvp.ui.base;

/**
 * Created by cpu10225 on 17/11/2017.
 */

public interface BaseMvpPresenter<V extends BaseMvpView> {
    void onAttach(V mvpView);
    void onDetach();
}
