package com.example.cpu10225.daggermvp.ui.comment;

import com.example.cpu10225.daggermvp.data.db.Comment;
import com.example.cpu10225.daggermvp.data.db.Post;
import com.example.cpu10225.daggermvp.service.DataService;
import com.example.cpu10225.daggermvp.ui.base.BaseMvpView;
import com.example.cpu10225.daggermvp.ui.base.BasePresenter;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cpu10225 on 17/11/2017.
 */

public class CommentPresenter<V extends CommentMvpView> extends BasePresenter implements CommentMvpPresenter {
    private V view;

    public CommentPresenter(Retrofit retrofit, BaseMvpView mView) {
        super(retrofit, mView);
        view = (V) mView;
    }

    @Override
    public void loadComment(Integer postId) {
        getRetrofit().create(DataService.CommentService.class).getCommentList(postId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Comment>>() {
                    @Override
                    public void onCompleted() {
                        view.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Comment> comments) {
                        view.showComment(comments);
                    }
                });
    }
}
