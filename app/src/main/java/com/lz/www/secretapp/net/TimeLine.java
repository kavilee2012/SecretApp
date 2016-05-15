package com.lz.www.secretapp.net;

import android.content.Context;

import com.lz.www.secretapp.Config;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016-05-13.
 */
public class TimeLine {
    public TimeLine(String phoneMD5,String token,int page,int perPage, final SuccessCallback successCallback, final FailCallback failCallback) {
        new MyConnection(Config.ServerUrl, HttpMethod.POST, new MyConnection.SuccessCallback() {
            @Override
            public void onSuccess(String result) throws JSONException {
                try {
                    JSONObject obj=new JSONObject(result);
                    switch (obj.getInt(Config.KEY_STATUS)){
                        case Config.KEY_STATUS_SUCCESS:
                            if(successCallback!=null) {
                                successCallback.onSuccess(obj.getString(Config.KEY_TOKEN));
                            }
                            break;
                        default:
                            if(failCallback!=null)  {
                                failCallback.onFail();
                            }
                            break;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    if(failCallback!=null)  {
                        failCallback.onFail();
                    }
                }

            }
        }, new MyConnection.FailCallback() {
            @Override
            public void onFail() {
                if(failCallback!=null)  {
                    failCallback.onFail();
                }
            }
        }
                //    ,Config.Key_Action,Config.KEY_ACTION_TIMELINE,Config.KEY_PHONE_MD5,phoneMD5,Config.KEY_TOKEN,token,Config.KEY_PAGE,page, Config.KEY_PERPAGE,perPage,""
        );
    }


    public static interface SuccessCallback{
        void onSuccess(String result);
    }

    public static interface FailCallback{
        void onFail();
    }
}
