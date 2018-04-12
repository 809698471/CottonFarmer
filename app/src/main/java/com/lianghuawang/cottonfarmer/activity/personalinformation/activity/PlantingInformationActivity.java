package com.lianghuawang.cottonfarmer.activity.personalinformation.activity;


import android.view.View;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//种植信息
public class PlantingInformationActivity extends BaseActivity implements View.OnClickListener {


    private ImageView plantinginformation_return;

    @Override
    protected int getLayoutId() {

        return R.layout.activity_planting_information;

    }

    @Override
    protected void initView() {
        plantinginformation_return = (ImageView)findViewById(R.id.plantinginformation_return);
        plantinginformation_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
