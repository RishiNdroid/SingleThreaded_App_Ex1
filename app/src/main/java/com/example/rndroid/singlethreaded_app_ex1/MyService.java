package com.example.rndroid.singlethreaded_app_ex1;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by rndroid on 16/1/17.
 */

public class MyService extends IntentService {

    Handler handler;

    public MyService() {
        super("My_Thread_01");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        // from here you cant touch UI

        handler = new Handler(Looper.getMainLooper());// this will call the MAIN UI THREAD
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "Inside Service", Toast.LENGTH_SHORT).show();
            }
        });
        Log.d("Mythread", "service is started");
    }
}
