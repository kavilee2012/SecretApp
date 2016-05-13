package com.lz.www.secretapp.net;

import android.os.AsyncTask;

import com.lz.www.secretapp.Config;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016-05-10.
 */
public class MyConnection {
    public MyConnection(final String url,final HttpMethod method,SuccessCallback successCallback,FailCallback failCallback,final String... kvs) {

        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... args) {
                StringBuffer pasStr = new StringBuffer();
                for (int i = 0; i < kvs.length; i += 2) {
                    pasStr.append(kvs[i]).append("_").append(kvs[i + 1]).append("&");
                }


                try {
                    URLConnection uc = new URL(url).openConnection();
                    switch (method) {
                        case POST:
                            uc.setDoOutput(true);
                            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(uc.getOutputStream(), Config.CHARSET));
                            bw.write(pasStr.toString());
                            break;
                        default:
                            uc = new URL(url + "?" + pasStr.toString()).openConnection();
                            break;
                    }

                    BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream(), Config.CHARSET));
                    String line = null;
                    StringBuffer result = new StringBuffer();
                    while ((line = br.readLine()) != null) {
                        result.append(line);
                    }
                    return result.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

    }

    public static interface SuccessCallback{
        void onSuccess(String result) throws JSONException;
    }

    public static interface FailCallback{
        void onFail();
    }
}
