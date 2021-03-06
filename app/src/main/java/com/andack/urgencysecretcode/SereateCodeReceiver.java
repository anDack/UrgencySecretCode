package com.andack.urgencysecretcode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationListener;

import static android.content.ContentValues.TAG;

/**
 * Created by anDack on 2017/1/5.
 * 邮箱：1160083806@qq.com
 * <p>                      _oo0oo_
 * <p>                   o8888888o
 * <p>                    88" . "88
 * <p>                   (| -_- |)
 * <p>                    0\  =  /0
 * <p>                  ___/`---'\___
 * <p>                .' \\|     |// '.
 * <p>               / \\|||  :  |||// \
 * <p>              / _||||| -:- |||||- \
 * <p>             |   | \\\  -  /// |   |
 * <p>             | \_|  ''\---/''  |_/ |
 * <p>             \  .-\__  '-'  ___/-. /
 * <p>           ___'. .'  /--.--\  `. .'___
 * <p>        ."" '<  `.___\_<|>_/___.' >' "".
 * <p>       | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * <p>       \  \ `_.   \_ __\ /__ _/   .-` /  /
 * <p>   =====`-.____`.___ \_____/___.-`___.-'=====
 * <p>                     `=---='
 * <p>
 * <p>
 * <p>   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <p>
 * <p>            佛祖保佑         永无BUG
 */

public class SereateCodeReceiver extends BroadcastReceiver {

    private Context mContext;
    private AMapLocationClient locationClient=null;
    private SharePreferencesTools sharePreferencesTools;
    @Override
    public void onReceive(Context context, Intent intent)
    {
        this.mContext=context;
        Toast.makeText(context,"调用暗码成功",Toast.LENGTH_SHORT).show();
        sharePreferencesTools=new SharePreferencesTools(mContext);
        initLocation();
        locationClient.startLocation();
    }

    private void sendMsm() {
        SmsManager smsManager=SmsManager.getDefault();
        Log.i("isLocatal", "sendMsm:"+sharePreferencesTools.getSender());
        smsManager.sendTextMessage(sharePreferencesTools.getSender(),null,sharePreferencesTools.getRes(),null,null);
    }

    private void initLocation() {
        //初始化client
        locationClient=new AMapLocationClient(mContext);
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
                String localRes=StringUtil.getLocationStr(aMapLocation,mContext);

                sharePreferencesTools.setLocation(localRes);
                Log.i(TAG, "onLocationChanged: "+sharePreferencesTools.getLocation());
                sendMsm();
                locationClient.stopLocation();

            }
        }
    };

}
