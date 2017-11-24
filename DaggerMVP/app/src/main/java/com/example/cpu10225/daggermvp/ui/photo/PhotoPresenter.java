package com.example.cpu10225.daggermvp.ui.photo;

import com.example.cpu10225.daggermvp.data.DataManager;
import com.example.cpu10225.daggermvp.data.db.model.PhotoDb;
import com.example.cpu10225.daggermvp.data.network.model.Album;
import com.example.cpu10225.daggermvp.data.network.model.Photo;
import com.example.cpu10225.daggermvp.data.network.model.Post;
import com.example.cpu10225.daggermvp.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by cpu10225 on 24/11/2017.
 */

public class PhotoPresenter<V extends PhotoMvpView> extends BasePresenter<V> implements PhotoMvpPresenter<V> {

    @Inject
    public PhotoPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void loadPhoto(Integer photoId) {
        getDataManager().getPhotoList(photoId).subscribe(new Observer<List<Photo>>() {
            @Override
            public void onCompleted() {
                getMvpView().showComplete();
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showError(e.getMessage());
            }

            @Override
            public void onNext(List<Photo> photos) {
                getMvpView().showPhoto(photos);
            }
        });
    }

    @Override
    public void insertPhoto(PhotoDb photoDb) {

    }
}
