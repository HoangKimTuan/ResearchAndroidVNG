package com.example.cpu10225.zpedittext;

import android.content.Context;
import android.support.annotation.StyleRes;
import android.support.design.widget.TextInputLayout;
import android.widget.Toast;

public class DemoFocus {

    private ZPEditTextFocus mFocus;

    public DemoFocus() {
        mFocus = new ZPEditTextFocus() {
            @Override
            public void handleFocusChange(TextInputLayout textInputLayout, @StyleRes int resId) {
                textInputLayout.setHintTextAppearance(resId);
            }
        };
    }

    public ZPEditTextFocus getFocus() {
        return mFocus;
    }
}
