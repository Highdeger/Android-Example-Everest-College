package com.example.www.androideverest;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

public class NavigationDrawerActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open_desc, R.string.navigation_drawer_close_desc);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id) {
                    case R.id.item1:
                        Toast.makeText(NavigationDrawerActivity.this, "Item 1 Pressed.", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);
                        break;

                    case R.id.item2:
                        Toast.makeText(NavigationDrawerActivity.this, "Item 2 Pressed.", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);
                        break;

                    case R.id.item3:
                        Toast.makeText(NavigationDrawerActivity.this, "Item 3 Pressed.", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);
                        break;

                    case R.id.item4:
                        Toast.makeText(NavigationDrawerActivity.this, "Item 4 Pressed.", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(Gravity.START);
                        break;
                }

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
