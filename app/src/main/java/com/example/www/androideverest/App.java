package com.example.www.androideverest;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

//    این متغییر برای API های 26 و بالاتر ضروری است
    public static final String CHANNEL_ID = "ForegroundServiceTestChannel";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();
    }

    private void createNotificationChannel() {

//        مقایسه API کاربر با API-26
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

//            ایجاد این شی برای API های 26 و بالاتر ضروری است
            NotificationChannel notificationChannel = new NotificationChannel(
                    CHANNEL_ID,
                    "Foreground Service Test",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationManager manager = getSystemService(NotificationManager.class);

//            ایجاد یک کانال برای نمایش نوتیفیکیشن ها که در API-26 و بالاتر ضروری است
            if (manager != null)
                manager.createNotificationChannel(notificationChannel);
        }
    }
}
