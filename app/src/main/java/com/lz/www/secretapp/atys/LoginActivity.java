package com.lz.www.secretapp.atys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lz.www.secretapp.Config;
import com.lz.www.secretapp.R;
import com.lz.www.secretapp.net.Login;

/**
 * Created by Administrator on 2016-05-10.
 */
public class LoginActivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        final EditText etPhone=(EditText)findViewById(R.id.editPhone);

        Button btnLogin=(Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(etPhone.getText())){
                    Toast.makeText(LoginActivity.this,"手机号码不能为空",Toast.LENGTH_LONG).show();
                    return;
                }

                new Login(Config.KEY_PHONE_MD5, "code", new Login.SuccessCallback() {
                    @Override
                    public void onSuccess(String result) {
                        Config.cacheToken(LoginActivity.this,result);
                        Intent it=new Intent(LoginActivity.this,TimeLineActivity.class);
                        startActivity(it);
                        finish();
                    }
                }, new Login.FailCallback() {
                    @Override
                    public void onFail() {
                        Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_LONG).show();


                    }
                });

            }
        });
    }


}
