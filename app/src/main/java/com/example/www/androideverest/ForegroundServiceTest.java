package com.example.www.androideverest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import static com.example.www.androideverest.App.CHANNEL_ID;

public class ForegroundServiceTest extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String input = intent.getStringExtra("inputExtra");

        Intent notificationIntent = new Intent(ForegroundServiceTest.this, ForegroundServiceTestActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                ForegroundServiceTest.this,
                0,
                notificationIntent,
                0);

        Notification notification = new NotificationCompat.Builder(ForegroundServiceTest.this, CHANNEL_ID)
                .setContentTitle("Foregournd Service Test")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1, notification);

        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(ForegroundServiceTest.this, "Service onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(ForegroundServiceTest.this, "Service onDestroy()", Toast.LENGTH_SHORT).show();
    }
}
