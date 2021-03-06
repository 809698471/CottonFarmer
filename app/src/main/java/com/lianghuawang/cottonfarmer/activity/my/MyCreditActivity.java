package com.lianghuawang.cottonfarmer.activity.my;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.my.mycredit.CreditIntroductionActivity;
import com.lianghuawang.cottonfarmer.activity.my.mycredit.PromotionOfCreditActivity;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//我的信用
public class MyCreditActivity extends BaseActivity implements View.OnClickListener {


    private TextView my_credit_tv;
    private Button my_credit_btn;
    private ImageView mycredit_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_credit;
    }

    @Override
    protected void initView() {
        my_credit_tv = (TextView) findViewById(R.id.my_credit_tv);
        my_credit_btn = (Button) findViewById(R.id.my_credit_btn);
        mycredit_return = (ImageView) findViewById(R.id.mycredit_return);
        my_credit_tv.setOnClickListener(this);
        my_credit_btn.setOnClickListener(this);
        mycredit_return.setOnClickListener(this);
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
            case R.id.mycredit_return:
                finish();
                break;
        }

    }
}
