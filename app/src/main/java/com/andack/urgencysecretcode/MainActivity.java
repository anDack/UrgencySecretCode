package com.andack.urgencysecretcode;

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
    private SharePreferencesTools sharePreferencesTools;
    private AMapLocationClient locationClient=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initLocation();
        sharePreferencesTools=new SharePreferencesTools(this);
        accept_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData();
            }
        });

    }
    private void initLocation() {
        //初始化client
        locationClient=new AMapLocationClient(this.getApplicationContext());
        //设置定位参数
        locationClient.setLocationOption(LocationUtils.getLocationOption());
        //设置定位监听
        locationClient.setLocationListener(locationListener);

    }
    AMapLocationListener locationListener=new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (null!=aMapLocation)
            {
                String localRes=StringUtil.getLocationStr(aMapLocation,MainActivity.this);
                sharePreferencesTools.setLocation(localRes);
                Log.i(TAG, "onLocationChanged: "+sharePreferencesTools.getLocation());
            }
        }
    };
    private void setData() {
        String sender=sender_et.getText().toString();
        String content=sendContent_et.getText().toString();
//        sharePreferencesTools.isSharedPre();
        if (!sender.equals(null)&& !content.equals(null))
        {
            sharePreferencesTools.setSharedPre(sender,content);//设置sender和content
//            Log.i(TAG, "setData: "+ sharePreferencesTools.getSender());
        }else {
            Toast.makeText(MainActivity.this, R.string.input_note,Toast.LENGTH_SHORT).show();
        }

    }

    private void initView() {
        accept_btn= (Button) findViewById(R.id.acceptBtn);
        sender_et= (EditText) findViewById(R.id.senderEd);
        sendContent_et= (EditText) findViewById(R.id.contentEd);
    }
}
