package com.example.safeyapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.safeyapp.ui.HomeActivity;

/**全局的SharedPreferences的工具类
 * Created by 似水流年 on 2016/5/17.
 */
public class SpUtils {
    public static final String NAME = "safetyApp";
    private  static SharedPreferences mPreferences;
    public   static void  putString (Context context,String key, String value){

        SharedPreferences sp =  getPreferences(context);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key,value);
        edit.apply();

    }

    private static SharedPreferences getPreferences(Context context) {
        if (mPreferences == null){
            mPreferences = context.getSharedPreferences(NAME,Context.MODE_APPEND);
        }
        return mPreferences;
    }

    /**
     * 获得一个String类型的数据， 如果没有，则返回null
     * @param context
     * 上下文
     * @param key
     * sp的key
     * @return 拿到返回的结果
     *
     */
    public static String getString(Context context, String key) {
        return  getString(context,key,null);

    }

    /**
     * 获得String类型的数据
     * @param context
     * 上下文
     * @param key、
     *  sp的key
     * @param defValue
     * @return
     */
    private static String getString(Context context, String key, String defValue) {
        SharedPreferences sp = getPreferences(context);
        return sp.getString(key,defValue);
    }

}
