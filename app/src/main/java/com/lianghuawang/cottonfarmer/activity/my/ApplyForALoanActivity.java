package com.lianghuawang.cottonfarmer.activity.my;

import android.view.View;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
//我的贷款---申请贷款
public class ApplyForALoanActivity extends BaseActivity implements View.OnClickListener {

    private ImageView applyforaloan_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_apply_for_aloan;
    }

    @Override
    protected void initView() {
        applyforaloan_return = (ImageView)findViewById(R.id.applyforaloan_return);
        applyforaloan_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
