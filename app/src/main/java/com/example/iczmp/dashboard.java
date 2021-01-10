package com.example.iczmp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class dashboard extends AppCompatActivity {
    View btDiagnostyka, btChoroby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btChoroby = findViewById(R.id.btChoroby);
        btDiagnostyka = findViewById(R.id.btDiagnostyka);

        btDiagnostyka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), diagnostyka.class);
                startActivity(intent);
            }
        });
    }
}