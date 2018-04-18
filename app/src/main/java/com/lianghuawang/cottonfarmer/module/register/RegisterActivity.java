package com.lianghuawang.cottonfarmer.module.register;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.HomePageActivity;
import com.lianghuawang.cottonfarmer.module.login.LoginActivity;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.ui.base.BaseMVPACtivity;

import butterknife.Bind;
import butterknife.OnClick;

public class RegisterActivity extends BaseMVPACtivity<RegisterPresenter,RegisterModel> implements RegisterView{

    @Bind(R.id.et_mobile)
    EditText mUsername;
    @Bind(R.id.et_password)
    EditText mPassword;
    @Bind(R.id.btn_login)
    Button mRegister;
    @Bind(R.id.btn_login_captcha)
    Button mCaptcha;
    @Bind(R.id.tv_back_login)
    TextView mBackLogin;

    private Handler handler;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        mBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                RegisterActivity.this.finish();
                overridePendingTransition(android.R.anim.slide_out_right,android.R.anim.slide_in_left);
            }
        });
    }

    @OnClick({R.id.btn_login, R.id.btn_login_captcha})
    public void onClick(Button btn) {
        switch (btn.getId()) {
            case R.id.btn_login:
                String user = mUsername.getText().toString();
                String pass = mPassword.getText().toString();
                mPresenter.startRegister(this, user, pass);
                break;
            case R.id.btn_login_captcha:
                mPresenter.captcha(mCaptcha);
                break;
            default:
        }
    }

    @Override
    public void register() {
        LogUtils.d("一切合法,开始请求登录接口");
        ToastUtils.showLong(this, getResources().getText(R.string.registerSuccess));
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
