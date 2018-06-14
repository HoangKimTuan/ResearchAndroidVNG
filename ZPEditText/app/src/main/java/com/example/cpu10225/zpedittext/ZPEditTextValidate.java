package com.example.cpu10225.zpedittext;

import android.content.Context;
import android.support.annotation.NonNull;

public abstract class ZPEditTextValidate {
    private String mErrorMessage;

    public ZPEditTextValidate(@NonNull String errorMessage) {
        this.mErrorMessage = errorMessage;
    }

    @NonNull
    public String getErrorMessage() {
        return mErrorMessage;
    }

    public abstract boolean isValid(@NonNull CharSequence s);

}
