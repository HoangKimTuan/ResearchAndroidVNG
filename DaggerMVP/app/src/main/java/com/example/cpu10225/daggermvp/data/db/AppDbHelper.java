package com.example.cpu10225.daggermvp.data.db;

import com.example.cpu10225.daggermvp.data.db.model.Comment;
import com.example.cpu10225.daggermvp.data.db.model.DaoMaster;
import com.example.cpu10225.daggermvp.data.db.model.DaoSession;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by cpu10225 on 20/11/2017.
 */

@Singleton
public class AppDbHelper implements DbHelper {
    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        this.mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public Observable<Long> insertComment(final Comment comment) {
        return Observable.fromCallable(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                return mDaoSession.getCommentDao().insert(comment);
            }
        });
    }

    @Override
    public Observable<List<Comment>> getAllComment() {
        return Observable.fromCallable(new Callable<List<Comment>>() {
            @Override
            public List<Comment> call() throws Exception {
                return mDaoSession.getCommentDao().loadAll();
            }
        });
    }
}
