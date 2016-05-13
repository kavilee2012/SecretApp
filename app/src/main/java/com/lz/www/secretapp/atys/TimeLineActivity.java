package com.lz.www.secretapp.atys;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.lz.www.secretapp.Config;
import com.lz.www.secretapp.R;
import com.lz.www.secretapp.data.MyContact;
import com.lz.www.secretapp.net.TimeLine;
import com.lz.www.secretapp.net.UploadContract;



/**
 * Created by Administrator on 2016-05-10.
 */
public class TimeLineActivity extends ListActivity {

    String phoneNum,token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline_layout);


        phoneNum =getIntent().getStringExtra(Config.KEY_PHONE_NUM);
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

    private void LoadMessage(){
//        final ProgressDialog pd=ProgressDialog.show(this,getResources().getString(R.string.con));

        new TimeLine(phoneNum, token, 1, 28, new TimeLine.SuccessCallback() {
            @Override
            public void onSuccess(String result) {
//                pd.dismiss();
            }
        }, new TimeLine.FailCallback() {
            @Override
            public void onFail() {
//                pd.dismiss();
                Toast.makeText(TimeLineActivity.this,"加载失败",Toast.LENGTH_LONG).show();
            }
        });
    }

}
