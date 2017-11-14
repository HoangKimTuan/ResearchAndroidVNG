package com.example.cpu10225.daggermvp.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cpu10225.daggermvp.App;
import com.example.cpu10225.daggermvp.R;
import com.example.cpu10225.daggermvp.data.db.BaseGetData;
import com.example.cpu10225.daggermvp.data.db.Post;
import com.example.cpu10225.daggermvp.di.ActivityContract;
import com.example.cpu10225.daggermvp.di.ActivityModule;
import com.example.cpu10225.daggermvp.di.DaggerActivityComponent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements ActivityContract.View {
    ListView lvPost;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Inject
    MainScreenPresenter mainScreenPresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPost = findViewById(R.id.lvPost);
        list = new ArrayList<>();

        DaggerActivityComponent.builder()
                .netComponent(((App) getApplicationContext()).getNetComponent())
                .activityModule(new ActivityModule(this))
                .build().inject(this);
        mainScreenPresenter.loadData();
    }

    @Override
    public void showData(List<BaseGetData> listData) {
        for (int i = 0; i < listData.size(); i++) {
            list.add(((Post)listData.get(i)).getTitle());
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        lvPost.setAdapter(adapter);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showComplete() {
        Toast.makeText(getApplicationContext(), "Complete", Toast.LENGTH_LONG).show();
    }
}
