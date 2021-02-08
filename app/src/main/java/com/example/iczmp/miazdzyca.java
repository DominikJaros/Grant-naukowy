package com.example.iczmp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class miazdzyca extends AppCompatActivity {

    Switch switch1, switch2, switch3, switch4, switch5;
    Button btDiagnozuj;
    ImageView ic_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miazdzyca);

        ic_back = findViewById(R.id.btBack);


        ic_back.setOnClickListener(new View.OnClickListener(){
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(miazdzyca.this);
                    view = LayoutInflater.from(miazdzyca.this).inflate(R.layout.activity_diag_postive, null);


                    TextView content = (TextView) view.findViewById(R.id.text_dialog);
                    Button dialogButton = (Button) view.findViewById(R.id.btn_dialog);

                    dialogButton.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(view.getContext(), miazdzyca_leczenie.class);
                            //you must put your map activity
                            miazdzyca.this.startActivity(intent);
                        }
                    });
                    //
                    content.setText("Przy podanych objawach występuje poważne podejrzenie miażdżycy.");
                    //builder.setView(view);

                  //  builder.show();
                    
                } else if (switch2.isChecked() && switch3.isChecked() && switch5.isChecked()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(miazdzyca.this);
                    view = LayoutInflater.from(miazdzyca.this).inflate(R.layout.activity_alert_orange, null);

                    TextView content = (TextView) view.findViewById(R.id.text_dialog);
                    Button dialogButton = (Button) view.findViewById(R.id.btn_dialog);

                    dialogButton.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(view.getContext(), miazdzyca_leczenie.class);
                            //you must put your map activity
                            miazdzyca.this.startActivity(intent);
                        }
                    });

                    content.setText("Przy podanych objawach występuje podejrzenie miażdzcy.\n Zleć więcej badań.");
                    builder.setView(view);
                    builder.show();
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(miazdzyca.this).create();
                    AlertDialog.Builder bulider = new AlertDialog.Builder(miazdzyca.this);
                    view = LayoutInflater.from(miazdzyca.this).inflate(R.layout.activity_alert_green, null);

                    TextView content = (TextView) view.findViewById(R.id.text_dialog);
                    Button dialogButton = (Button) view.findViewById(R.id.btn_dialog);

                    dialogButton.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view) {

                        }
                    });

                    content.setText("Przy podanych objawach NIE występuje podejrzenie miażdzcy.");
                    bulider.setView(view);
                    bulider.show();
                }
            }
        });
    }
}