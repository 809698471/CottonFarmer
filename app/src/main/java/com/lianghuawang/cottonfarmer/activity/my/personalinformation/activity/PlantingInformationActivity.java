package com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity;


import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.my.personalinformation.MassifInformationListActivity;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//种植信息
public class PlantingInformationActivity extends BaseActivity implements View.OnClickListener {


    private ImageView plantinginformation_return;
    private Button plantinginformation_next;
    private EditText edit_shuliang;

    @Override
    protected int getLayoutId() {

        return R.layout.activity_planting_information;

    }

    @Override
    protected void initView() {
        plantinginformation_return = (ImageView) findViewById(R.id.plantinginformation_return);
        plantinginformation_next = (Button) findViewById(R.id.plantinginformation_next);
        edit_shuliang = (EditText) findViewById(R.id.edit_shuliang);

        plantinginformation_return.setOnClickListener(this);
        edit_shuliang.setOnClickListener(this);
        plantinginformation_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plantinginformation_return:
                finish();
                break;
            //地块信息列表
            case R.id.edit_shuliang:
                //隐藏软键盘
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                startActivity(new Intent(PlantingInformationActivity.this, MassifInformationListActivity.class));
                break;

            //下一步---权属证明
            case R.id.plantinginformation_next:
                startActivity(new Intent(PlantingInformationActivity.this, ProofOfOwnershipActivity.class));
                break;

        }

    }
}
