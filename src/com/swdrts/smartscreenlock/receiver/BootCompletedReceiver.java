package com.swdrts.smartscreenlock.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.swdrts.smartscreenlock.service.SmartScreenLockService;

public class BootCompletedReceiver extends BroadcastReceiver{

    private static final String TAG = "BootCompletedReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        Log.d(TAG, "receive intent = "+intent);
        Intent smartScreenLockServiceIntent = new Intent(context, SmartScreenLockService.class);
        context.startService(smartScreenLockServiceIntent);
    }

}
