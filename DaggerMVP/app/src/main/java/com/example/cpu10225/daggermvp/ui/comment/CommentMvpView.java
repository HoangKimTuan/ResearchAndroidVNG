package com.example.cpu10225.daggermvp.ui.comment;

import com.example.cpu10225.daggermvp.data.network.model.Comment;
import com.example.cpu10225.daggermvp.ui.base.BaseMvpView;

import java.util.List;

/**
 * Created by cpu10225 on 17/11/2017.
 */

public interface CommentMvpView extends BaseMvpView {
    void showError(String message);
    void showComplete();
    void showComment(List<Comment> comments);
}
