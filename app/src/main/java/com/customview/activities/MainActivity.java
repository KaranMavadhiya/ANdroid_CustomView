package com.customview.activities;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.customview.R;
import com.customview.customview.CustomTypeFaceSpan;
import com.customview.utils.Constants;

public class MainActivity extends BaseActivity {

    @Override
    public int getActivityView() {
        return R.layout.activity_main;
    }

    @Override
    public void initializeComponents() {

        TextView tvSpannableText = (TextView) findViewById(R.id.tv_spannable_string);
        tvSpannableText.setText("This is example of custom SpannableString Light Regular Bold Italics Semi-Bold Semi-Bold-Italic Underline Strike click");
        tvSpannableText.setMovementMethod(LinkMovementMethod.getInstance());
        applySpan(tvSpannableText);

        EditText tvFirstName = (EditText) findViewById(R.id.edit_first_name);
        tvFirstName.setSelection(tvFirstName.getText().toString().length());

    }

    private void applySpan(TextView textView) {

        SpannableString spannableString = new SpannableString(textView.getText().toString());

        int startIndexLight = textView.getText().toString().indexOf("Light");
        int endIndexLight = startIndexLight + "Light".length();
        // change text font style
        spannableString.setSpan(new CustomTypeFaceSpan("", Typeface.createFromAsset(getAssets(), Constants.ASSETS_FOLDER_FONTS + getString(R.string.Muli_Light))), startIndexLight, endIndexLight, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        int startIndexRegular = textView.getText().toString().indexOf("Regular");
        int endIndexRegular = startIndexRegular + "Regular".length();
        // change text font style
        spannableString.setSpan(new CustomTypeFaceSpan("", Typeface.createFromAsset(getAssets(), Constants.ASSETS_FOLDER_FONTS + getString(R.string.Muli_Regular))), startIndexRegular, endIndexRegular, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        int startIndexBold = textView.getText().toString().indexOf("Bold");
        int endIndexBold = startIndexBold + "Bold".length();
        // change text font style
        spannableString.setSpan(new CustomTypeFaceSpan("", Typeface.createFromAsset(getAssets(), Constants.ASSETS_FOLDER_FONTS + getString(R.string.Muli_Bold))), startIndexBold, endIndexBold, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        int startIndexItalics = textView.getText().toString().indexOf("Italics");
        int endIndexItalics = startIndexItalics + "Italics".length();
        // change text font style
        spannableString.setSpan(new CustomTypeFaceSpan("", Typeface.createFromAsset(getAssets(), Constants.ASSETS_FOLDER_FONTS + getString(R.string.Muli_Italic))), startIndexItalics, endIndexItalics, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        int startIndexSemiBold = textView.getText().toString().indexOf("Semi-Bold");
        int endIndexSemiBold = startIndexSemiBold + "Semi-Bold".length();
        // change text font style
        spannableString.setSpan(new CustomTypeFaceSpan("", Typeface.createFromAsset(getAssets(), Constants.ASSETS_FOLDER_FONTS + getString(R.string.Muli_SemiBold))), startIndexSemiBold, endIndexSemiBold, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        int startIndexSemiBoldItalic = textView.getText().toString().indexOf("Semi-Bold-Italic");
        int endIndexSemiBoldItalic = startIndexSemiBoldItalic + "Semi-Bold-Italic".length();
        // change text font style
        spannableString.setSpan(new CustomTypeFaceSpan("", Typeface.createFromAsset(getAssets(), Constants.ASSETS_FOLDER_FONTS + getString(R.string.Muli_SemiBoldItalic))), startIndexSemiBoldItalic, endIndexSemiBoldItalic, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        int startIndexUnderline = textView.getText().toString().indexOf("Underline");
        int endIndexUnderline = startIndexUnderline + "Underline".length();
        // change text font style
        spannableString.setSpan(new UnderlineSpan(), startIndexUnderline, endIndexUnderline, 0);

        int startIndexStrike = textView.getText().toString().indexOf("Strike");
        int endIndexStrike = startIndexStrike + "Strike".length();
        spannableString.setSpan(new StrikethroughSpan(), startIndexStrike, endIndexStrike, 0);

        int startIndexClick = textView.getText().toString().indexOf("click");
        int endIndexClick = startIndexClick + "click".length();
        // clickable text
        ClickableSpan clickableSpan = new ClickableSpan() {

            @Override
            public void onClick(View widget) {
                Toast.makeText(getApplicationContext(),"Click",Toast.LENGTH_LONG).show();
            }
        };
        spannableString.setSpan(clickableSpan, startIndexClick, endIndexClick, 0);

        // change text color
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getApplicationContext(), R.color.colorBackground)), startIndexClick, endIndexClick, 0);
        // change background color
        spannableString.setSpan(new BackgroundColorSpan(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark)), startIndexClick, endIndexClick, 0);


        textView.setText(spannableString);
    }
}
