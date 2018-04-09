package com.lianghuawang.cottonfarmer.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//我的信用
public class MyCreditActivity extends BaseActivity implements View.OnClickListener {


    private TextView my_credit_tv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_credit;
    }

    @Override
    protected void initView() {
        my_credit_tv = (TextView) findViewById(R.id.my_credit_tv);
        my_credit_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //信用介绍
        startActivity(new Intent(MyCreditActivity.this,CreditIntroductionActivity.class));
    }
}
