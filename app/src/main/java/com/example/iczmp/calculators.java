package com.example.iczmp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class calculators extends AppCompatActivity {

    View btBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators);

        btBMI = findViewById(R.id.btBMI);
        btBMI.setOnClickListener(this::onClick);
    }
    private void onClick(View view) {
        Intent intent;
        intent = new Intent(view.getContext(), calculatorBMI.class);
        startActivity(intent);
    }
}