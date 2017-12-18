package com.example.cpu10225.robolectricunittest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    Button mClickMeButton;
    TextView mHelloWorldTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClickMeButton = (Button) findViewById(R.id.btn_click_me);
        mHelloWorldTextView = (TextView) findViewById(R.id.tv_hello_world);

        mClickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHelloWorldTextView.setText("You clicked on button!");
            }
        });
    }
}
