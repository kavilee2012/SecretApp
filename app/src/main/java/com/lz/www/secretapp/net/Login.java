package com.lz.www.secretapp.net;

import com.lz.www.secretapp.Config;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016-05-11.
 */
public class Login {
    public Login(String phoneMD5, String code, final SuccessCallback successCallback,final FailCallback failCallback) {
        new MyConnection(Config.ServerUrl, HttpMethod.POST, new MyConnection.SuccessCallback() {
            @Override
            public void onSuccess(String result){
                try {
                    JSONObject obj=new JSONObject(result);
                    switch (obj.getInt(Config.KEY_TOKEN)){
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
                }


            }
        }, new MyConnection.FailCallback() {
            @Override
            public void onFail() {
                if(failCallback!=null){
                    failCallback.onFail();
                }

            }
        },Config.Key_Action,Config.Action_Login,Config.KEY_PHONE_MD5,phoneMD5,Config.Key_Code,code);

    }

    public static interface SuccessCallback {
        void onSuccess(String result);
    }

    public static interface FailCallback {
        void onFail();
    }
}

















