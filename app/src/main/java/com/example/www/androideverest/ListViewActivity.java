package com.example.www.androideverest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    ListView myListView;
    List<String> names;
    ArrayAdapter<String> adapter;

    int counter = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        myListView = findViewById(R.id.my_list_view);

        names = new ArrayList<>();

        for (int i = 1; i < 7; i++) {
            names.add("Name ===> " + String.valueOf(i));
        }

        adapter = new ArrayAdapter<>(
                ListViewActivity.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                names
        );

        myListView.setAdapter(adapter);
    }

    public void add_item(View view) {
//        names.add("Ali ===> " + String.valueOf(counter));
//        adapter.notifyDataSetChanged();

        adapter.add("Ali ===> " + String.valueOf(counter));

        counter++;
    }
}
