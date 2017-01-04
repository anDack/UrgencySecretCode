package com.andack.urgencysecretcode;

import android.content.Context;
import android.content.SharedPreferences;

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
    private Context mContext;
    public SharePreferencesTools(Context context)
    {
        this.mContext=context;
    }

    /**
     * 是否有创建SharePreferences
     * @return true 已经存在 false 不存在需要新建
     */
    public boolean isSharePre()
    {
        boolean isShare=false;
        SharedPreferences sharedPreferences=mContext.getSharedPreferences("data",
                Context.MODE_PRIVATE);
        if(!sharedPreferences.getString("sender",null).equals(null))
        {
            isShare=true;
        }
        return  isShare;
    }
}
