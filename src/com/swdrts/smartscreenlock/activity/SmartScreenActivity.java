
package com.swdrts.smartscreenlock.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.swdrts.smartscreenlock.R;
import com.swdrts.smartscreenlock.service.SmartScreenLockService;

public class SmartScreenActivity extends Activity {

    private static final String TAG = "SmartScreenActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, TAG + " oncreate");
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);// remove title bar
        // show the activity when screen lock
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

        setContentView(R.layout.activity_smart_screen_lock);
        Intent smartScreenLockServiceIntent = new Intent(this, SmartScreenLockService.class);
        this.startService(smartScreenLockServiceIntent);
    }

}
