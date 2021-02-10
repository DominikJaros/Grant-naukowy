package com.example.iczmp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calculatorBMI extends AppCompatActivity {
    EditText btWeight, btHeight;
    Button btCheck;
    ImageView btBack;
    RelativeLayout layoutColors, resultsView;
    TextView result, category, textWeight, textHeight, textGender, information;
    RadioButton radioWomen, radioMan;
    Animation slideDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_bmi);

        //
        btHeight = findViewById(R.id.btHeight);
        btWeight = findViewById(R.id.btWeight);
        btCheck = findViewById(R.id.btCheck);
        btBack = findViewById(R.id.btBack);
        //
        layoutColors = findViewById(R.id.layoutColors);
        resultsView = findViewById(R.id.resultsView);
        //
        textWeight = findViewById(R.id.textWeight);
        textHeight = findViewById(R.id.textHeight);
        textGender = findViewById(R.id.textGender);
        result = findViewById(R.id.result);
        category = findViewById(R.id.category);
        information = findViewById(R.id.Information);
        //
        radioWomen = findViewById(R.id.radioWomen);
        radioMan = findViewById(R.id.radioMen);
        //
        slideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_to_right_animation);


        btCheck.setOnClickListener(this::onClick);
        btBack.setOnClickListener(this::onClick);


        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), calculators.class);
                startActivity(intent);
            }
        });

    }

    private void onClick(View view) {
        if (TextUtils.isEmpty(btHeight.getText().toString())) {
            btHeight.setError("Pole nie może być puste.");
        } else if (TextUtils.isEmpty(btWeight.getText())) {
            btWeight.setError("Pole nie może być puste.");
        } else {
            calculate();
            resultsView.setVisibility(View.VISIBLE);
            resultsView.setAlpha(0f);
            resultsView.setTranslationY(100f);
            resultsView.animate().alpha(1f).translationYBy(-100).setDuration(800);

        }

    }

    private void calculate() {

        String heightStr = btHeight.getText().toString();
        String weightStr = btWeight.getText().toString();

        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null && !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);

        }
    }

    //turn off keyboard
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
//

    private void displayBMI(float bmi) {
        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = getString(R.string.very_severely_underweight);
            information.setText(getResources().getString(R.string.underweightBMI));
            changeTextColor();
            changeColorRed();

        } else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {
            bmiLabel = getString(R.string.severely_underweight);
            information.setText(getResources().getString(R.string.underweightBMI));
            changeTextColor();
            changeColorRed();

        } else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.underweight);
            information.setText(getResources().getString(R.string.underweightBMI));
            changeTextColor();
            changeColorOrange();
        } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0) {
            bmiLabel = getString(R.string.normal);
            information.setText(getResources().getString(R.string.normalBMI));
            changeTextColor();
            changeColorGreen();

        } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {
            bmiLabel = getString(R.string.overweight);
            information.setText(getResources().getString(R.string.overweightBMI));
            changeTextColor();
            changeColorOrange();


        } else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0) {
            bmiLabel = getString(R.string.obese_class_i);
            information.setText(getResources().getString(R.string.overweightBMI));
            changeTextColor();
            changeColorRed();


        } else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0) {
            bmiLabel = getString(R.string.obese_class_ii);
            information.setText(getResources().getString(R.string.highOverweightBMI));
            changeTextColor();
            changeColorRed();

        } else {
            bmiLabel = getString(R.string.obese_class_iii);
            information.setText(getResources().getString(R.string.highOverweightBMI));
            changeTextColor();
            changeColorRed();

        }
        String bmiResult = Float.toString(bmi);
        category.setText(bmiLabel);
        result.setText(bmiResult);
    }

    private void changeTextColor() {
        textWeight.setTextColor(getResources().getColor(R.color.white));
        textHeight.setTextColor(getResources().getColor(R.color.white));
        textGender.setTextColor(getResources().getColor(R.color.white));
        radioWomen.setTextColor(getResources().getColor(R.color.white));
        radioMan.setTextColor(getResources().getColor(R.color.white));
    }

    private void changeColorRed() {
        layoutColors.setBackgroundResource(R.drawable.gradient_red);
        result.setBackgroundResource(R.drawable.gradient_red);
    }

    private void changeColorOrange() {
        layoutColors.setBackgroundResource(R.drawable.gradient_orange);
        result.setBackgroundResource(R.drawable.gradient_orange);
    }

    private void changeColorGreen() {
        layoutColors.setBackgroundResource(R.drawable.gradient_green);
        result.setBackgroundResource(R.drawable.gradient_green);
    }

}
