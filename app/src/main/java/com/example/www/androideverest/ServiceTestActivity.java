package com.example.www.androideverest;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ServiceTestActivity extends AppCompatActivity {

    private ServiceTest serviceTest;
    private boolean isBound = false;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("ServiceTestActivity", "onServiceConnected()");
            ServiceTest.LocalBinder binder = (ServiceTest.LocalBinder) service;
            serviceTest = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("ServiceTestActivity", "onServiceDisconnected()");
            isBound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
    }

    public void startServiceTest(View v) {
        startService(new Intent(ServiceTestActivity.this, ServiceTest.class));
    }

    public void stopServiceTest(View v) {
        stopService(new Intent(ServiceTestActivity.this, ServiceTest.class));
    }

    public void bindServiceTest(View v) {
        Intent intent = new Intent(ServiceTestActivity.this, ServiceTest.class);
        bindService(intent, connection, BIND_AUTO_CREATE);
    }

    public void unbindServiceTest(View v) {
        if (isBound) {
            unbindService(connection);
            isBound = false;
        }
    }
}
