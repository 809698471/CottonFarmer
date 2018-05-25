package com.lianghuawang.cottonfarmer.activity.home.insurance;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.netutils.instance.AgriculturalInsurances.DataBean;

import butterknife.Bind;
import butterknife.OnClick;

//购买保险---棉花灾害险详情页面
public class InsuranceParticularsActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.tv_ins_par_content)
    TextView content;

    @Bind(R.id.cb_argeed)
    CheckBox mCheck;

    @Bind(R.id.tv_argeed)
    TextView mTextView;

    @Bind(R.id.btn_argeed)
    Button mArgeed;

    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout mColl;

    @Bind(R.id.iv_item_insurance)
    ImageView mImage;

    private DataBean mData;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_buy_insurance_particulars;
    }

    @Override
    protected void initView() {
        init();
        initToolbar();
        initData();
    }

    private void init() {
        mData = (DataBean) getIntent().getSerializableExtra(ConstantUtil.INSURANCE);
        LogUtils.d(mData.toString());
    }

    private void initToolbar() {
        Glide.with(this).load("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2153457880,777912658&fm=27&gp=0.jpg").into(mImage);
        mColl.setTitle(mData.getName());
        mColl.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.white));//在标题栏时的颜色
        mColl.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));//在图片上的颜色时

    }

    private void initData() {
        content.setText(ConstantUtil.TEST);
    }

    @OnClick(R.id.cb_argeed)
    public void click(CheckBox checkBox) {
        if (checkBox.isChecked()) {
            mArgeed.setEnabled(true);
        } else {
            mArgeed.setEnabled(false);
        }
    }

    //保单条款
    @OnClick(R.id.tv_argeed)
    public void tvClick(TextView textView) {
        startActivity(new Intent(InsuranceParticularsActivity.this, InsuranceClausesActivity.class));
    }

    //预约投保>>>>>保险订单
    @OnClick(R.id.btn_argeed)
    public void btnClick(Button button) {
        startActivity(new Intent(this, InsuranceOrderActivity.class));
    }
}
