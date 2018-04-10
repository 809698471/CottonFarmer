package com.lianghuawang.cottonfarmer.module.personalinformation;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.module.personalinformation.activity.EssentialInformationActivity;
import com.lianghuawang.cottonfarmer.module.personalinformation.activity.InsurancePurchaseRecordActivity;
import com.lianghuawang.cottonfarmer.module.personalinformation.activity.PlantingInformationActivity;
import com.lianghuawang.cottonfarmer.module.personalinformation.activity.ProofOfOwnershipActivity;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//个人信息
public class PersonalInformationActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout personalinformation_personalimage;
    private LinearLayout personalinformation_essentialinformation;
    private LinearLayout personalinformation_plantinginformation;
    private LinearLayout personalinformation_proofofownership;
    private LinearLayout personalinformation_insurancepurchaserecord;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_information;
    }

    @Override
    protected void initView() {
        personalinformation_personalimage = (LinearLayout) findViewById(R.id.personalinformation_personalimage);
        personalinformation_essentialinformation = (LinearLayout) findViewById(R.id.personalinformation_essentialinformation);
        personalinformation_plantinginformation = (LinearLayout) findViewById(R.id.personalinformation_plantinginformation);
        personalinformation_proofofownership = (LinearLayout) findViewById(R.id.personalinformation_proofofownership);
        personalinformation_insurancepurchaserecord = (LinearLayout) findViewById(R.id.personalinformation_insurancepurchaserecord);

        personalinformation_personalimage.setOnClickListener(this);
        personalinformation_essentialinformation.setOnClickListener(this);
        personalinformation_plantinginformation.setOnClickListener(this);
        personalinformation_proofofownership.setOnClickListener(this);
        personalinformation_insurancepurchaserecord.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //个人头像
            case R.id.personalinformation_personalimage:
                break;
            //基本信息
            case R.id.personalinformation_essentialinformation:
                startActivity(new Intent(PersonalInformationActivity.this, EssentialInformationActivity.class));
                break;
            //种植信息
            case R.id.personalinformation_plantinginformation:
                startActivity(new Intent(PersonalInformationActivity.this, PlantingInformationActivity.class));

                break;
            //权属证明
            case R.id.personalinformation_proofofownership:
                startActivity(new Intent(PersonalInformationActivity.this, ProofOfOwnershipActivity.class));

                break;
            //保险购买记录
            case R.id.personalinformation_insurancepurchaserecord:
                startActivity(new Intent(PersonalInformationActivity.this, InsurancePurchaseRecordActivity.class));

                break;
        }
    }
}
