package com.example.iczmp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

public class chr_kardiologiczne extends AppCompatActivity {

    View btMiazdzyca, RelativeLayout;
    Animation fadeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chr_kardiologiczne);

        btMiazdzyca = findViewById(R.id.btMiazdzyca);
        RelativeLayout = findViewById(R.id.RelativeLayout);

        fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        animation();

        btMiazdzyca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), miazdzyca.class);
                startActivity(intent);
            }
        });
    }

    private void animation() {
        RelativeLayout.startAnimation(fadeIn);
    }
}
