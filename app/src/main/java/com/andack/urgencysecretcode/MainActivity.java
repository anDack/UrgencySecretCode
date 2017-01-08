package com.andack.urgencysecretcode;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends CheckPermissionsActivity {
    private static final String TAG = "MainActivity";
//    private Button accept_btn;
//    private EditText sender_et;
//    private EditText sendContent_et;
    private RecyclerView recyclerView;
    private SharePreferencesTools sharePreferencesTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        sharePreferencesTools=new SharePreferencesTools(this);
//        accept_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setData();
//            }
//        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

//    private void setData() {
//        String sender=sender_et.getText().toString();
//        String content=sendContent_et.getText().toString();
//        if (!sender.equals(null)&& !content.equals(null))
//        {
//            sharePreferencesTools.setSharedPre(sender,content);//设置sender和content
//            Log.i(TAG, "setData: "+ sharePreferencesTools.getSender());
//        }else {
//            Toast.makeText(MainActivity.this, R.string.input_note,Toast.LENGTH_SHORT).show();
//        }
//
//    }

    private void initView() {
//        accept_btn= (Button) findViewById(R.id.acceptBtn);
//        sender_et= (EditText) findViewById(R.id.senderEd);
//        sendContent_et= (EditText) findViewById(R.id.contentEd);
        recyclerView= (RecyclerView) findViewById(R.id.recycler);
//        String[] mData=new String[]{"暗码1","暗码2","暗码3","暗码4"};
        ArrayList<String> mData=new ArrayList<String>();
        setData(mData);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerAdapter Adapter =new recyclerAdapter(this,mData);
        recyclerView.setAdapter(Adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public void setData(ArrayList<String> data) {
        data.add("暗码1");
        data.add("暗码2");
        data.add("暗码3");
        data.add("暗码4");
    }
}
