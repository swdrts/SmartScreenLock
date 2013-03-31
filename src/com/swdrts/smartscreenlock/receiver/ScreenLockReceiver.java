package com.swdrts.smartscreenlock.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ScreenLockReceiver extends BroadcastReceiver{

    private static final String TAG = "ScreenLockReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        Log.d(TAG, "receive intent = "+intent);
    }

}
