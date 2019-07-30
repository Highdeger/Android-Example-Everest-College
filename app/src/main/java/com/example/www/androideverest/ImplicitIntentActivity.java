package com.example.www.androideverest;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ImplicitIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
    }

    public void action_send_intent(View view) {
        Intent intent = new Intent();

        // Create the text message with a string
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "This is test message.");
        intent.setType("text/plain");

        // Verify that the intent will resolve to an activity
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void action_set_alarm_intent(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "This is message.")
                .putExtra(AlarmClock.EXTRA_HOUR, 14)
                .putExtra(AlarmClock.EXTRA_MINUTES, 36);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void action_view_geo_intent(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW)
                .setData(Uri.parse("geo:37.7749,-122.4192?z=13"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
