package com.example.www.androideverest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Timer;

import static com.example.www.androideverest.App.CHANNEL_ID;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    public void show_default(View view) {
        Intent notidicationIntent = new Intent(getApplicationContext(), NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                getApplicationContext(),
                0,
                notidicationIntent,
                0);

        Intent intent_action1 = new Intent(NotificationActivity.this, NotificationReceiver.class);
        intent_action1.setAction("com.example.www.androideverest.NOTIFICATION_ACTION");
        intent_action1.putExtra("action", "1");
        PendingIntent pending_action1 = PendingIntent.getBroadcast(
                getApplicationContext(),
                1,
                intent_action1,
                PendingIntent.FLAG_ONE_SHOT);

        Intent intent_action2 = new Intent(NotificationActivity.this, NotificationReceiver.class);
        intent_action2.setAction("com.example.www.androideverest.NOTIFICATION_ACTION");
        intent_action2.putExtra("action", "2");
        PendingIntent pending_action2 = PendingIntent.getBroadcast(
                getApplicationContext(),
                2,
                intent_action2,
                PendingIntent.FLAG_ONE_SHOT);

        Notification notification = new NotificationCompat.Builder(NotificationActivity.this, CHANNEL_ID)
                .setContentTitle("My Title")
                .setContentText("My Content Text")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_notification)
                .setAutoCancel(true)
                .setOngoing(true)
                .setShowWhen(true)
                .setWhen(Calendar.getInstance().getTimeInMillis())
                .addAction(R.drawable.ic_settings, "Action 1", pending_action1)
                .addAction(R.drawable.ic_settings_remote, "Action 2", pending_action2)
                .build();

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (manager != null)
            manager.notify(0, notification);
        else
            Toast.makeText(NotificationActivity.this, "NotificationManager is Null", Toast.LENGTH_SHORT).show();
    }

    public void show_custom(View view) {
        Intent notidicationIntent = new Intent(getApplicationContext(), NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                getApplicationContext(),
                0,
                notidicationIntent,
                0);

        RemoteViews expandedView = new RemoteViews(getPackageName(), R.layout.notification_expanded);
        RemoteViews collapsedView = new RemoteViews(getPackageName(), R.layout.notification_collapsed);

        expandedView.setImageViewResource(R.id.big_icon, R.drawable.ic_settings_phone);
        expandedView.setTextViewText(R.id.timestamp, DateUtils.formatDateTime(this, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME));
        expandedView.setTextViewText(R.id.notification_message, "Hello Expanded World");

        collapsedView.setImageViewResource(R.id.big_icon, R.drawable.ic_settings_phone);
        collapsedView.setTextViewText(R.id.timestamp, DateUtils.formatDateTime(this, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME));

        Notification notification = new NotificationCompat.Builder(NotificationActivity.this, CHANNEL_ID)
                .setContentTitle("My Title")
                .setContentText("My Content Text")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_settings_phone)
                .setAutoCancel(true)
                .setOngoing(true)
                .setCustomBigContentView(expandedView)
                .setCustomContentView(collapsedView)
                .setStyle(new android.support.v4.app.NotificationCompat.DecoratedCustomViewStyle())
                .build();

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (manager != null)
            manager.notify(0, notification);
        else
            Toast.makeText(NotificationActivity.this, "NotificationManager is Null", Toast.LENGTH_SHORT).show();
    }

    public void send_broadcast_to_my_receiver(View view) {
        Intent intent = new Intent(NotificationActivity.this, NotificationReceiver.class);
        intent.setAction("com.example.www.androideverest.RECEIVER_ACTION");

        sendBroadcast(intent);
    }
}
