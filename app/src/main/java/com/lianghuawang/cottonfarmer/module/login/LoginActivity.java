package com.lianghuawang.cottonfarmer.module.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.HomePageActivity;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.LoginUtils;

import butterknife.Bind;
import butterknife.OnClick;

/**
 *
 */

public class LoginActivity extends BaseActivity {

    @Bind(R.id.et_mobile)
    EditText mUsername;
    @Bind(R.id.et_password)
    EditText mPassword;
    @Bind(R.id.btn_login)
    Button mLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @OnClick(R.id.btn_login)
    public void onClick(){
        String user = mUsername.getText().toString();
        String pass = mPassword.getText().toString();
        if (LoginUtils.IsEmpty(this,user,pass)){
            LogUtils.d("一切合法,开始请求登录接口");
            startActivity(new Intent(this, HomePageActivity.class));
            this.finish();
        }
    }
}
