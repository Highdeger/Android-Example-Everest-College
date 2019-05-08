package com.example.www.androideverest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SharedPreferencesActivity extends AppCompatActivity {

    ListView spListView;
    List<String> items;
    ArrayAdapter<String> adapter;
    SharedPreferences sharedPreferences;
    EditText et_add_key, et_add_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(R.string.activity_name_shared_pref_test);

//        Open or Create "sp-1" Table in Shared Preferences
        sharedPreferences = getSharedPreferences("sp-1", MODE_PRIVATE);

        spListView = findViewById(R.id.shared_pref_list_view);
        et_add_key = findViewById(R.id.add_key_edittext);
        et_add_value = findViewById(R.id.add_value_edittext);

        items = new ArrayList<>();

        adapter = new ArrayAdapter<>(
                SharedPreferencesActivity.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                items
        );

        spListView.setAdapter(adapter);

        update_list();
    }

    void update_list() {
        Map<String, ?> map = sharedPreferences.getAll();

        items.clear();

        for (Map.Entry<String, ?> entry : map.entrySet()) {
            items.add(String.format(
                    "%s ---> %s",
                    entry.getKey(),
                    entry.getValue()
            ));
        }

        adapter.notifyDataSetChanged();
    }

    public void add_key(View view) {
        String new_key = et_add_key.getText().toString();
        String new_value = et_add_value.getText().toString();
        if ((!new_key.trim().isEmpty()) && (!new_value.trim().isEmpty())) {
            sharedPreferences.edit().putString(new_key, new_value).apply();
        } else {
            Toast.makeText(SharedPreferencesActivity.this, "\"Key\" & \"Value\" are Empty.\n(Can't create Key-Value)", Toast.LENGTH_SHORT).show();
        }

        update_list();
    }

    public void remove_key(View view) {
        String key_to_delete = et_add_key.getText().toString();

        if (!key_to_delete.trim().isEmpty()) {
            sharedPreferences.edit().remove(key_to_delete).apply();
        } else {
            Toast.makeText(SharedPreferencesActivity.this, "\"Key\" is Empty.\n(Can't remove Key-Value)", Toast.LENGTH_SHORT).show();
        }

        update_list();
    }

    public void refresh_list(View view) {
        update_list();
    }
}
