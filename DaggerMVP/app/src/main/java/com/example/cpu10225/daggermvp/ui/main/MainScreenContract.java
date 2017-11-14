package com.example.cpu10225.daggermvp.ui.main;

import com.example.cpu10225.daggermvp.data.Post;

import java.util.List;

/**
 * Created by cpu10225 on 14/11/2017.
 */

public interface MainScreenContract {
    interface View {
        void showPosts(List<Post> posts);
        void showError(String message);
        void showComplete();
    }

    interface Presenter {
        void loadPost();
    }
}
