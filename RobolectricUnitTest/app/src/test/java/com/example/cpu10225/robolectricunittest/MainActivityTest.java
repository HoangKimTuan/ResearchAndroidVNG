package com.example.cpu10225.robolectricunittest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.fest.assertions.api.ANDROID.assertThat;

/**
 * Created by cpu10225 on 18/12/2017.
 */

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private MainActivity mActivity;

    @Before
    public void setUp() throws Exception {
        // setup
        mActivity = Robolectric.buildActivity(MainActivity.class).create().get();
    }

    @Test
    public void myActivityAppearsAsExpectedInitially() throws Exception {
        // test
        assertThat(mActivity.mClickMeButton).hasText("Click Me!");
        assertThat(mActivity.mHelloWorldTextView).hasText("Hello world!");
    }

    @Test
    public void clickingClickMeButtonChangesHelloWorldText() throws Exception {
        assertThat(mActivity.mHelloWorldTextView).hasText("Hello world!");
        mActivity.mClickMeButton.performClick();
        assertThat(mActivity.mHelloWorldTextView).hasText("You clicked on button!");
    }

}