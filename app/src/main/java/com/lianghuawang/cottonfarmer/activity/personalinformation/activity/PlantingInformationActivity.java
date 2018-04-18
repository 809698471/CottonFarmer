package com.lianghuawang.cottonfarmer.activity.personalinformation.activity;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//种植信息
public class PlantingInformationActivity extends BaseActivity implements View.OnClickListener {


    private ImageView plantinginformation_return;
    private Button plantinginformation_next;

    @Override
    protected int getLayoutId() {

        return R.layout.activity_planting_information;

    }

    @Override
    protected void initView() {
        plantinginformation_return = (ImageView) findViewById(R.id.plantinginformation_return);
        plantinginformation_next = (Button) findViewById(R.id.plantinginformation_next);
        plantinginformation_return.setOnClickListener(this);
        plantinginformation_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plantinginformation_return:
                finish();
                break;
            //下一步---权属证明
            case R.id.plantinginformation_next:
                startActivity(new Intent(PlantingInformationActivity.this, ProofOfOwnershipActivity.class));
                break;

        }

    }
}
