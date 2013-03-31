
package com.swdrts.smartscreenlock.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.swdrts.smartscreenlock.service.SmartScreenLockService;

public class BootCompletedReceiver extends BroadcastReceiver {

    private static final String TAG = "BootCompletedReceiver";

    private static final String BOOT_ACTION = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        Log.d(TAG, "receive intent = " + intent);
        if (intent.getAction().equals(BOOT_ACTION)) {
            Intent smartScreenLockServiceIntent = new Intent(context, SmartScreenLockService.class);
            context.startService(smartScreenLockServiceIntent);
        }
    }

}
