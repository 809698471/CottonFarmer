package com.lianghuawang.cottonfarmer.activity.personalinformation.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.my.mycredit.BankCardBindingActivity;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//保险购买记录
public class InsurancePurchaseRecordActivity extends BaseActivity implements View.OnClickListener {

    private ImageView insurancepurchaserecord_return;
    private Button insurancepurchaserecord_next;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_insurance_purchase_record;
    }

    @Override
    protected void initView() {
        insurancepurchaserecord_return = (ImageView) findViewById(R.id.insurancepurchaserecord_return);
        insurancepurchaserecord_next = (Button) findViewById(R.id.insurancepurchaserecord_next);
        insurancepurchaserecord_return.setOnClickListener(this);
        insurancepurchaserecord_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insurancepurchaserecord_return:
                finish();
                break;
            //下一步---绑定银行卡
            case R.id.insurancepurchaserecord_next:
                startActivity(new Intent(InsurancePurchaseRecordActivity.this, BankCardBindingActivity.class));
                break;
        }

    }
}
