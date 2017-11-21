package com.example.cpu10225.daggermvp.ui.comment.like;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cpu10225.daggermvp.R;
import com.example.cpu10225.daggermvp.data.db.model.Comment;
import com.example.cpu10225.daggermvp.ui.base.BaseActivity;
import com.example.cpu10225.daggermvp.ui.comment.CommentAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CommentLikeActivity extends BaseActivity implements CommentLikeMvpView {

    ListView lvCommentLike;
    ArrayList<Comment> list;
    CommentLikeAdapter adapter;

    @Inject
    CommentLikeMvpPresenter<CommentLikeMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_like);

        lvCommentLike = findViewById(R.id.lvCommentLike);
        list = new ArrayList<>();

        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
        mPresenter.getCommentList();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getApplicationContext(), "Error load commment like" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {
        Toast.makeText(getApplicationContext(), "Complete load comment like", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCommentLike(List<Comment> comments) {
        for (int i = 0; i < comments.size(); i++) {
            list.add(comments.get(i));
        }
        adapter = new CommentLikeAdapter(list, this, new CommentLikeAdapter.CommentLikeItemListener() {
            @Override
            public void onRemoveClick(Long id, int index) {
                mPresenter.removeComment(id);
                list.remove(index);
                adapter.notifyDataSetChanged();
            }
        });
        lvCommentLike.setAdapter(adapter);
    }
}
