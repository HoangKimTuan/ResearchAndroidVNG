package com.example.cpu10225.daggermvp.ui.main;

import com.example.cpu10225.daggermvp.ui.base.BaseMvpPresenter;

/**
 * Created by cpu10225 on 17/11/2017.
 */

public interface MainMvpPresenter<V extends MainMvpView> extends BaseMvpPresenter<V> {
    void loadPost();
    void clickPost(Integer id);
}
