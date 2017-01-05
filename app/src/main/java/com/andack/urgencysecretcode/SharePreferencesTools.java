package com.andack.urgencysecretcode;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by anDack on 2017/1/4.
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

public class SharePreferencesTools {
    private static final String TAG = "Tools";
    private Context mContext;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public SharePreferencesTools(Context context)
    {
        this.mContext=context;
        this.sharedPreferences=mContext.getSharedPreferences("data",Context.MODE_PRIVATE);

        this.editor=sharedPreferences.edit();
        Log.i(TAG, "SharePreferencesTools: shareIs create");
    }

    /**
     * 是否有创建SharePreferences
     * @return true 已经存在 false 不存在需要新建
     */
//    public boolean isSharedPre()
//    {
//        boolean isShare=false;
//        if(!sharedPreferences.getString("sender",null).equals(null))
//        {
//            isShare=true;
//        }
//        return  isShare;
//    }
    public void setLocation(String location)
    {
        editor.putString("location",location);
    }
    /**
     * 用来重置数据,没软用
     */
    public void restSharedPre()
    {

        editor.putString("sender",null);
        editor.putString("content",null);
        editor.commit();
    }

    /**
     * 用来设置数据
     * @param sender 设置发送的电话号码
     * @param content 设置发送的内容
     */
    public void setSharedPre(String sender,String content)
    {
        editor.putString("sender",sender);
        editor.putString("content",content);
        editor.commit();
    }
    public String getRes()
    {
//        String sender=sharedPreferences.getString("sender",null);
        StringBuffer sb=new StringBuffer();
        sb.append("sender is "+sharedPreferences.getString("sender",null));
        sb.append("location is "+sharedPreferences.getString("location",null));
        sb.append("content is "+sharedPreferences.getString("content",null));
        return sb.toString();
    }
    public String getLocation()
    {
        String sender=sharedPreferences.getString("location",null);
//        StringBuffer sb=new StringBuffer();
//        sb.append("location is "+sharedPreferences.getString("location",null));
        return sender;
    }

}
