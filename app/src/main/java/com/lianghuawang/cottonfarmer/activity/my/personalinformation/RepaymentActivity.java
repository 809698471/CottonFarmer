package com.lianghuawang.cottonfarmer.activity.my.personalinformation;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//还款
public class RepaymentActivity extends BaseActivity implements View.OnClickListener {

    private ImageView repayment_return;
    private RelativeLayout repayment_stagingDetail;
    private RelativeLayout repayment_earlyRepayment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_repayment;
    }

    @Override
    protected void initView() {
        repayment_return = (ImageView) findViewById(R.id.repayment_return);
        repayment_stagingDetail = (RelativeLayout) findViewById(R.id.repayment_stagingDetail);
        repayment_earlyRepayment = (RelativeLayout) findViewById(R.id.repayment_earlyRepayment);

        repayment_return.setOnClickListener(this);
        repayment_stagingDetail.setOnClickListener(this);
        repayment_earlyRepayment.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.repayment_return:
                finish();
                break;
            //分期明细
            case R.id.repayment_stagingDetail:
                startActivity(new Intent(RepaymentActivity.this, StagingDetailActivity.class));
                break;
            //提前还款
            case R.id.repayment_earlyRepayment:
                startActivity(new Intent(RepaymentActivity.this, EarlyRepaymentActivity.class));

                break;
        }
    }
}
