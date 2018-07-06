package com.example.cpu10225.zpedittext;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class DemoValidate {
    private List<ZPEditTextValidate> mValidates;

    public DemoValidate() {
        mValidates = new ArrayList<>();

        mValidates.add(new ZPEditTextValidate("Chuoi phai lonz hon 1 ky tu") {
            @Override
            public boolean isValid(@NonNull CharSequence s) {
                return s.length() > 1;
            }
        });

    }

    public List<ZPEditTextValidate> getValidates() {
        return mValidates;
    }
}
