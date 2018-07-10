package com.lianghuawang.cottonfarmer.activity.home.insurance;

import android.content.DialogInterface;
import android.content.Intent;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.my.mycredit.AuthenticationActivity;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.home.insurance.Is_identity;
import com.lianghuawang.cottonfarmer.entity.home.insurance.ParticularInsurance;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.DialogUtil;

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

    private String mInsuranceType;//保险类型
    private int mCate_id;//保险产品id

    private String Token;

    private String mInsurance_act;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_buy_insurance_particulars;
    }

    @Override
    protected void initView() {
        Token = getIntent().getStringExtra(ConstantUtil.INTENTTOKEN);
        judge();//检测是否可用购买保险
    }

    private void judge() {
        OkHttp3Utils.doGet(ConstantUtil.tokenKey, Token, Concat.INSURANCES_IS_IDENTITY_URL,
                new GsonObjectCallback<Is_identity>() {
                    @Override
                    public void onUi(Is_identity is_identity) {
                        if (is_identity.isSuccess()){
                            initAlate(is_identity.getData());
                        }
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {

                    }
                });
    }

    private void initAlate(Is_identity.DataBean data){
        switch (Integer.parseInt(data.getCode())){
            case 0:
                DialogUtil.VerifyDialog(InsuranceParticularsActivity.this,
                        "提示：", data.getErrmsg(), "现在认证", "稍后认证",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (which == ConstantUtil.POSITIVE){
                                    //跳转到身份证实名认证页面
                                    startActivity(new Intent(InsuranceParticularsActivity.this,
                                            AuthenticationActivity.class));
                                    InsuranceParticularsActivity.this.finish();
                                } if (which == ConstantUtil.NEGATIVE){
                                    InsuranceParticularsActivity.this.finish();
                                }
                            }
                        });
                break;
            case 1:
                init();
                break;
        }
    }

    private void init() {
        mInsuranceType = getIntent().getStringExtra(ConstantUtil.INSURANCE);
        mCate_id = getIntent().getIntExtra(ConstantUtil.INSURANCE_ID,0);
        String url = String.format(Concat.PRODUCTS_QUERY_URL,mInsuranceType,mCate_id);
        OkHttp3Utils.doGet(ConstantUtil.tokenKey, Token, url, new GsonObjectCallback<ParticularInsurance>() {
            @Override
            public void onUi(ParticularInsurance particularInsurance) {
                if (particularInsurance.isSuccess()){
                    initToolbar(particularInsurance.getData().getImage_url());
                    initData(particularInsurance.getData());
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }

    private void initToolbar(String image_url) {
        Glide.with(this).load(Concat.IMAGE_URL + image_url).into(mImage);
    }

    private void initData(ParticularInsurance.DataBean data) {
        mName.setText(data.getName());
        String Rates = String.format(getResources().getString(R.string.rates), data.getRate() + "‰");
        mRates.setText(Rates);
        String Central = String.format(getResources().getString(R.string.central), data.getN_tgt_fld1() + "%");
        mCentral.setText(Central);
        String Longtou = String.format(getResources().getString(R.string.longtou), data.getN_tgt_fld6() + "%");
        mLongtou.setText(Longtou);
        String Personal = String.format(getResources().getString(R.string.personal), data.getN_tgt_fld8() + "%");
        mPersonal.setText(Personal);
        String Sheng = String.format(getResources().getString(R.string.sheng), data.getN_tgt_fld2() + "%");
        mSheng.setText(Sheng);
        String Shi = String.format(getResources().getString(R.string.shi), data.getN_tgt_fld3() + "%");
        mShi.setText(Shi);
        String Xian = String.format(getResources().getString(R.string.xian), data.getN_tgt_fld4() + "%");
        mXian.setText(Xian);
        String Xiang = String.format(getResources().getString(R.string.xiang), data.getN_tgt_fld5() + "%");
        mXiang.setText(Xiang);
        String Qita = String.format(getResources().getString(R.string.qita), data.getN_tgt_fld7() + "%");
        mQita.setText(Qita);
//        String policy = String.format(getResources().getString(R.string.policy),data.getDescribe())
        mPolicy.setText("保单6个月");
        mMontent.loadDataWithBaseURL(null, data.getDescribe(), "text/html", "UTF-8", null);
        //保险对象
        String Object = String.format(getResources().getString(R.string.object), data.getStart_end_time());
        mObject.setText(Object);
        mRates1.setText(Rates);//费率
        //单位保额
        String Price = String.format(getResources().getString(R.string.price), data.getPrice());
        mPrice.setText(Price);
        //保险性质
        String Properties = String.format(getResources().getString(R.string.properties), data.getInsurance_nature());
        mProperties.setText(Properties);

        mContent.setText(data.getN_tgt_fld1() + "%");
        mPlace.setText(data.getN_tgt_fld2() + "%");
        mOther.setText(data.getN_tgt_fld7() + "%");
        mMyself.setText(data.getN_tgt_fld8() + "%");
        mInsurance_act = data.getProduct();
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
        Intent intent = new Intent(InsuranceParticularsActivity.this, InsuranceClausesActivity.class);
        intent.putExtra(ConstantUtil.INSURANCE_ACT, mInsurance_act);
        startActivity(intent);
    }

    //预约投保>>>>>保险订单
    @OnClick(R.id.btn_argeed)
    public void btnClick(Button button) {
        initData();
    }

    private void initData() {
                    Intent intent = new Intent(InsuranceParticularsActivity.this, InsuranceOrderActivity.class);
                    intent.putExtra("product_id", mInsuranceType);
                    intent.putExtra("cate_id", mCate_id+"");
                    intent.putExtra(ConstantUtil.INTENTTOKEN, Token);
                    startActivity(intent);
    }
}
