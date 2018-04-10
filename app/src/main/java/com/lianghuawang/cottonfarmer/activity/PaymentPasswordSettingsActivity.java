package com.lianghuawang.cottonfarmer.activity;

import android.widget.Toast;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.tools.CustomerCodeView;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//支付密码设置
public class PaymentPasswordSettingsActivity extends BaseActivity implements CustomerCodeView.InputCompleteListener {

    private CustomerCodeView editText;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_payment_password_settings;
    }

    @Override
    protected void initView() {
        editText = (CustomerCodeView) findViewById(R.id.edit_code);
        editText.setInputCompleteListener(this);
    }

    @Override
    public void inputComplete() {
        if (!editText.getEditContent().equals("123456")) {
            Toast.makeText(getApplicationContext(), "验证码失败", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void deleteContent(boolean isDelete) {

    }
}
