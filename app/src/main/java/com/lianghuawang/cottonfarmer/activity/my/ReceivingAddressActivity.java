package com.lianghuawang.cottonfarmer.activity.my;

import android.view.View;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//收货地址
public class ReceivingAddressActivity extends BaseActivity implements View.OnClickListener {


    private ImageView receivingaddress_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_receiving_address;
    }

    @Override
    protected void initView() {
        receivingaddress_return = (ImageView)findViewById(R.id.receivingaddress_return);
        receivingaddress_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
