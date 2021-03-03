package com.example.iczmp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class liveSearch extends AppCompatActivity {
    SearchView searchView;
    ListView listView;

    String[] diseasesList = {"Covid19", "Grypa", "Miażdzyca", "Nerwica"};
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_search);

        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> Toast.makeText(liveSearch.this, "Click!", Toast.LENGTH_SHORT).show());
        //Search filter

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                liveSearch.this.arrayAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                liveSearch.this.arrayAdapter.getFilter().filter(newText);
                return false;
            }

        });
    }
}