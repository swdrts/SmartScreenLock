
package com.swdrts.smartscreenlock.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.swdrts.smartscreenlock.activity.SmartScreenActivity;

public class ScreenLockReceiver extends BroadcastReceiver {

    private static final String TAG = "ScreenLockReceiver";

    private static final String SCREEN_ON = "android.intent.action.SCREEN_ON";

    private static final String SCREEN_OFF = "android.intent.action.SCREEN_OFF";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        Log.d(TAG, "receive intent = " + intent);
        String action = intent.getAction();
        if (action.equals(SCREEN_ON)) {
            Intent smartScreenIntent = new Intent(context, SmartScreenActivity.class);
            smartScreenIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(smartScreenIntent);
        } else if (action.equals(SCREEN_OFF)) {

        }
    }

}
