package com.example.oskin.lesson4;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mTextView;
    private CustomBroadcastReceiver mBroadcastReceiver;
    private IntentFilter mIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
        init();
    }

    private void initViews() {
        mButton = findViewById(R.id.button_main_change_state);
        mTextView = findViewById(R.id.text_view_main_state);
    }

    private void initListeners() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(MyIntentService.newIntent(MainActivity.this, MyIntentService.ACTION_CHANGE_STATE));
            }
        });
    }

    private void init() {
        mBroadcastReceiver = new CustomBroadcastReceiver(new ViewCallbackImp());
        mIntentFilter = new IntentFilter("com.example.oskin.lesson4.SEND_MESSAGES_FILTER");
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mBroadcastReceiver,mIntentFilter,null,null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mBroadcastReceiver);
    }

    private class ViewCallbackImp implements ViewCallback{

        @Override
        public void onStatusChanged(String newState) {
            mTextView.setText(getResources().getString(R.string.current_state_is, newState));
        }
    }
}
