package com.lianghuawang.cottonfarmer.activity.personalinformation;

import android.view.View;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//报案提交
public class SubmitACaseForSubmissionActivity extends BaseActivity {


    private ImageView submitacase_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_submit_acase_for_submission;
    }

    @Override
    protected void initView() {
        submitacase_return = (ImageView) findViewById(R.id.submitacase_return);
        submitacase_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
