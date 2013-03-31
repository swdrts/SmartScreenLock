
package com.swdrts.smartscreenlock.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import com.swdrts.smartscreenlock.receiver.ScreenLockReceiver;

public class SmartScreenLockService extends Service {

    private static final String TAG = "SmartScreenLockService";

    private Intent startIntent = null;// save startService intent for restart
                                      // service

    ScreenLockReceiver screenLockReceiver = null;

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onBind");
        return null;
    }

    /*
     * (non-Javadoc)
     * @see android.app.Service#onCreate()
     */
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onCreate");
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        screenLockReceiver = new ScreenLockReceiver();
        registerReceiver(screenLockReceiver, filter);
        super.onCreate();
    }

    /*
     * (non-Javadoc)
     * @see android.app.Service#onDestroy()
     */
    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onDestroy");
        this.unregisterReceiver(screenLockReceiver);
        if (startIntent != null) {
            this.startService(startIntent);
        }
        super.onDestroy();
    }

    /*
     * (non-Javadoc)
     * @see android.app.Service#onStartCommand(android.content.Intent, int, int)
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        Log.d(TAG, TAG + " onStartCommand");
        startIntent = intent;
        return super.onStartCommand(intent, flags, startId);
    }

}
