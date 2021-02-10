package com.example.iczmp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class atherosclerosis extends AppCompatActivity {

    Switch switch1, switch2, switch3, switch4, switch5;
    Button btDiagnozuj, dialogButton;
    ImageView ic_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atherosclerosis);

        ic_back = findViewById(R.id.btBack);


        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), cardiological_diseases.class);
                startActivity(intent);
            }
        });


        switch1 = findViewById(R.id.switch1);
        switch1.setTextOn("Tak");
        switch1.setTextOff("Nie");
        //
        switch2 = findViewById(R.id.switch2);


        //
        switch3 = findViewById(R.id.switch3);


        //
        switch4 = findViewById(R.id.switch4);


        ///
        switch5 = findViewById(R.id.switch5);


        //

        btDiagnozuj = findViewById(R.id.btDiagnozuj);
        btDiagnozuj.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                if (switch1.isChecked() && switch2.isChecked() && switch3.isChecked()) {
                    redAlert();
                } else if (switch2.isChecked() && switch3.isChecked() && switch5.isChecked()) {
                    orangeAlert();
                } else {
                    greenAlert();
                }
            }
        });
    }

    private void greenAlert() {
        LayoutInflater inflater = LayoutInflater.from(this);

        View view = inflater.inflate(R.layout.activity_alert_green, null);

        TextView content = view.findViewById(R.id.text_dialog);
        Button dialogButton = view.findViewById(R.id.btn_dialog);
        content.setText("Przy podanych objawach nie występuje podejrzenie miażdzcy.");

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();

        alertDialog.show();

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }

    private void orangeAlert() {
        LayoutInflater inflater = LayoutInflater.from(this);

        View view = inflater.inflate(R.layout.activity_alert_orange, null);

        TextView content = view.findViewById(R.id.text_dialog);
        Button dialogButton = view.findViewById(R.id.btn_dialog);
        content.setText("Przy podanych objawach występuje podejrzenie miażdzcy.\n Zleć więcej badań.");

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();

        alertDialog.show();

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), atherosclerosis_diagnosis.class);
                //you must put your map activity
                atherosclerosis.this.startActivity(intent);
                alertDialog.dismiss();
            }
        });
    }

    private void redAlert() {
        LayoutInflater inflater = LayoutInflater.from(this);

        View view = inflater.inflate(R.layout.activity_alert_red, null);

        TextView content = view.findViewById(R.id.text_dialog);
        Button dialogButton = view.findViewById(R.id.btn_dialog);

        content.setText("Przy podanych objawach występuje podejrzenie miażdzcy.\n Zleć więcej badań.");

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();

        alertDialog.show();

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), atherosclerosis_diagnosis.class);
                //you must put your map activity
                atherosclerosis.this.startActivity(intent);
                alertDialog.dismiss();
            }
        });
    }

}