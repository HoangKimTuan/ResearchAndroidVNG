package com.example.cpu10225.tooltipandroid;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;

import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;

public class MainActivity extends AppCompatActivity {

    SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences("com.example.cpu10225.tooltipandroid", MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();

//        if (prefs.getBoolean("firstrun", true)) {
            new SimpleTooltip.Builder(this)
                    .anchorView(findViewById(R.id.et_demo))
                    .text(R.string.demo)
                    .gravity(Gravity.BOTTOM)
                    .dismissOnOutsideTouch(true)
                    .dismissOnInsideTouch(false)
                    .build()
                    .show();
            prefs.edit().putBoolean("firstrun", false).commit();
//        }
    }
}
