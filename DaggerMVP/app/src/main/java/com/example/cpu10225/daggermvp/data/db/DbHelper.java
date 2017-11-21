package com.example.cpu10225.daggermvp.data.db;

import com.example.cpu10225.daggermvp.data.db.model.Comment;

import java.util.List;

import rx.Observable;

/**
 * Created by cpu10225 on 20/11/2017.
 */

public interface DbHelper {
    Long insertComment(final Comment comment);
    void removeComment(final Long id);
    Observable<List<Comment>> getAllComment();
}
