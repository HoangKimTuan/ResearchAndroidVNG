package com.example.cpu10225.daggermvp.ui.comment;

import com.example.cpu10225.daggermvp.data.db.model.Comment;
import com.example.cpu10225.daggermvp.ui.base.BaseMvpPresenter;

/**
 * Created by cpu10225 on 17/11/2017.
 */

public interface CommentMvpPresenter<V extends CommentMvpView> extends BaseMvpPresenter<V> {
    void loadComment(Integer postId);
    void insertComment(Comment comment);
}
