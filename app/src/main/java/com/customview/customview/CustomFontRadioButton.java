package com.customview.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;

import com.customview.R;
import com.customview.utils.Constants;


/**
 * CustomFontRadioButton class to support custom fonts in RadioButton
 */
public class CustomFontRadioButton extends AppCompatRadioButton {

    private Context context;

    public CustomFontRadioButton(Context context) {
        super(context);
    }

    public CustomFontRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(attrs);
    }

    public CustomFontRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomFontTextView);
            final String fontName = a.getString(R.styleable.CustomFontTextView_fontText);
            try {
                if (fontName != null) {
                    Typeface myTypeface = Typeface.createFromAsset(context.getAssets(), Constants.ASSETS_FOLDER_FONTS + fontName);
                    setTypeface(myTypeface);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            a.recycle();
        }
    }
}