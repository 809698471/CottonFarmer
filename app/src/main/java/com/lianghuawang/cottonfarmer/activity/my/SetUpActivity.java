package com.lianghuawang.cottonfarmer.activity.my;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.HelpActivity;
import com.lianghuawang.cottonfarmer.activity.PaymentPasswordSettingsActivity;
import com.lianghuawang.cottonfarmer.activity.ReceivingAddressActivity;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//我的设置
public class SetUpActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout set_up_receivingaddress;
    private LinearLayout set_up_paymentpasswordsettings;
    private LinearLayout set_up_help;
    private ImageView setup_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_up;
    }

    @Override
    protected void initView() {
        setup_return = (ImageView) findViewById(R.id.setup_return);
        //收货地址
        set_up_receivingaddress = (LinearLayout) findViewById(R.id.set_up_receivingaddress);
        //支付密码设置
        set_up_paymentpasswordsettings = (LinearLayout) findViewById(R.id.set_up_paymentpasswordsettings);
        //帮助
        set_up_help = (LinearLayout) findViewById(R.id.set_up_help);
        setup_return.setOnClickListener(this);
        set_up_receivingaddress.setOnClickListener(this);
        set_up_paymentpasswordsettings.setOnClickListener(this);
        set_up_help.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setup_return:
                finish();
                break;
            //收货地址
            case R.id.set_up_receivingaddress:
                startActivity(new Intent(SetUpActivity.this,ReceivingAddressActivity.class));
                break;
            //支付密码设置
            case R.id.set_up_paymentpasswordsettings:
                startActivity(new Intent(SetUpActivity.this,PaymentPasswordSettingsActivity.class));

                break;
            //帮助
            case R.id.set_up_help:
                startActivity(new Intent(SetUpActivity.this,HelpActivity.class));

                break;
        }
    }
}
