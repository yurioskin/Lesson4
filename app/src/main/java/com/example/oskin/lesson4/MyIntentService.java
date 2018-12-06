package com.example.oskin.lesson4;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

public class MyIntentService extends IntentService {
    public static final String ACTION_CHANGE_STATE = "com.example.oskin.lesson4.action.change.state";

    public static final String NEW_STATE = "com.example.oskin.lesson4.key.new.state";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent receivedIntent) {
        if (receivedIntent != null) {
            final String action = receivedIntent.getAction();
            if (ACTION_CHANGE_STATE.equals(action)) {
                Intent intent = new Intent("com.example.oskin.lesson4.SEND_MESSAGES_FILTER");
                StateManager stateManager = StateManager.getInstance();
                intent.putExtra(NEW_STATE, stateManager.getState());
                sendBroadcast(intent);
            }
        }
    }

    public static Intent newIntent(Context context, String action){
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(action);
        return intent;
    }
}
