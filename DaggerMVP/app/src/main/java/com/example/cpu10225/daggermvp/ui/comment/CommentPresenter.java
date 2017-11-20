package com.example.cpu10225.daggermvp.ui.comment;

import com.example.cpu10225.daggermvp.data.DataManager;
import com.example.cpu10225.daggermvp.data.network.ApiHelper;
import com.example.cpu10225.daggermvp.data.network.model.Comment;
import com.example.cpu10225.daggermvp.ui.base.BaseMvpView;
import com.example.cpu10225.daggermvp.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cpu10225 on 17/11/2017.
 */

public class CommentPresenter<V extends CommentMvpView> extends BasePresenter<V> implements CommentMvpPresenter<V> {
    @Inject
    public CommentPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void loadComment(Integer postId) {
        getDataManager().getCommentList(postId).subscribe(new Observer<List<Comment>>() {
            @Override
            public void onCompleted() {
                getMvpView().showComplete();
            }

            @Override
            public void onError(Throwable e) {
                getMvpView().showError(e.getMessage());
            }

            @Override
            public void onNext(List<Comment> comments) {
                getMvpView().showComment(comments);
            }
        });
    }
}
