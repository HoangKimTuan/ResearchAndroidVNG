package com.example.cpu10225.daggermvp.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.cpu10225.daggermvp.App;
import com.example.cpu10225.daggermvp.R;
import com.example.cpu10225.daggermvp.di.component.ActivityComponent;
import com.example.cpu10225.daggermvp.di.component.DaggerActivityComponent;
import com.example.cpu10225.daggermvp.di.module.ActivityModule;
import com.example.cpu10225.daggermvp.ui.comment.like.CommentLikeActivity;
import com.example.cpu10225.daggermvp.ui.main.MainActivity;
import com.example.cpu10225.daggermvp.ui.photo.like.PhotoLikeActivity;

/**
 * Created by cpu10225 on 17/11/2017.
 */

public class BaseActivity extends AppCompatActivity implements BaseMvpView {
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((App) getApplication()).getComponent())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_like_comment:
                startActivity(new Intent(this, CommentLikeActivity.class));
                return true;
            case R.id.item_like_photo:
                startActivity(new Intent(this, PhotoLikeActivity.class));
                return true;
            case R.id.item_home:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
