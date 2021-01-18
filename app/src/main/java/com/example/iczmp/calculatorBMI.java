package com.example.iczmp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class calculatorBMI extends AppCompatActivity {
    EditText btWeight, btHeight;
    Button btCheck;
    RelativeLayout layoutColors;
    TextView result, category, textWeight, textHeight, textGender, information;
    RadioButton radioWomen, radioMan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_bmi);

        //
        btHeight = findViewById(R.id.btHeight);
        btWeight = findViewById(R.id.btWeight);
        btCheck = findViewById(R.id.btCheck);
        //
        layoutColors = findViewById(R.id.layoutColors);
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


        btCheck.setOnClickListener(this::onClick);

    }

    private void onClick(View view) {
        Calculate();
    }

    private void Calculate() {

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

    private void displayBMI(float bmi) {
        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = getString(R.string.very_severely_underweight);
            layoutColors.setBackgroundResource(R.drawable.gradient_red);
            result.setBackgroundResource(R.drawable.gradient_red);
            information.setText(getResources().getString(R.string.underweightBMI));
            changeColor();

        } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
            layoutColors.setBackgroundResource(R.drawable.gradient_red);
            bmiLabel = getString(R.string.severely_underweight);
            result.setBackgroundResource(R.drawable.gradient_red);
            information.setText(getResources().getString(R.string.underweightBMI));
            changeColor();

        } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.underweight);
            layoutColors.setBackgroundResource(R.drawable.gradient_orange);
            result.setBackgroundResource(R.drawable.gradient_orange);
            information.setText(getResources().getString(R.string.underweightBMI));
            changeColor();
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
            bmiLabel = getString(R.string.normal);
            layoutColors.setBackgroundResource(R.drawable.gradient_green);
            result.setBackgroundResource(R.drawable.gradient_green);
            information.setText(getResources().getString(R.string.normalBMI));
            changeColor();
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            bmiLabel = getString(R.string.overweight);
            layoutColors.setBackgroundResource(R.drawable.gradient_orange);
            result.setBackgroundResource(R.drawable.gradient_orange);
            information.setText(getResources().getString(R.string.overweightBMI));
            changeColor();

        } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
            bmiLabel = getString(R.string.obese_class_i);
            layoutColors.setBackgroundResource(R.drawable.gradient_red);
            result.setBackgroundResource(R.drawable.gradient_red);
            information.setText(getResources().getString(R.string.overweightBMI));
            changeColor();

        } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
            bmiLabel = getString(R.string.obese_class_ii);
            result.setBackgroundResource(R.drawable.gradient_red);
            information.setText(getResources().getString(R.string.highOverweightBMI));
            changeColor();

        } else {
            bmiLabel = getString(R.string.obese_class_iii);
            layoutColors.setBackgroundResource(R.drawable.gradient_red);
            result.setBackgroundResource(R.drawable.gradient_red);
            information.setText(getResources().getString(R.string.highOverweightBMI));
            changeColor();
        }
        String bmiResult = Float.toString(bmi);
        category.setText(bmiLabel);
        result.setText(bmiResult);
    }

    private void changeColor() {
        textWeight.setTextColor(getResources().getColor(R.color.white));
        textHeight.setTextColor(getResources().getColor(R.color.white));
        textGender.setTextColor(getResources().getColor(R.color.white));
        radioWomen.setTextColor(getResources().getColor(R.color.white));
        radioMan.setTextColor(getResources().getColor(R.color.white));
    }
}
