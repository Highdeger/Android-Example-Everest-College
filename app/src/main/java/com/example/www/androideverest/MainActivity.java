package com.example.www.androideverest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goto_somewhere(View view) {

        switch (view.getTag().toString()) {
            case "calculator":
                startActivity(new Intent(MainActivity.this, CalculatorActivity.class));
                break;

            case "list_view":
                startActivity(new Intent(MainActivity.this, ListViewActivity.class));
                break;

            case "file_manager":
                startActivity(new Intent(MainActivity.this, FileManagerActivity.class));
                break;

            case "service_test":
                startActivity(new Intent(MainActivity.this, ServiceTestActivity.class));
                break;

            case "sharedpref_test":
                startActivity(new Intent(MainActivity.this, SharedPreferencesActivity.class));
                break;

            case "fore_service_test":
                startActivity(new Intent(MainActivity.this, ForegroundServiceTestActivity.class));
                break;

            case "notification_broadcast_receiver":
                startActivity(new Intent(MainActivity.this, NotificationActivity.class));
                break;

            case "http_request_network_state":
                startActivity(new Intent(MainActivity.this, HttpRequestActivity.class));
                break;

            case "animation":
                startActivity(new Intent(MainActivity.this, AnimationActivity.class));
                break;

            case "widgets_listener":
                startActivity(new Intent(MainActivity.this, WidgetsListenerActivity.class));
                break;

            case "photo_picker":
                startActivity(new Intent(MainActivity.this, PhotoPickerActivity.class));
                break;

            case "recycler_view":
                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
                break;

            case "tabbed":
                startActivity(new Intent(MainActivity.this, TabbedActivity.class));
                break;

            case "dialog":
                startActivity(new Intent(MainActivity.this, DialogActivity.class));
                break;

            case "navigation_drawer":
                startActivity(new Intent(MainActivity.this, NavigationDrawerActivity.class));
                break;

            case "implicit_intent":
                startActivity(new Intent(MainActivity.this, ImplicitIntentActivity.class));
                break;
        }
    }
}
