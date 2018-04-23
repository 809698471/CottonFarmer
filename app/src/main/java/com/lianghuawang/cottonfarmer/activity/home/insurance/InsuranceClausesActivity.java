package com.lianghuawang.cottonfarmer.activity.home.insurance;

import android.view.View;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//保险条款
public class InsuranceClausesActivity extends BaseActivity {


    private ImageView insuranceclauses_return;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_insurance_clauses;
    }

    @Override
    protected void initView() {
        insuranceclauses_return = (ImageView) findViewById(R.id.insuranceclauses_return);
        insuranceclauses_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
