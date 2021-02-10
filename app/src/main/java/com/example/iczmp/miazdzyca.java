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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class miazdzyca extends AppCompatActivity {

    Switch switch1, switch2, switch3, switch4, switch5;
    Button btDiagnozuj, dialogButton;
    ImageView ic_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miazdzyca);

        ic_back = findViewById(R.id.btBack);


        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), chr_kardiologiczne.class);
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
                    RedAlert();
                } else if (switch2.isChecked() && switch3.isChecked() && switch5.isChecked()) {
                    OrangeAlert();
                } else {
                    GreenAlert();
                }
            }
        });
    }

    private void GreenAlert() {
        Context context;
        LayoutInflater inflater = LayoutInflater.from(this);
        ViewGroup root;

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

    private void OrangeAlert() {
        Context context;
        LayoutInflater inflater = LayoutInflater.from(this);
        ViewGroup root;

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
                Intent intent = new Intent(view.getContext(), miazdzyca_leczenie.class);
                //you must put your map activity
                miazdzyca.this.startActivity(intent);
                alertDialog.dismiss();
            }
        });
    }

    private void RedAlert() {
        Context context;
        LayoutInflater inflater = LayoutInflater.from(this);
        ViewGroup root;

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
                Intent intent = new Intent(view.getContext(), miazdzyca_leczenie.class);
                //you must put your map activity
                miazdzyca.this.startActivity(intent);
                alertDialog.dismiss();
            }
        });
    }

}