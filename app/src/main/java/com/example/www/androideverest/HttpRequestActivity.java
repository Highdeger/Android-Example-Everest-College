package com.example.www.androideverest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HttpRequestActivity extends AppCompatActivity {

    TextView request_result_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_request);

        request_result_textview = findViewById(R.id.request_result_textview);
    }

    public void send_request_to_google(View view) {
    }

    public void check_network(View view) {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (manager != null) {
            NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();

            if (activeNetworkInfo != null) {

                if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                    Toast.makeText(this, "Wifi Enabled", Toast.LENGTH_SHORT).show();

                } else if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                    Toast.makeText(this, "Mobile Data Enabled", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "No Internet is Available", Toast.LENGTH_SHORT).show();
            }

        }
    }

}
