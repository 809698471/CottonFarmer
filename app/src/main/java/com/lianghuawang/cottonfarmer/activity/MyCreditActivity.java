package com.lianghuawang.cottonfarmer.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.mycredit.CreditIntroductionActivity;
import com.lianghuawang.cottonfarmer.activity.mycredit.PromotionOfCreditActivity;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//我的信用
public class MyCreditActivity extends BaseActivity implements View.OnClickListener {


    private TextView my_credit_tv;
    private Button my_credit_btn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_credit;
    }

    @Override
    protected void initView() {
        my_credit_tv = (TextView) findViewById(R.id.my_credit_tv);
        my_credit_btn = (Button) findViewById(R.id.my_credit_btn);

        my_credit_tv.setOnClickListener(this);
        my_credit_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_credit_tv:
                //信用介绍
                startActivity(new Intent(MyCreditActivity.this, CreditIntroductionActivity.class));
                break;
            case R.id.my_credit_btn:
                //提升信用
                startActivity(new Intent(MyCreditActivity.this,PromotionOfCreditActivity.class));
                break;
        }

    }
}
