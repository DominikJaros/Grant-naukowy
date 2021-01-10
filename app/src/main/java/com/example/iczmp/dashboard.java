package com.example.iczmp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class dashboard extends AppCompatActivity {
    View btDiagnostyka, btChoroby;
    Animation fadeIn;
    View relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btChoroby = findViewById(R.id.btChoroby);
        btDiagnostyka = findViewById(R.id.btDiagnostyka);
        relativeLayout = findViewById(R.id.relativeLayout);

        fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);

        Animation();


        btDiagnostyka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), diagnostyka.class);
                startActivity(intent);
            }
        });
    }

    private void Animation() {
        relativeLayout.startAnimation(fadeIn);
    }
}