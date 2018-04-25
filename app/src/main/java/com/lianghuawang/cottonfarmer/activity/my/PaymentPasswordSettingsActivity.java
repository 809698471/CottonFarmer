package com.lianghuawang.cottonfarmer.activity.my;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.tools.CustomerCodeView;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//支付密码设置
public class PaymentPasswordSettingsActivity extends BaseActivity implements CustomerCodeView.InputCompleteListener, View.OnClickListener {

    private CustomerCodeView editText;
    private ImageView paymentpasswordsettings_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_payment_password_settings;
    }

    @Override
    protected void initView() {
        paymentpasswordsettings_return = (ImageView)findViewById(R.id.paymentpasswordsettings_return);
        editText = (CustomerCodeView) findViewById(R.id.edit_code);
        paymentpasswordsettings_return.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        finish();
    }
}
