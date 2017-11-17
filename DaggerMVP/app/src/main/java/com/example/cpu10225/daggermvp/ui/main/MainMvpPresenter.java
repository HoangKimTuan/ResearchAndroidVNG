package com.example.cpu10225.daggermvp.ui.main;

import com.example.cpu10225.daggermvp.ui.base.BaseMvpPresenter;
import com.example.cpu10225.daggermvp.util.anotation.CustomScope;

/**
 * Created by cpu10225 on 17/11/2017.
 */

public interface MainMvpPresenter extends BaseMvpPresenter {
    void loadPost();
    void clickPost(Integer id);
}
