package com.lianghuawang.cottonfarmer.activity.home.insurance;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.home.insurance.ConfirmOrder;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.netutils.instance.AgriculturalInsurances.DataBean;

import java.io.IOException;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;

//保险三级页面---保险详情
public class InsuranceParticularsActivity extends BaseActivity {

    @Bind(R.id.tv_name)
    TextView mName;

    @Bind(R.id.tv_ins_par_content)
    WebView mMontent;

    @Bind(R.id.cb_argeed)
    CheckBox mCheck;

    @Bind(R.id.tv_argeed)
    TextView mTextView;

    @Bind(R.id.btn_argeed)
    Button mArgeed;

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

    @Bind(R.id.tv_longtou)
    TextView mLongtou;

    @Bind(R.id.tv_sheng)
    TextView mSheng;

    @Bind(R.id.tv_shi)
    TextView mShi;

    @Bind(R.id.tv_xian)
    TextView mXian;

    @Bind(R.id.tv_xiang)
    TextView mXiang;

    @Bind(R.id.tv_qita)
    TextView mQita;

    private DataBean mData;

    private String Token;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_buy_insurance_particulars;
    }

    @Override
    protected void initView() {
        Token = getIntent().getStringExtra(ConstantUtil.INTENTTOKEN);
        init();
        initToolbar();
        initData();
    }

    private void init() {
        mData = (DataBean) getIntent().getSerializableExtra(ConstantUtil.INSURANCE);
        LogUtils.d(mData.toString());
        mName.setText(mData.getName());
        String Rates = String.format(getResources().getString(R.string.rates), mData.getRate() + "‰");
        mRates.setText(Rates);
        String Central = String.format(getResources().getString(R.string.central), mData.getN_tgt_fld1() + "%");
        mCentral.setText(Central);
        String Longtou = String.format(getResources().getString(R.string.longtou), mData.getN_tgt_fld6() + "%");
        mLongtou.setText(Longtou);
        String Personal = String.format(getResources().getString(R.string.personal), mData.getN_tgt_fld8() + "%");
        mPersonal.setText(Personal);
        String Sheng = String.format(getResources().getString(R.string.sheng), mData.getN_tgt_fld2() + "%");
        mSheng.setText(Sheng);
        String Shi = String.format(getResources().getString(R.string.shi), mData.getN_tgt_fld3() + "%");
        mShi.setText(Shi);
        String Xian = String.format(getResources().getString(R.string.xian), mData.getN_tgt_fld4() + "%");
        mXian.setText(Xian);
        String Xiang = String.format(getResources().getString(R.string.xiang), mData.getN_tgt_fld5() + "%");
        mXiang.setText(Xiang);
        String Qita = String.format(getResources().getString(R.string.qita), mData.getN_tgt_fld7() + "%");
        mQita.setText(Qita);
//        String policy = String.format(getResources().getString(R.string.policy),mData.getDescribe())
        mPolicy.setText("保单6个月");
        mMontent.loadDataWithBaseURL(null,mData.getDescribe(),"text/html", "UTF-8",null);
        //保险对象
        String Object = String.format(getResources().getString(R.string.object), mData.getStart_end_time());
        mObject.setText(Object);
        mRates1.setText(Rates);//费率
        //单位保额
        String Price = String.format(getResources().getString(R.string.price), mData.getPrice());
        mPrice.setText(Price);
        //保险性质
        String Properties = String.format(getResources().getString(R.string.properties), mData.getInsurance_nature());
        mProperties.setText(Properties);

        mContent.setText(mData.getN_tgt_fld1() + "%");
        mPlace.setText(mData.getN_tgt_fld2() + "%");
        mOther.setText(mData.getN_tgt_fld7() + "%");
        mMyself.setText(mData.getN_tgt_fld8() + "%");
    }

    private void initToolbar() {
        Glide.with(this).load(mData.getImage_url()).into(mImage);
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
        initData(mData.getProduct_id(),mData.getCate_id().getCate_id() + "");
    }

    private void initData(String product_id, String cate_id) {
        showLoadingDialog(this);
        String url = String.format(Concat.CONFIRMORDER_URL, product_id, cate_id);
        OkHttp3Utils.doGet(ConstantUtil.tokenKey, Token, url, new GsonObjectCallback<ConfirmOrder>() {
            @Override
            public void onUi(ConfirmOrder confirmOrder) {
                if (confirmOrder.isSuccess()) {
                    Intent intent = new Intent(InsuranceParticularsActivity.this, InsuranceOrderActivity.class);
                    intent.putExtra("product_id", mData.getProduct_id());
                    intent.putExtra("cate_id", mData.getCate_id().getCate_id() + "");
                    intent.putExtra(ConstantUtil.INTENTTOKEN, Token);
                    startActivity(intent);
                    dismissdingDialog();
                } else {
                    ToastUtils.showLong(InsuranceParticularsActivity.this, confirmOrder.getData().getErrmsg());
                    dismissdingDialog();
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {
                ToastUtils.showLong(InsuranceParticularsActivity.this, ConstantUtil.NETERROR);
            }
        });
    }
}
