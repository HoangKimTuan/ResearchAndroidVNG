package com.example.cpu10225.daggermvp.ui.main;

import com.example.cpu10225.daggermvp.data.DataManager;
import com.example.cpu10225.daggermvp.data.network.ApiHelper;
import com.example.cpu10225.daggermvp.data.network.model.Post;
import com.example.cpu10225.daggermvp.ui.base.BaseMvpView;
import com.example.cpu10225.daggermvp.ui.base.BasePresenter;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;

/**
 * Created by cpu10225 on 14/11/2017.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter implements MainMvpPresenter {
    private V view;

    @Inject
    public MainPresenter(DataManager mDataManager, BaseMvpView mView) {
        super(mDataManager, mView);
        view = (V) mView;
    }

    @Override
    public void loadPost() {
        getDataManager().getPostList().subscribe(new Observer<List<Post>>() {
            @Override
            public void onCompleted() {
                view.showComplete();
            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.getMessage());
            }

            @Override
            public void onNext(List<Post> posts) {
                view.showPost(posts);
            }
        });
    }

    @Override
    public void clickPost(Integer id) {
        EventBus.getDefault().postSticky(id);
    }
}
