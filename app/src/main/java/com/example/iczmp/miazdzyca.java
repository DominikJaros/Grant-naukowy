package com.example.iczmp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class miazdzyca extends AppCompatActivity {

    Switch switch1, switch2, switch3, switch4, switch5;
    Button btDiagnozuj, btn_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miazdzyca);

        btn_dialog = findViewById(R.id.btn_dialog);
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(miazdzyca.this);
                    view = LayoutInflater.from(miazdzyca.this).inflate(R.layout.activity_diag_postive, null);

                    TextView content = (TextView) view.findViewById(R.id.text_dialog);

                    content.setText("Przy podanych objawach występuje podejrzenie miażdżycy.");

                    builder.setView(view);
                    builder.setPositiveButton("Pokaż sposoby leczenia",new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(miazdzyca.this,miazdzyca_leczenie.class);
                            startActivity(intent);
                        }
                    });
                    builder.show();
                    
                } else if (switch2.isChecked() && switch3.isChecked() && switch5.isChecked()) {
                    AlertDialog alertDialog = new AlertDialog.Builder(miazdzyca.this).create();
                    alertDialog.setTitle("Diagnoza");
                    alertDialog.setMessage("Przy podanych objawach występuje lekkie podejrzenie miażdżycy.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(miazdzyca.this).create();
                    alertDialog.setTitle("Diagnoza");
                    alertDialog.setMessage("Przy podanych objawach NIE występuje podejrzenie miażdżycy.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });
    }
}