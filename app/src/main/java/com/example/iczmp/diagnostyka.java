package com.example.iczmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class diagnostyka extends AppCompatActivity {

    View btKardiologiczne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostyka);

        btKardiologiczne = findViewById(R.id.btKardiologiczne);
        btKardiologiczne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), chr_kardiologiczne.class);
                startActivity(intent);
            }
        });
    }
}