package com.lianghuawang.cottonfarmer.activity.my;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.fragment.ClaimQueryFragment;
import com.lianghuawang.cottonfarmer.fragment.ReportsFragment;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//报案理赔
public class ClaimCompensationActivity extends BaseActivity implements View.OnClickListener {

    private FrameLayout claim_fragment;
    private RadioButton claim_rb_01;
    private RadioButton claim_rb_02;

    private ClaimQueryFragment claimQueryFragment;
    private ReportsFragment reportsFragment;
    private ImageView claimcompensation_return;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_claim_compensation;
    }

    @Override
    protected void initView() {
        claimcompensation_return = (ImageView) findViewById(R.id.claimcompensation_return);
        claim_fragment = (FrameLayout) findViewById(R.id.claim_fragment);
        claim_rb_01 = (RadioButton) findViewById(R.id.claim_rb_01);
        claim_rb_02 = (RadioButton) findViewById(R.id.claim_rb_02);


        claim_rb_01.setOnClickListener(this);
        claim_rb_02.setOnClickListener(this);
        claimcompensation_return.setOnClickListener(this);
        //动态添加Fragment ,获取Fragment 管理器
        FragmentManager msg = getSupportFragmentManager();
        //开启Fragment事物
        FragmentTransaction transaction = msg.beginTransaction();
        //方法2隐藏所有的Fragment。
        hideAll(transaction);
        if (reportsFragment == null) {
            reportsFragment = new ReportsFragment();
            transaction.add(R.id.claim_fragment, reportsFragment);

        } else {
            transaction.show(reportsFragment);
        }
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        //动态添加Fragment ,获取Fragment 管理器
        FragmentManager msg = getSupportFragmentManager();
        //开启Fragment事物
        FragmentTransaction transaction = msg.beginTransaction();
        //方法2隐藏所有的Fragment。
        hideAll(transaction);
        switch (v.getId()) {
            //报案
            case R.id.claim_rb_01:
                if (reportsFragment == null) {
                    ReportsFragment reportsFragment = new ReportsFragment();
                    transaction.add(R.id.claim_fragment, reportsFragment);

                } else {
                    transaction.show(reportsFragment);
                }
                break;
            case R.id.claim_rb_02:
                //理赔查询
                if (claimQueryFragment == null) {
                    claimQueryFragment = new ClaimQueryFragment();
                    transaction.add(R.id.claim_fragment, claimQueryFragment);

                } else {
                    transaction.show(claimQueryFragment);
                }
                break;
            case R.id.claimcompensation_return:
                finish();
                break;
        }
        transaction.commit();
    }

    private void hideAll(FragmentTransaction transaction) {
        if (reportsFragment != null) {
            transaction.hide(reportsFragment);
        }
        if (claimQueryFragment != null) {
            transaction.hide(claimQueryFragment);
        }
    }
}
