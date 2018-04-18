package com.lianghuawang.cottonfarmer.activity.personalinformation.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//基本信息
public class EssentialInformationActivity extends BaseActivity implements View.OnClickListener {


    private ImageView essentialinformation_return;
    private Button essentialinformation_next;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_essential_information;
    }

    @Override
    protected void initView() {
        essentialinformation_return = (ImageView) findViewById(R.id.essentialinformation_return);
        essentialinformation_next = (Button) findViewById(R.id.essentialinformation_next);
        essentialinformation_return.setOnClickListener(this);
        essentialinformation_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.essentialinformation_return:
                finish();
                break;
            //下一步---种植信息
            case R.id.essentialinformation_next:
                startActivity(new Intent(EssentialInformationActivity.this, PlantingInformationActivity.class));
                break;
        }
    }
}
