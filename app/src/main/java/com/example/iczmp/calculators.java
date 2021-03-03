package com.example.iczmp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class calculators extends AppCompatActivity {

    View btBMI;
    ImageView btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators);

        btBMI = findViewById(R.id.btBMI);
        btBack = findViewById(R.id.btBack);
        btBMI.setOnClickListener(this::onClick);

        btBack.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), dashboard.class);
            startActivity(intent);
        });
    }

    private void onClick(View view) {
        Intent intent;
        intent = new Intent(view.getContext(), calculatorBMI.class);
        startActivity(intent);
    }
}