package com.lianghuawang.cottonfarmer.mvp.module.login;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.HomePageActivity;
import com.lianghuawang.cottonfarmer.mvp.module.register.RegisterActivity;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.ui.base.BaseMVPACtivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.LoginUtils;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * create by fanwenke at 2018/7/3
 * 登录页面
 * bug:在用户尚未注册时，输入手机号，点击获取验证码，还是能进行倒计时，不合理
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
    Button mNewRegister;
    @Bind(R.id.iv_login_back)
    ImageView mBack;
    private static int SUCCESSCODE;

    private Handler handler;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        SUCCESSCODE = getIntent().getIntExtra("resultCode",1);
        mNewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    @OnClick({R.id.btn_login, R.id.btn_login_captcha, R.id.iv_login_back})
    public void onClick(View btn) {
        switch (btn.getId()) {
            case R.id.btn_login:
                String user = mUsername.getText().toString();
                String pass = mPassword.getText().toString();
                mPresenter.startlogin(this, user, pass);
                break;
            case R.id.btn_login_captcha:
                String phoneNumber = mUsername.getText().toString().trim();
                mPresenter.captcha(this,mCaptcha,phoneNumber);
                break;
            case R.id.iv_login_back:
                onBackPressed();
                break;
            default:
        }
    }

    @Override
    public void login() {
        ToastUtils.showLong(this, getResources().getText(R.string.loginsuccess));
//        startActivity(new Intent(this, HomePageActivity.class));
        setResult(SUCCESSCODE);
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
