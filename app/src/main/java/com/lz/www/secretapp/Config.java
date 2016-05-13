package com.lz.www.secretapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016-05-10.
 */
public class Config {

    public static final String KEY_TOKEN="token";
    public static final String APP_ID="com.lz.secret";
    public static final String CHARSET="utf-8";
    public static final String ServerUrl="";
    public static final String Key_Action="";
    public static final String Action_Login="";
    public static final String KEY_PHONE_MD5="";
    public static final String KEY_PHONE_NUM="";
    public static final String Key_Code="";
    public static final String KEY_STATUS="";
    public static final int KEY_STATUS_SUCCESS=0;
    public static final String KEY_STATUS_FAIL="";
    public static final String KEY_ACTION_TIMELINE="";
    public static final String KEY_PAGE="";
    public static final String KEY_PERPAGE="";



    public static String getCachedToken(Context context){
        return context.getSharedPreferences(APP_ID,Context.MODE_PRIVATE).getString(KEY_TOKEN,null);
    }

    public static void cacheToken(Context context,String token){
        SharedPreferences.Editor e=context.getSharedPreferences(APP_ID,Context.MODE_PRIVATE).edit();
        e.putString(KEY_TOKEN,token);
        e.commit();
    }
}
