package com.example.iczmp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class miazdzyca extends AppCompatActivity {

    Switch switch1, switch2, switch3, switch4, switch5;
    Button btDiagnozuj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miazdzyca);

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
            @Override
            public void onClick(View view) {
                if (switch1.isChecked() && switch2.isChecked() && switch3.isChecked()) {
                    AlertDialog alertDialog = new AlertDialog.Builder(miazdzyca.this).create();
                    alertDialog.setTitle("Diagnoza");
                    alertDialog.setMessage("Przy podanych objawach występuje podejrzenie miażdżycy.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
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
                }else{
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