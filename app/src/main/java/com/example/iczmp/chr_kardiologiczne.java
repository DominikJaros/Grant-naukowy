package com.example.iczmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class chr_kardiologiczne extends AppCompatActivity {

    View btMiazdzyca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chr_kardiologiczne);

        btMiazdzyca = findViewById(R.id.btMiazdzyca);
        btMiazdzyca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), miazdzyca.class);
                startActivity(intent);
            }
        });
    }
}