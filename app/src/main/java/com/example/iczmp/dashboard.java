package com.example.iczmp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class dashboard extends AppCompatActivity {
    View btDiagnostyka, btChoroby, btCalulator, btNews;
    Animation fadeIn, moveRight, slideDown, moveLeft;
    ImageView imageDiagnostyka, imageChoroby, imageCalculator, imageNews;
    TextView textDiagnostyka, textChoroby, textCalculator, textNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btChoroby = findViewById(R.id.btChoroby);
        btDiagnostyka = findViewById(R.id.btDiagnostyka);
        btCalulator = findViewById(R.id.btCalculator);
        btNews = findViewById(R.id.btNews);
        //
        imageChoroby = findViewById(R.id.imageChoroby);
        imageDiagnostyka = findViewById(R.id.image_Diagnostyka);
        imageCalculator = findViewById(R.id.imageCalculator);
        imageNews = findViewById(R.id.imageNews);
        //
        textDiagnostyka = findViewById(R.id.textDiagnostyka);
        textChoroby = findViewById(R.id.textChoroby);
        textCalculator = findViewById(R.id.textCalulator);
        textNews = findViewById(R.id.textNews);



        fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        moveRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_to_right_animation);
        slideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        moveLeft = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.push_left0_in);

       //
        Animation();

        btCalulator.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), calculators.class);
            startActivity(intent);
        });
        btDiagnostyka.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), diagnostyka.class);
            startActivity(intent);
        });
    }

    private void Animation() {
        //move right animation
        btDiagnostyka.startAnimation(moveRight);
        imageDiagnostyka.startAnimation(moveRight);
        textDiagnostyka.startAnimation(moveRight);
        //
        btNews.startAnimation(moveRight);
        imageNews.startAnimation(moveRight);
        textNews.startAnimation(moveRight);
        //move down animation
        btChoroby.startAnimation(slideDown);
        imageChoroby.startAnimation(slideDown);
        textChoroby.startAnimation(slideDown);
        //move right

        btCalulator.startAnimation(moveLeft);
        imageCalculator.startAnimation(moveLeft);
        textCalculator.startAnimation(moveLeft);


    }
}