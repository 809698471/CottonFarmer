package com.lianghuawang.cottonfarmer.activity.my.personalinformation;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.personalinformation.SubmitACaseForSubmissionActivity;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//保单详情
public class DetailsOfPolicyActivity extends BaseActivity {


    private ImageView detailsofpolicy_return;
    private Button detailsofpolicy_btn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details_of_policy;
    }

    @Override
    protected void initView() {
        detailsofpolicy_return = (ImageView) findViewById(R.id.detailsofpolicy_return);
        detailsofpolicy_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        detailsofpolicy_btn = (Button) findViewById(R.id.detailsofpolicy_btn);
        //报案理赔
        detailsofpolicy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailsOfPolicyActivity.this, SubmitACaseForSubmissionActivity.class));
            }
        });
    }
}
