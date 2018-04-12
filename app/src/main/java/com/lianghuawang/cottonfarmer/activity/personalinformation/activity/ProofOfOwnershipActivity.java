package com.lianghuawang.cottonfarmer.activity.personalinformation.activity;

import android.view.View;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//权属证明
public class ProofOfOwnershipActivity extends BaseActivity implements View.OnClickListener {


    private ImageView proofofownership_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_proof_of_ownership;
    }

    @Override
    protected void initView() {
        proofofownership_return = (ImageView) findViewById(R.id.proofofownership_return);
        proofofownership_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
