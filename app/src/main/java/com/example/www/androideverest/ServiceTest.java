package com.example.www.androideverest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class ServiceTest extends Service {

    private final IBinder binder = new LocalBinder();

    public class LocalBinder extends Binder {
        ServiceTest getService() {
            return ServiceTest.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("ServiceTest", "onBind()");
        return binder;
//        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("ServiceTest", "onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.i("ServiceTest", "onRebind()");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("ServiceTest", "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("ServiceTest", "onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("ServiceTest", "onDestroy()");
    }
}
