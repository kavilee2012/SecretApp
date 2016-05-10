package com.lz.www.secretapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lz.www.secretapp.atys.LoginActivity;
import com.lz.www.secretapp.atys.TimeLineActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String token=Config.getCachedToken(this);
        if(token!=null){
            Intent it=new Intent(this,TimeLineActivity.class);
            it.putExtra(Config.KEY_TOKEN,token);
            startActivity(it);
        }else {
            Intent it=new Intent(this, LoginActivity.class);
            startActivity(it);
        }
        finish();
    }
}
