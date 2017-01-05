package com.andack.urgencysecretcode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationListener;

public class MainActivity extends CheckPermissionsActivity {
    private static final String TAG = "MainActivity";
    private Button accept_btn;
    private EditText sender_et;
    private EditText sendContent_et;
    private SendStatus sendSt;
    private SharePreferencesTools sharePreferencesTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        IntentFilter intentF=new IntentFilter();
//        intentF.addAction("SENT_SMS_ACTION");
//        sendSt=new SendStatus();
//        registerReceiver(sendSt,intentF);

        sharePreferencesTools=new SharePreferencesTools(this);
        accept_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(sendSt);
    }

    private void setData() {
        String sender=sender_et.getText().toString();
        String content=sendContent_et.getText().toString();
//        sharePreferencesTools.isSharedPre();
        if (!sender.equals(null)&& !content.equals(null))
        {
            sharePreferencesTools.setSharedPre(sender,content);//设置sender和content
            Log.i(TAG, "setData: "+ sharePreferencesTools.getSender());
        }else {
            Toast.makeText(MainActivity.this, R.string.input_note,Toast.LENGTH_SHORT).show();
        }

    }

    private void initView() {
        accept_btn= (Button) findViewById(R.id.acceptBtn);
        sender_et= (EditText) findViewById(R.id.senderEd);
        sendContent_et= (EditText) findViewById(R.id.contentEd);
    }
    class SendStatus extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (getResultCode()==RESULT_OK)
            {
                Log.i(TAG, "onReceive: send is ok");
            }else {
                Log.i(TAG, "onReceive: fail to send");
            }
        }
    }
}
