package com.lianghuawang.cottonfarmer.activity.my.personalinformation;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity.EssentialInformationActivity;
import com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity.InsurancePurchaseRecordActivity;
import com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity.PlantingInformationActivity;
import com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity.ProofOfOwnershipActivity;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//个人信息
public class PersonalInformationActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout personalinformation_personalimage;
    private LinearLayout personalinformation_essentialinformation;
    private LinearLayout personalinformation_plantinginformation;
    private LinearLayout personalinformation_proofofownership;
    private LinearLayout personalinformation_insurancepurchaserecord;
    private ImageView personalinformation_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_information;
    }

    @Override
    protected void initView() {
        personalinformation_return = (ImageView) findViewById(R.id.personalinformation_return);
        //个人头像
        personalinformation_personalimage = (LinearLayout) findViewById(R.id.personalinformation_personalimage);
        //基本信息
        personalinformation_essentialinformation = (LinearLayout) findViewById(R.id.personalinformation_essentialinformation);
        //种植信息
        personalinformation_plantinginformation = (LinearLayout) findViewById(R.id.personalinformation_plantinginformation);
        //权属证明
        personalinformation_proofofownership = (LinearLayout) findViewById(R.id.personalinformation_proofofownership);
        //保险购买记录
        personalinformation_insurancepurchaserecord = (LinearLayout) findViewById(R.id.personalinformation_insurancepurchaserecord);
        personalinformation_return.setOnClickListener(this);
        personalinformation_personalimage.setOnClickListener(this);
        personalinformation_essentialinformation.setOnClickListener(this);
        personalinformation_plantinginformation.setOnClickListener(this);
        personalinformation_proofofownership.setOnClickListener(this);
        personalinformation_insurancepurchaserecord.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.personalinformation_return:
                finish();
                break;
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