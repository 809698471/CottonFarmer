package com.lianghuawang.cottonfarmer.activity.mycredit;

import android.view.View;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//信用介绍
public class CreditIntroductionActivity extends BaseActivity implements View.OnClickListener {


    private ImageView creditintroduction_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_credit_introduction;
    }

    @Override
    protected void initView() {
        creditintroduction_return = (ImageView) findViewById(R.id.creditintroduction_return);
        creditintroduction_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
