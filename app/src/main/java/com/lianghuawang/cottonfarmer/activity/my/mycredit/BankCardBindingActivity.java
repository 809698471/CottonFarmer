package com.lianghuawang.cottonfarmer.activity.my.mycredit;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//银行卡绑定
public class BankCardBindingActivity extends BaseActivity implements View.OnClickListener {


    private Button bankcardbinding_btn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bank_card_binding;
    }

    @Override
    protected void initView() {
        bankcardbinding_btn = (Button) findViewById(R.id.bankcardbinding_btn);

        bankcardbinding_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //去绑定
            case R.id.bankcardbinding_btn:
                startActivity(new Intent(BankCardBindingActivity.this,BankCardSMSVerification.class));
                break;
        }
    }
}
