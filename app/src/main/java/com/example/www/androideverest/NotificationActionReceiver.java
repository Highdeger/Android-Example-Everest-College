package com.example.www.androideverest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationActionReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getStringExtra("action");
        if (action.equals("1")) {
            Toast.makeText(context, "Notification Action 1", Toast.LENGTH_SHORT).show();
        } else if (action.equals("2")) {
            Toast.makeText(context, "Notification Action 2", Toast.LENGTH_SHORT).show();
        }

        Intent i = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
        context.sendBroadcast(i);
    }
}
