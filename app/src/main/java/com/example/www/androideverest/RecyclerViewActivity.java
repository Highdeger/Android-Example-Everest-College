package com.example.www.androideverest;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<RecyclerViewModel> my_list;
    RecyclerViewAdapter adapter_linear, adapter_grid;
    DividerItemDecoration divider_row;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.recyclerview_self);

        my_list = new ArrayList<>();
        handler = new Handler();

        init_recyclerview();
        init_list();
    }

    private void init_recyclerview() {
        adapter_linear = new RecyclerViewAdapter(my_list, "row");
        adapter_grid = new RecyclerViewAdapter(my_list, "grid");

        divider_row = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter_linear);

        recyclerView.addItemDecoration(divider_row);
    }

    private void init_list() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Drawable drawable_photo1 = getResources().getDrawable(R.drawable.test001);
                Drawable drawable_photo2 = getResources().getDrawable(R.drawable.test002);
                Drawable drawable_photo3 = getResources().getDrawable(R.drawable.test003);
                Drawable drawable_photo4 = getResources().getDrawable(R.drawable.test004);
                Drawable drawable_photo5 = getResources().getDrawable(R.drawable.test005);
                Drawable drawable_photo6 = getResources().getDrawable(R.drawable.test006);
                Drawable drawable_photo7 = getResources().getDrawable(R.drawable.test007);
                Drawable drawable_photo8 = getResources().getDrawable(R.drawable.test008);

                Drawable drawable_icon1 = getResources().getDrawable(R.drawable.ic_settings_remote);
                Drawable drawable_icon2 = getResources().getDrawable(R.drawable.ic_settings_phone);
                Drawable drawable_icon3 = getResources().getDrawable(R.drawable.ic_settings);

                for (int i = 0; i < 70; i++) {
                    String temp_title = "Title " + (i+1);
                    String temp_subtitle = "Subtitle " + (i+1);
                    String temp_id = String.format(Locale.getDefault(), "[%04d]", (i+1));
                    Drawable temp_photo = drawable_photo1;
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

                    switch (i % 8) {
                        case 0:
                            temp_photo = drawable_photo1;
                            break;

                        case 1:
                            temp_photo = drawable_photo2;
                            break;

                        case 2:
                            temp_photo = drawable_photo3;
                            break;

                        case 3:
                            temp_photo = drawable_photo4;
                            break;

                        case 4:
                            temp_photo = drawable_photo5;
                            break;

                        case 5:
                            temp_photo = drawable_photo6;
                            break;

                        case 6:
                            temp_photo = drawable_photo7;
                            break;

                        case 7:
                            temp_photo = drawable_photo8;
                            break;
                    }

                    switch (i % 5) {
                        case 0:
                            temp_title = "Title " + (i+1);
                            temp_subtitle = "Subtitle " + (i+1);
                            break;

                        case 1:
                            temp_title = "Title " + (i+1) + "\nSpecial";
                            temp_subtitle = "Subtitle " + (i+1);
                            break;

                        case 2:
                            temp_title = "Title " + (i+1) + "\nDevastating\nDestructive";
                            temp_subtitle = "Subtitle " + (i+1);
                            break;

                        case 3:
                            temp_title = "Title " + (i+1);
                            temp_subtitle = "Subtitle " + (i+1) + "\nParchment";
                            break;

                        case 4:
                            temp_title = "Title " + (i+1) + "\nOverkill";
                            temp_subtitle = "Subtitle " + (i+1) + "\nTreason";
                            break;
                    }

                    my_list.add(new RecyclerViewModel(temp_title, temp_subtitle, temp_id, temp_icon, temp_photo));

                }

                adapter_grid.notifyDataSetChanged();
                adapter_linear.notifyDataSetChanged();
            }
        };

        handler.postDelayed(runnable, 10);
    }

    public void recyclerview_to_row(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(divider_row);

        recyclerView.setItemViewCacheSize(6);
        recyclerView.setAdapter(adapter_linear);
    }

    public void recyclerview_to_grid2(View view) {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.removeItemDecoration(divider_row);

        recyclerView.setItemViewCacheSize(6);
        recyclerView.setAdapter(adapter_grid);
    }

    public void recyclerview_to_grid3(View view) {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.removeItemDecoration(divider_row);

        recyclerView.setItemViewCacheSize(6);
        recyclerView.setAdapter(adapter_grid);
    }
}
