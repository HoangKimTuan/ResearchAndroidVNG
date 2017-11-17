package com.example.cpu10225.daggermvp.ui.comment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cpu10225.daggermvp.R;
import com.example.cpu10225.daggermvp.data.db.Comment;
import com.example.cpu10225.daggermvp.data.db.Post;
import com.example.cpu10225.daggermvp.ui.base.BaseActivity;
import com.example.cpu10225.daggermvp.ui.base.BaseMvpView;
import com.example.cpu10225.daggermvp.ui.main.MainActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CommentActivity extends BaseActivity implements CommentMvpView {
    ListView lvComment;
    ArrayList<Comment> list;
    CommentAdapter adapter;

    @Inject
    CommentMvpPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        lvComment = findViewById(R.id.lvComment);
        list = new ArrayList<>();

        getActivityComponent().inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onIdStickEvent(Integer id) {
        mPresenter.loadComment(id);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getApplicationContext(), "Error load commment" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {
        Toast.makeText(getApplicationContext(), "Complete load comment", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComment(List<Comment> comments) {
        for (int i = 0; i < comments.size(); i++) {
            list.add(comments.get(i));
        }
        adapter = new CommentAdapter(list, this);
        lvComment.setAdapter(adapter);
    }
}
