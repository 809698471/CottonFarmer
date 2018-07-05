package com.lianghuawang.cottonfarmer.mvp.module.register;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity.EssentialInformationActivity;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.ui.base.BaseMVPACtivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;

import butterknife.Bind;
import butterknife.OnClick;
/**
 * create by fanwenke at 2018/7/3
 * 注册页面
 *
 */
public class RegisterActivity extends BaseMVPACtivity<RegisterPresenter,RegisterModel> implements RegisterView{

    @Bind(R.id.et_mobile)
    EditText mUsername;
    @Bind(R.id.et_password)
    EditText mPassword;
    @Bind(R.id.btn_login)
    Button mRegister;
    @Bind(R.id.btn_login_captcha)
    Button mCaptcha;
    @Bind(R.id.iv_register_back)
    ImageView mBackLogin;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
    }

    @OnClick({R.id.btn_login, R.id.btn_login_captcha,R.id.iv_register_back})
    public void onClick(View btn) {
        switch (btn.getId()) {
            case R.id.btn_login:
                String user = mUsername.getText().toString();
                String pass = mPassword.getText().toString();
                mPresenter.startRegister(this, user, pass);
                break;
            case R.id.btn_login_captcha:
                String phoneNumber = mUsername.getText().toString();
                mPresenter.captcha(this,mCaptcha,phoneNumber);
                break;
            case R.id.iv_register_back:
                onBackPressed();
                break;
            default:
        }
    }

    @Override
    public void register() {
        ToastUtils.showLong(this, getResources().getText(R.string.registerSuccess));
        Intent intent = new Intent(this, EssentialInformationActivity.class);
        intent.putExtra(ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_STRING,
                ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_INT);
        startActivity(intent);
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
