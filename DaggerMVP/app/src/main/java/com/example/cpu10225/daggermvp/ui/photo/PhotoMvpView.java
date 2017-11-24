package com.example.cpu10225.daggermvp.ui.photo;

import com.example.cpu10225.daggermvp.data.network.model.Photo;
import com.example.cpu10225.daggermvp.ui.base.BaseMvpView;

import java.util.List;

/**
 * Created by cpu10225 on 24/11/2017.
 */

public interface PhotoMvpView extends BaseMvpView {
    void showError(String message);
    void showComplete();
    void showPhoto(List<Photo> photos);
}
