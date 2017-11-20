package com.example.cpu10225.daggermvp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cpu10225.daggermvp.R;
import com.example.cpu10225.daggermvp.data.network.model.Post;
import com.example.cpu10225.daggermvp.ui.base.BaseActivity;
import com.example.cpu10225.daggermvp.ui.comment.CommentActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView {
    ListView lvPost;
    ArrayList<Post> list;
    ArrayAdapter<Post> adapter;

    @Inject
    MainMvpPresenter mPresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPost = findViewById(R.id.lvPost);
        lvPost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mPresenter.clickPost(list.get(i).getId());
                startActivity(new Intent(MainActivity.this, CommentActivity.class));
            }
        });
        list = new ArrayList<>();

        getActivityComponent().inject(this);
        mPresenter.loadPost();
    }

    @Override
    public void showPost(List<Post> posts) {
        for (int i = 0; i < posts.size(); i++) {
            list.add(posts.get(i));
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lvPost.setAdapter(adapter);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getApplicationContext(), "Error load post" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {
        Toast.makeText(getApplicationContext(), "Complete load post", Toast.LENGTH_SHORT).show();
    }
}
