package com.lianghuawang.cottonfarmer.activity.home;

import android.view.View;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//我要借款
public class IWantToBorrowMoneyActivity extends BaseActivity {


    private ImageView iwanttoborrowmoney_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_iwant_to_borrow_money;
    }

    @Override
    protected void initView() {
        iwanttoborrowmoney_return = (ImageView) findViewById(R.id.iwanttoborrowmoney_return);
        iwanttoborrowmoney_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
