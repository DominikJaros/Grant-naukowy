package com.example.iczmp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class diagnostyka extends AppCompatActivity {

    View btKardiologiczne, RelativeLayout;
    Animation fadeIn;
    ImageView ic_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostyka);

        btKardiologiczne = findViewById(R.id.btKardiologiczne);
        RelativeLayout = findViewById(R.id.RelativeLayout);
        fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);


        ic_back = findViewById(R.id.ic_back);

        ic_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), dashboard.class);
                startActivity(intent);
            }
        });

        animation();



        btKardiologiczne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), chr_kardiologiczne.class);
                startActivity(intent);
            }
        });
    }

    private void animation() {
        RelativeLayout.startAnimation(fadeIn);
    }
}