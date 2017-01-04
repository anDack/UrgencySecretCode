package com.andack.urgencysecretcode;

import android.content.Context;
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
        accept_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setData();
                SharedPreferences share=getSharedPreferences("data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=share.edit();
                editor.putString("sender","as");
                editor.commit();
            }
        });

    }

    private void setData() {
        String sender=sender_et.getText().toString();
        String content=sendContent_et.getText().toString();
//        sharePreferencesTools.isSharedPre();
        sharePreferencesTools.createSharedPre(MainActivity.this);
        if (!sender.equals(null)&& !content.equals(null))
        {

        }else {
        }

    }

    private void initView() {
        accept_btn= (Button) findViewById(R.id.acceptBtn);
        sender_et= (EditText) findViewById(R.id.senderEd);
        sendContent_et= (EditText) findViewById(R.id.contentEd);
    }
}
