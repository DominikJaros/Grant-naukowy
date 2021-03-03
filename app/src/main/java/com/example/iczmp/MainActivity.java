package com.example.iczmp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonClick();
        btStart.setAlpha(0f);
        btStart.setTranslationY(50f);
        btStart.animate().alpha(1f).translationYBy(-50).setDuration(1500);
    }

    private void buttonClick() {
        btStart = findViewById(R.id.btStart);
        btStart.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), dashboard.class);
            view.getContext().startActivity(intent);
        });
    }
}