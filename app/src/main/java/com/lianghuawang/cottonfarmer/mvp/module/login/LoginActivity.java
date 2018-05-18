package com.lianghuawang.cottonfarmer.mvp.module.login;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.HomePageActivity;
import com.lianghuawang.cottonfarmer.mvp.module.register.RegisterActivity;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.ui.base.BaseMVPACtivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 *登录页
 */

public class LoginActivity extends BaseMVPACtivity<LoginPresenter, LoginModel> implements LoginView {

    @Bind(R.id.et_mobile)
    EditText mUsername;
    @Bind(R.id.et_password)
    EditText mPassword;
    @Bind(R.id.btn_login)
    Button mLogin;
    @Bind(R.id.btn_login_captcha)
    Button mCaptcha;
    @Bind(R.id.tv_new_regist)
    TextView mNewRegister;

    private Handler handler;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        mNewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                LoginActivity.this.finish();
            }
        });
    }

    @OnClick({R.id.btn_login, R.id.btn_login_captcha})
    public void onClick(Button btn) {
        switch (btn.getId()) {
            case R.id.btn_login:
                String user = mUsername.getText().toString();
                String pass = mPassword.getText().toString();
                mPresenter.startlogin(this, user, pass);
                break;
            case R.id.btn_login_captcha:
                String phoneNumber = mUsername.getText().toString().trim();
                mPresenter.captcha(mCaptcha,phoneNumber);
                break;
            default:
        }
    }

    @Override
    public void login() {
        ToastUtils.showLong(this, getResources().getText(R.string.loginsuccess));
        startActivity(new Intent(this, HomePageActivity.class));
        this.finish();
    }

    @Override
    public void captcha(String message) {
        mCaptcha.setText(message);
    }

    @Override
    protected void loadData() {

    }


}
