package com.example.cpu10225.daggermvp.ui.comment;

import com.example.cpu10225.daggermvp.util.anotation.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cpu10225 on 14/11/2017.
 */

@Module
public class CommentScreenModule {
    private final CommentScreenContract.View mView;

    public CommentScreenModule(CommentScreenContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    CommentScreenContract.View provideCommentScreenContractView() {
        return mView;
    }
}
