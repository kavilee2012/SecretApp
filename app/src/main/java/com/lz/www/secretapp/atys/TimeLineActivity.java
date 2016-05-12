package com.lz.www.secretapp.atys;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;

import com.lz.www.secretapp.Config;
import com.lz.www.secretapp.R;
import com.lz.www.secretapp.data.MyContact;
import com.lz.www.secretapp.net.UploadContract;

/**
 * Created by Administrator on 2016-05-10.
 */
public class TimeLineActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_layout);

        String phoneNum =getIntent().getStringExtra(Config.KEY_PHONE_NUM);
        String token=getIntent().getStringExtra(Config.KEY_TOKEN);
//        String phoneMD5=
        new UploadContract(phoneNum, token, MyContact.getContractJsonString(this), new UploadContract.SuccessCallback() {
            @Override
            public void onSuccess(String result) {

            }
        }, new UploadContract.FailCallback() {
            @Override
            public void onFail() {

            }
        });
    }
}
