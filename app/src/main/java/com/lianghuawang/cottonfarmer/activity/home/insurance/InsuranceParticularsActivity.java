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
    TextView mMontent;

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

    @Bind(R.id.tv_rates)
    TextView mRates;

    @Bind(R.id.tv_central)
    TextView mCentral;

    @Bind(R.id.tv_personal)
    TextView mPersonal;

    @Bind(R.id.tv_policy)
    TextView mPolicy;
    //保险对象
    @Bind(R.id.tv_object)
    TextView mObject;
    //保险费率
    @Bind(R.id.tv_rates1)
    TextView mRates1;
    //单位保金
    @Bind(R.id.tv_price)
    TextView mPrice;
    //保险性质
    @Bind(R.id.tv_properties)
    TextView mProperties;

    @Bind(R.id.tv_content)
    TextView mContent;

    @Bind(R.id.tv_place)
    TextView mPlace;

    @Bind(R.id.tv_other)
    TextView mOther;

    @Bind(R.id.tv_myself)
    TextView mMyself;

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
        String Rates = String.format(getResources().getString(R.string.rates), mData.getRate() + "%");
        mRates.setText(Rates);
        String Central = String.format(getResources().getString(R.string.central), mData.getN_tgt_fld1() + "%");
        mCentral.setText(Central);
        String Personal = String.format(getResources().getString(R.string.personal), mData.getN_tgt_fld8() + "%");
        mPersonal.setText(Personal);
//        String policy = String.format(getResources().getString(R.string.policy),mData.getDescribe())
        mPolicy.setText("保单6个月");
        mMontent.setText("      " + mData.getDescribe());
        //保险对象
        String Object = String.format(getResources().getString(R.string.object), mData.getIns_obj());
        mObject.setText(Object);
        mRates1.setText(Rates);//费率
        //单位保额
        String Price = String.format(getResources().getString(R.string.price), mData.getPrice());
        mPrice.setText(Price);
        //保险性质
        String Properties = String.format(getResources().getString(R.string.properties),mData.getInsurance_nature());
        mProperties.setText(Properties);

        mContent.setText(mData.getN_tgt_fld1() + "%");
        mPlace.setText(mData.getN_tgt_fld2() + "%");
        mOther.setText(mData.getN_tgt_fld7() + "%");
        mMyself.setText(mData.getN_tgt_fld8() + "%");
    }

    private void initToolbar() {
        Glide.with(this).load(mData.getImage_url()).into(mImage);
        mColl.setTitle(mData.getName());
        mColl.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.white));//在标题栏时的颜色
        mColl.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));//在图片上的颜色时

    }

    private void initData() {

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
        Intent intent = new Intent(this, InsuranceOrderActivity.class);
        intent.putExtra(ConstantUtil.INSURANCE,mData);
        startActivity(intent);
    }
}
