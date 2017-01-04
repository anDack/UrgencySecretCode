package com.andack.urgencysecretcode;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button accept_btn;
    private EditText sender_et;
    private EditText sendContent_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        accept_btn= (Button) findViewById(R.id.acceptBtn);
        sender_et= (EditText) findViewById(R.id.senderEd);
        sendContent_et= (EditText) findViewById(R.id.contentEd);
    }
}
