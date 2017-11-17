package com.example.cpu10225.daggermvp.ui.main;

import com.example.cpu10225.daggermvp.data.db.Post;
import com.example.cpu10225.daggermvp.ui.base.BaseMvpView;

import java.util.List;

/**
 * Created by cpu10225 on 17/11/2017.
 */

public interface MainMvpView extends BaseMvpView {
    void showError(String message);
    void showComplete();
    void showPost(List<Post> posts);
}
