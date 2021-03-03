package com.example.iczmp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class diagnostics extends AppCompatActivity {

    View btCardiological, RelativeLayout;
    Animation fadeIn;
    ImageView ic_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostics);

        btCardiological = findViewById(R.id.btKardiologiczne);
        RelativeLayout = findViewById(R.id.RelativeLayout);
        fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);


        ic_back = findViewById(R.id.btBack);

        ic_back.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), dashboard.class);
            startActivity(intent);
        });

        animation();


        btCardiological.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), cardiological_diseases.class);
            startActivity(intent);
        });
    }

    private void animation() {
        RelativeLayout.startAnimation(fadeIn);
    }
}