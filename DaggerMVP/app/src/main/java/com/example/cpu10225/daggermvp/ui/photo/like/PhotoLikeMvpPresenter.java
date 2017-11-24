package com.example.cpu10225.daggermvp.ui.photo.like;

import com.example.cpu10225.daggermvp.ui.base.BaseMvpPresenter;

/**
 * Created by cpu10225 on 24/11/2017.
 */

public interface PhotoLikeMvpPresenter<V extends PhotoLikeMvpView> extends BaseMvpPresenter<V> {
    void getPhotoList();
    void removePhoto(Long id);
}
