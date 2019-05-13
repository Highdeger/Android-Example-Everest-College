package com.example.www.androideverest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class HttpRequestActivity extends AppCompatActivity {

    TextView request_result_textview;
    String send_request_to_google_TAG = "send_request_to_google";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_request);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(R.string.activity_name_http_request_network_state);

        request_result_textview = findViewById(R.id.request_result_textview);
    }

    public void send_request_to_google(View view) {
        requestQueue = Volley.newRequestQueue(this);
        String url = "http://www.google.com";

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(HttpRequestActivity.this, "Successful Respond", Toast.LENGTH_SHORT).show();
                        request_result_textview.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(HttpRequestActivity.this, "Failed Respond", Toast.LENGTH_SHORT).show();
                        request_result_textview.setText("Error - No Response");
                    }
                }
        );
        stringRequest.setTag(send_request_to_google_TAG);

        requestQueue.add(stringRequest);
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

    @Override
    protected void onStop() {
        super.onStop();
        if (requestQueue != null) {
            requestQueue.cancelAll(send_request_to_google_TAG);
        }
    }
}
