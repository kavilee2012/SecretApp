package com.lz.www.secretapp.net;

import android.os.AsyncTask;

/**
 * Created by Administrator on 2016-05-10.
 */
public class MyConnection {
    public MyConnection(String url,HttpMethod method,SuccessCallback successCallback,FailCallback failCallback, String... kvs) {

//        new AsyncTask<Void, Void, String>() {
//            @Override
//            protected String doInBackground(Void... voids) {
//                return null;
//            }
//        }

    }

    public static interface SuccessCallback{
        void onSuccess(String result);
    }

    public static interface FailCallback{
        void onFail();
    }
}
