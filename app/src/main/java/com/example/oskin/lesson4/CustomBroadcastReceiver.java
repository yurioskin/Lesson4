package com.example.oskin.lesson4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class CustomBroadcastReceiver extends BroadcastReceiver {

    ViewCallback mCallback;

    CustomBroadcastReceiver(ViewCallback callback){
        this.mCallback = callback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        mCallback.onStatusChanged(intent.getStringExtra(MyIntentService.NEW_STATE));
    }

}
