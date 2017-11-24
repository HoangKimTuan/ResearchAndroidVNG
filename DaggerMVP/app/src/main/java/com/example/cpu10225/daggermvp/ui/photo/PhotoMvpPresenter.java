package com.example.cpu10225.daggermvp.ui.photo;

import com.example.cpu10225.daggermvp.data.db.model.PhotoDb;
import com.example.cpu10225.daggermvp.ui.base.BaseMvpPresenter;

/**
 * Created by cpu10225 on 24/11/2017.
 */

public interface PhotoMvpPresenter<V extends PhotoMvpView> extends BaseMvpPresenter<V> {
    void loadPhoto(Integer photoId);
    void insertPhoto(PhotoDb photoDb);
}
