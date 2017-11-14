package com.example.cpu10225.daggermvp.ui.comment;

import com.example.cpu10225.daggermvp.data.db.Comment;

import java.util.List;

/**
 * Created by cpu10225 on 14/11/2017.
 */

public interface CommentScreenContract {
    interface View {
        void showComments(List<Comment> posts);
        void showError(String message);
        void showComplete();
    }

    interface Presenter {
        void loadComment();
    }
}
