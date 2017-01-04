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
   public static void createSharedPre(Context context)
   {
       SharedPreferences sharedPre=context.getSharedPreferences("data",Context.MODE_PRIVATE);
   }

}
