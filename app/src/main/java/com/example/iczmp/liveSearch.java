package com.example.iczmp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class liveSearch extends AppCompatActivity {
   RecyclerView recyclerView;
   EditText editSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_search);

        recyclerView = findViewById(R.id.recyclerView);
        editSearch = findViewById(R.id.editSearch);

    }
}