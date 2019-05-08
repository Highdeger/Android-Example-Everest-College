package com.example.www.androideverest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ForegroundServiceTestActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground_service_test);

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(R.string.activity_name_fore_service_test);

        editText = findViewById(R.id.service_input);
    }

    public void start_foreground_service(View view) {
        String input = editText.getText().toString();

        Intent intent = new Intent(ForegroundServiceTestActivity.this, ForegroundServiceTest.class);
        intent.putExtra("inputExtra", input);

        startService(intent);
    }

    public void stop_foreground_service(View view) {
        Intent intent = new Intent(ForegroundServiceTestActivity.this, ForegroundServiceTest.class);

        stopService(intent);
    }
}
