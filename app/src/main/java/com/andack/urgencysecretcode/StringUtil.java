package com.andack.urgencysecretcode;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;

import java.text.SimpleDateFormat;
import java.util.Locale;

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

public class StringUtil {
    private static final String TAG = "StringUtil";
    public synchronized static String getLocationStr(AMapLocation location, Context context)
    {
        if(null == location){
            return null;
        }
        StringBuffer sb = new StringBuffer();
        if(location.getErrorCode() == 0){
//            sb.append("经度: " + location.getLongitude() + " ");
//            sb.append("纬度: " + location.getLatitude() + " ");
            sb.append("地址: " + location.getAddress() + " ");
//            sb.append("定位时间: " + formatUTC(location.getTime(), "yyyy-MM-dd HH:mm:ss"));

        }else {
            Toast.makeText(context,"定位失败",Toast.LENGTH_SHORT).show();
            sb.append("定位不成功!");
            Log.i(TAG, "getLocationStr: 错误码: "+location.getErrorCode() +"\n"
                    +"错误信息: "+location.getErrorInfo()+"\n"
                    + "错误描述："+location.getLocationDetail()+"\n");
        }
        return sb.toString();
    }
    private static SimpleDateFormat sdf = null;
    /**
     * 格式化时间
     * @param l
     * @param strPattern
     * @return 返回yyyy-MM-dd HH:mm:ss
     */
    public synchronized static String formatUTC(long l, String strPattern) {
        if (TextUtils.isEmpty(strPattern)) {
            strPattern = "yyyy-MM-dd HH:mm:ss";
        }
        if (sdf == null) {
            try {
                sdf = new SimpleDateFormat(strPattern, Locale.CHINA);
            } catch (Throwable e) {
            }
        } else {
            sdf.applyPattern(strPattern);
        }
        return sdf == null ? "NULL" : sdf.format(l);
    }
}
