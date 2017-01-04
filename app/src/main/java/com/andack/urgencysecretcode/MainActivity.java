package com.andack.urgencysecretcode;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button accept_btn;
    private EditText sender_et;
    private EditText sendContent_et;
    private SharePreferencesTools sharePreferencesTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        sharePreferencesTools=new SharePreferencesTools(this);
        accept_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData();
            }
        });

    }

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
