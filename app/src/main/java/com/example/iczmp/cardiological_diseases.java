package com.example.iczmp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class cardiological_diseases extends AppCompatActivity {

    View btMiazdzyca, RelativeLayout;
    Animation fadeIn;
    ImageView ic_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardiological_diseases);

        btMiazdzyca = findViewById(R.id.btMiazdzyca);
        RelativeLayout = findViewById(R.id.RelativeLayout);

        ic_back = findViewById(R.id.btBack);

        ic_back.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), diagnostics.class);
            startActivity(intent);
        });

        fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        animation();

        btMiazdzyca.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), atherosclerosis.class);
            startActivity(intent);
        });
    }

    private void animation() {
        RelativeLayout.startAnimation(fadeIn);
    }
}
