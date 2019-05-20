package com.example.www.androideverest;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<RecyclerViewModel> my_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.recyclerview_self);

        Drawable drawable_photo = getResources().getDrawable(R.drawable.ic_launcher_background);
        Drawable drawable_icon1 = getResources().getDrawable(R.drawable.ic_settings_remote);
        Drawable drawable_icon2 = getResources().getDrawable(R.drawable.ic_settings_phone);
        Drawable drawable_icon3 = getResources().getDrawable(R.drawable.ic_settings);

        my_list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            String temp_title = "Title " + (i+1);
            String temp_subtitle = "Title " + (i+1);
            String temp_id = String.format(Locale.getDefault(), "[%04d]", (i+1));
            Drawable temp_photo = drawable_photo;
            Drawable temp_icon = drawable_icon1;

            switch (i % 3) {
                case 0:
                    temp_icon = drawable_icon1;
                    break;

                case 1:
                    temp_icon = drawable_icon2;
                    break;

                case 2:
                    temp_icon = drawable_icon3;
                    break;
            }

            my_list.add(new RecyclerViewModel(temp_title, temp_subtitle, temp_id, temp_icon, temp_photo));
        }


        RecyclerViewAdapter adapter = new RecyclerViewAdapter(my_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);
    }
}
