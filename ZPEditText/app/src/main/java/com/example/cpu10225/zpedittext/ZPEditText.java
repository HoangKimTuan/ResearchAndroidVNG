package com.example.cpu10225.zpedittext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.StyleRes;
import android.support.design.widget.TextInputLayout;
import android.support.transition.TransitionManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuanhk on 13/06/2018.
 */

class ZPEditText extends LinearLayout {

    private Context mContext;
    private TextInputLayout textInputLayout;
    private EditText textInputEditText;
    private ImageView imageView;
    private TextView textView;
    private List<ZPEditTextValidate> validators;
    private String floatingLabel;
    private String errorEmpty;
    private String errorValidate;

    public ZPEditText(Context context) {
        this(context, null);
    }

    public ZPEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZPEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.mContext = context;
        initializeView(attrs, defStyleAttr);
    }

    private void initializeView(AttributeSet attrs, int defStyleAttr) {
        if (attrs != null && !isInEditMode()) {
            final TypedArray attributes = mContext.getTheme().obtainStyledAttributes(attrs, R.styleable.ZPEditTextView,
                    defStyleAttr, 0);

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ZPEditText view = (ZPEditText) inflater.inflate(R.layout.fragment_zpedit_text, this);

            textInputLayout = view.findViewById(R.id.floating_label);
            textInputEditText = view.findViewById(R.id.content);
            imageView = view.findViewById(R.id.image_clear);
            textView = view.findViewById(R.id.error_label);

            floatingLabel = attributes.getString(R.styleable.ZPEditTextView_et_hint);
            errorEmpty = attributes.getString(R.styleable.ZPEditTextView_error_message);
            textInputLayout.setHint(floatingLabel);

            textInputLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    if (textInputLayout.getHeight() > 0) {
                        textInputLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                        updateHintPosition(textInputEditText.hasFocus(), !TextUtils.isEmpty(textInputEditText.getText()), false);
                        updateSizeImage(textInputLayout.getHeight());
                        return false;
                    }
                    return true;
                }
            });

            textInputEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    updateHintPosition(hasFocus, !TextUtils.isEmpty(textInputEditText.getText()), true);

                    if (hasFocus) {
                        textInputLayout.setAlpha(1);
                        textInputLayout.setHint(floatingLabel);
                        textView.setVisibility(INVISIBLE);
                        shouldShowImage();
                    } else {
                        if (TextUtils.isEmpty(textInputEditText.getText())) {
                            textInputLayout.setAlpha(0.5f);
                            showErrorEmpty();
                        } else {
                            textInputLayout.setAlpha(1);

                            if (!validate()) {
                                showErrorValidate();
                            }
                        }
                        imageView.setVisibility(GONE);
                    }
                }
            });

            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    textInputEditText.setText("");
                    updateHintPosition(true, !TextUtils.isEmpty(textInputEditText.getText()), true);
                }
            });

            textInputEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    shouldShowImage();
                }
            });
        }
    }

    private void updateHintPosition(Boolean hasFocus, Boolean hasText, Boolean animate) {
        if (animate) {
            TransitionManager.beginDelayedTransition(textInputLayout);
        }
        if (hasFocus || hasText) {
            textInputEditText.setPadding((int) dpFromPx(5), getTextInputLayoutTopSpace() / 2, 0, getTextInputLayoutTopSpace() / 2);
        } else {
            textInputEditText.setPadding((int) dpFromPx(5), (int) dpFromPx(5), 0, getTextInputLayoutTopSpace());
        }
    }

    private void showErrorEmpty() {
        textInputLayout.setHint(floatingLabel);
        textView.setText(errorEmpty);
        textView.setVisibility(VISIBLE);
        defaultHintPosition();
    }

    private void showErrorValidate() {
        textInputLayout.setHint("");
        textView.setText(errorValidate);
        textView.setVisibility(VISIBLE);
    }

    private void defaultHintPosition() {
        textInputEditText.setPadding((int) dpFromPx(5), getTextInputLayoutTopSpace() / 2, 0, getTextInputLayoutTopSpace() / 2);
    }

    private void shouldShowImage() {
        if (!TextUtils.isEmpty(textInputEditText.getText())) {
            imageView.setVisibility(VISIBLE);
        } else {
            imageView.setVisibility(GONE);
        }
    }

    private void updateSizeImage(int height) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.height = height;
        layoutParams.width = height;
        imageView.setLayoutParams(layoutParams);
    }

    private int getTextInputLayoutTopSpace() {
        View currentView = textInputEditText;
        int space = 0;
        do {
            space += currentView.getTop();
            currentView = (View) currentView.getParent();
        } while (currentView.getId() != textInputLayout.getId());
        return (int) (space - dpFromPx(5));
    }

    public static float dpFromPx(float px) {
        return px / Resources.getSystem().getDisplayMetrics().density;
    }

    public static float pxFromDp(float dp) {
        return dp * Resources.getSystem().getDisplayMetrics().density;
    }

    public boolean validate() {
        if (validators == null || validators.isEmpty()) {
            return true;
        }

        CharSequence text = textInputEditText.getText();

        boolean isValid = true;
        for (ZPEditTextValidate validator : validators) {
            isValid = isValid && validator.isValid(text);
            if (!isValid) {
                setError(validator.getErrorMessage());
                break;
            }
        }

//        if (isValid) {
//            setError(null, R.style.ZPEditTextStyle);
//        }

        return isValid;
    }

    public void setError(CharSequence errorText) {
        errorValidate = errorText == null ? floatingLabel : errorText.toString();
    }

    public ZPEditText addValidator(List<ZPEditTextValidate> validators) {
        if (this.validators == null) {
            this.validators = new ArrayList<>();
        }
        this.validators.addAll(validators);
        return this;
    }
}
