package com.lianghuawang.cottonfarmer.activity.personalinformation.activity;

import android.view.View;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//保险购买记录
public class InsurancePurchaseRecordActivity extends BaseActivity implements View.OnClickListener {

    private ImageView insurancepurchaserecord_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_insurance_purchase_record;
    }

    @Override
    protected void initView() {
        insurancepurchaserecord_return = (ImageView) findViewById(R.id.insurancepurchaserecord_return);
        insurancepurchaserecord_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
