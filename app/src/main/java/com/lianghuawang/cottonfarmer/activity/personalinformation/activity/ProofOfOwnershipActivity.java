package com.lianghuawang.cottonfarmer.activity.personalinformation.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//权属证明
public class ProofOfOwnershipActivity extends BaseActivity implements View.OnClickListener {


    private ImageView proofofownership_return;
    private Button proofofownership_next;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_proof_of_ownership;
    }

    @Override
    protected void initView() {
        proofofownership_return = (ImageView) findViewById(R.id.proofofownership_return);
        proofofownership_next = (Button) findViewById(R.id.proofofownership_next);
        proofofownership_return.setOnClickListener(this);
        proofofownership_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.proofofownership_return:
                finish();
                break;
            //下一步---购买保险记录
            case R.id.proofofownership_next:
                startActivity(new Intent(ProofOfOwnershipActivity.this,InsurancePurchaseRecordActivity.class ));
                break;
        }

    }
}
