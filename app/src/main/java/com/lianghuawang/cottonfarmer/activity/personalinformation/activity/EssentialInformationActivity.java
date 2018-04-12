package com.lianghuawang.cottonfarmer.activity.personalinformation.activity;

import android.view.View;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//基本信息
public class EssentialInformationActivity extends BaseActivity implements View.OnClickListener {


    private ImageView essentialinformation_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_essential_information;
    }

    @Override
    protected void initView() {
        essentialinformation_return = (ImageView) findViewById(R.id.essentialinformation_return);
        essentialinformation_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
