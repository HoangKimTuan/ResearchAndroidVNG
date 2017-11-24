package com.example.cpu10225.daggermvp.data;

import com.example.cpu10225.daggermvp.data.db.DbHelper;
import com.example.cpu10225.daggermvp.data.db.model.Comment;
import com.example.cpu10225.daggermvp.data.db.model.PhotoDb;
import com.example.cpu10225.daggermvp.data.network.ApiHelper;
import com.example.cpu10225.daggermvp.data.network.model.Album;
import com.example.cpu10225.daggermvp.data.network.model.Photo;
import com.example.cpu10225.daggermvp.data.network.model.Post;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by cpu10225 on 20/11/2017.
 */

@Singleton
public class AppDataManager implements DataManager {
    private final DbHelper mDbHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(DbHelper mDbHelper, ApiHelper mApiHelper) {
        this.mDbHelper = mDbHelper;
        this.mApiHelper = mApiHelper;
    }

    @Override
    public Long insertComment(Comment comment) {
        return mDbHelper.insertComment(comment);
    }

    @Override
    public void removeComment(Long id) {
        mDbHelper.removeComment(id);
    }

    @Override
    public Observable<List<Comment>> getAllComment() {
        return mDbHelper.getAllComment();
    }

    @Override
    public Long insertPhoto(PhotoDb photoDb) {
        return mDbHelper.insertPhoto(photoDb);
    }

    @Override
    public void removePhoto(Long id) {
        mDbHelper.removePhoto(id);
    }

    @Override
    public Observable<List<PhotoDb>> getAllPhoto() {
        return mDbHelper.getAllPhoto();
    }

    @Override
    public Observable<List<Post>> getPostList() {
        return mApiHelper.getPostList();
    }

    @Override
    public Observable<List<com.example.cpu10225.daggermvp.data.network.model.Comment>> getCommentList(Integer postId) {
        return mApiHelper.getCommentList(postId);
    }

    @Override
    public Observable<List<Album>> getAlbumList() {
        return mApiHelper.getAlbumList();
    }

    @Override
    public Observable<List<Photo>> getPhotoList(Integer albumId) {
        return mApiHelper.getPhotoList(albumId);
    }
}
