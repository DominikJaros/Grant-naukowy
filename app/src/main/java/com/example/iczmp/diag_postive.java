package com.example.iczmp;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class diag_postive extends AppCompatActivity {
    Button btnHealing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diag_postive);

        btnHealing = findViewById(R.id.btn_dialog);
    }
}