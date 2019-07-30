package com.example.www.androideverest;

import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(R.string.activity_name_listview);

        myListView = findViewById(R.id.my_list_view);

        names = new ArrayList<>();

        for (int i = 1; i < 7; i++) {
            names.add("Name ===> " + i);
        }

        adapter = new ArrayAdapter<>(
                ListViewActivity.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                names
        );

        myListView.setAdapter(adapter);

        update_list_view_counter();

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected_item_text = names.get(position);
                Toast.makeText(ListViewActivity.this, "Selected Item: " + selected_item_text, Toast.LENGTH_SHORT).show();
            }
        });

        myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View v, int position, long id) {
                if (v.getVisibility() == View.VISIBLE) {
                    v.setVisibility(View.INVISIBLE);

                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            v.setVisibility(View.VISIBLE);
                        }
                    };
                    Handler handler = new Handler();

                    handler.postDelayed(runnable,5000);
                }
                return false;
            }
        });

    }

    public void add_item_first(View view) {
        names.add(0, "New Item ===> " + counter);
        adapter.notifyDataSetChanged();
        update_list_view_counter();

        counter++;
    }

    public void add_item_last(View view) {
        names.add("New Item ===> " + counter);
        adapter.notifyDataSetChanged();
        update_list_view_counter();

//        adapter.add("Ali ===> " + String.valueOf(counter));

        counter++;
    }

    public void remove_item(View view) {
        if (!names.isEmpty()) {
            names.remove(names.size() - 1);
            adapter.notifyDataSetChanged();
            update_list_view_counter();
        } else {
            Toast.makeText(ListViewActivity.this, "The list is empty already.", Toast.LENGTH_SHORT).show();
        }
    }

    public void update_list_view_counter() {
        TextView tv_counter = findViewById(R.id.list_view_counter);
        tv_counter.setText(String.valueOf(names.size()));
    }
}
