package com.lianghuawang.cottonfarmer.module.login;

import android.content.Intent;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.HomePageActivity;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.ui.base.BaseMVPACtivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 *
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

    private Handler handler;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

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
                mPresenter.captcha(mCaptcha);
                break;
            default:
        }
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void login() {
        LogUtils.d("一切合法,开始请求登录接口");
        ToastUtils.showLong(this, getResources().getText(R.string.loginsuccess));
        startActivity(new Intent(this, HomePageActivity.class));
        this.finish();
    }

    @Override
    public void captcha(String message) {
        mCaptcha.setText(message);
    }
}
