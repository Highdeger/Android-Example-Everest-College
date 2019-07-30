package com.example.www.androideverest;

import android.os.Environment;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileManagerActivity extends AppCompatActivity {

    ListView listView;

    String path;
    File dir;
    File[] files;

    List<String> files_name;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_manager);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(R.string.activity_name_file_manager);

        listView = findViewById(R.id.file_list_view);

        files_name = new ArrayList<>();

        adapter = new ArrayAdapter<>(
                FileManagerActivity.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                files_name);

        listView.setAdapter(adapter);

        setPath(Environment.getExternalStorageDirectory().toString());
    }

    void goto_folder() {
        dir = new File(path);

        files = dir.listFiles();

//        files_name.clear();
//        for (File file : files) {
//            files_name.add(file.getName());
//        }
//        adapter.notifyDataSetChanged();

        adapter.clear();
        adapter.add("..");
        for (File file : files) {
            adapter.add(file.getName());
        }
        adapter.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(FileManagerActivity.this, files[position].getPath(), Toast.LENGTH_SHORT).show();
                if (position == 0) {
                    if (!path.equals(Environment.getExternalStorageDirectory().toString())) {
                        String new_path = dir.getParentFile().getPath();
                        setPath(new_path);
                    } else {
                        Toast.makeText(FileManagerActivity.this, "Can't go back from here. (Needed root)", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (files[position - 1].isDirectory()) {
                        setPath(files[position - 1].getPath());
                    } else {
                        String n = files[position - 1].getName();
                        String[] ns = n.split("\\.");
                        Toast.makeText(FileManagerActivity.this, ns[ns.length - 1], Toast.LENGTH_SHORT).show();
//                        Toast.makeText(FileManagerActivity.this, "This is a File.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public void setPath(String path) {
        this.path = path;
        goto_folder();
    }
}
