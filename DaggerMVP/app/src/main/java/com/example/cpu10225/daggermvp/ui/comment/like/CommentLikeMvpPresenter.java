package com.example.cpu10225.daggermvp.ui.comment.like;

import com.example.cpu10225.daggermvp.ui.base.BaseMvpPresenter;

/**
 * Created by cpu10225 on 21/11/2017.
 */

public interface CommentLikeMvpPresenter<V extends CommentLikeMvpView> extends BaseMvpPresenter<V> {
    void getCommentList();
    void removeComment(Long id);
}
