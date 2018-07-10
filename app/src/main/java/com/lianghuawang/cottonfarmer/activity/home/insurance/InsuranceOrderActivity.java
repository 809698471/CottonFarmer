package com.lianghuawang.cottonfarmer.activity.home.insurance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.HomePageActivity;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.home.insurance.ConfirmOrder;
import com.lianghuawang.cottonfarmer.entity.home.insurance.FenGongSi;
import com.lianghuawang.cottonfarmer.entity.home.insurance.FenJiGou;
import com.lianghuawang.cottonfarmer.entity.home.insurance.PayEntity;
import com.lianghuawang.cottonfarmer.entity.home.insurance.Sheng;
import com.lianghuawang.cottonfarmer.entity.home.insurance.toubao;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.netutils.instance.AgriculturalInsurances.DataBean;
import com.lianghuawang.cottonfarmer.tools.MessageEvent;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.widget.linkage_menu.AddressSelector;
import com.lianghuawang.cottonfarmer.widget.linkage_menu.CityInterface;
import com.lianghuawang.cottonfarmer.widget.linkage_menu.OnClickDisappearListener;
import com.lianghuawang.cottonfarmer.widget.linkage_menu.OnItemAddressClickListener;
import com.lianghuawang.cottonfarmer.widget.pay.PayDialog;
import com.lianghuawang.cottonfarmer.widget.pay.PayDialog2;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

//确认保险订单
public class InsuranceOrderActivity extends BaseActivity implements OnClickDisappearListener, OnItemAddressClickListener, AddressSelector.OnTabSelectedListener, PayDialog2.DimssLienter, PayDialog2.PayLienter {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.btn_confirm_order)
    Button mOrder;
    @Bind(R.id.tv_name)
    TextView mName;//投保人
    @Bind(R.id.tv_id_card)
    TextView mIdCard;//身份证
    @Bind(R.id.tv_name1)
    TextView mName1;//投保人
    @Bind(R.id.tv_id_card1)
    TextView mIdCard1;//身份证
    @Bind(R.id.tv_address)
    TextView mAddress;//身份证
    @Bind(R.id.tv_plant_address)
    TextView mPlantAddress;//种植地址
    @Bind(R.id.tv_deadline)
    TextView mDeadline;//保险期限
    @Bind(R.id.tv_appoint)
    TextView mAppoint;//特别约定
    @Bind(R.id.tv_amount)
    TextView mAmount;//保险金额
    @Bind(R.id.tv_premium)
    TextView mPremium;//保费
    @Bind(R.id.tv_fiscal)
    TextView mFiscal;//中央财政
    @Bind(R.id.tv_farmers)
    TextView mFarmers;//农户承担
    @Bind(R.id.tv_pay)
    TextView mPay;
    @Bind(R.id.tv_pay1)
    TextView mPay1;
    @Bind(R.id.tv_jigou)
    TextView mJigou;
    @Bind(R.id.tv_insurance_verfiy_area)
    TextView mTableArea;//投保面积
    @Bind(R.id.tv_insurance_verfiy_price)
    TextView mTablePrice;//单位保额
    @Bind(R.id.tv_insurance_verfiy_insurance_amount)
    TextView mTableAmount;//保险金额
    @Bind(R.id.tv_insurance_verfiy_rate)
    TextView mTableRate;//费率
    @Bind(R.id.tv_insurance_verfiy_premium)
    TextView mTablePremium;//保费


    private final int RESULT = 1;
    private final int RESULTCODE = 2;
    private DataBean mData;

    private String cate_id;
    private String product_id;
    private String Token;
    private ConfirmOrder.DataBean dataBeans;
    private AlertDialog dialog;
    private AddressSelector selector;
    private List<Sheng.DataBean> list1;
    private List<FenGongSi.DataBean> list2;
    private List<FenJiGou.DataBean> list3;
    private String name = "";
    private String o_water;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_insurance_order;
    }

    @Override
    protected void initView() {
        init();
        initData();
        initToolbar();
    }

    private void init() {
        product_id = getIntent().getStringExtra("product_id");
        cate_id = getIntent().getStringExtra("cate_id");
        Token = getIntent().getStringExtra(ConstantUtil.INTENTTOKEN);
    }

    private void initData() {
        showLoadingDialog(this);
        String url = String.format(Concat.CONFIRMORDER_URL, product_id, cate_id);
        OkHttp3Utils.doGet(ConstantUtil.tokenKey, Token, url, new GsonObjectCallback<ConfirmOrder>() {
            @Override
            public void onUi(ConfirmOrder confirmOrder) {
                if (confirmOrder.isSuccess()) {
                    dataBeans = confirmOrder.getData();
                    showView();
                    dismissdingDialog();
                } else {
                    dismissdingDialog();
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {
                ToastUtils.showLong(InsuranceOrderActivity.this, ConstantUtil.NETERROR);
            }
        });
    }

    private void initToolbar() {
        mToolbar.setTitle("确认订单");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.back1);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void showView() {
        mName.setText(dataBeans.getUsername());
        mIdCard.setText(dataBeans.getId_code());
        mName1.setText(dataBeans.getUsername());
        mIdCard1.setText(dataBeans.getId_code());
        mAddress.setText(dataBeans.getAddress());
        mPlantAddress.setText(dataBeans.getPlant_area());
        String time1 = dataBeans.getDead_start_time().split(" ")[0];
        String[] time11 = time1.split("-");
        String time2 = dataBeans.getDead_end_time().split(" ")[0];
        String[] time22 = time2.split("-");
        mDeadline.setText(time11[0] + "." + time11[1] + "." + time11[2] + "-" + time22[0] + "." + time22[1] + "." + time22[2]);
        mAppoint.setText(dataBeans.getSpecial_agreement());

        mAmount.setText("￥" + dataBeans.getInsurance_amount());
        mPremium.setText("￥" + dataBeans.getPremium());
        mFiscal.setText("￥" + dataBeans.getN_tgt_fld1());
        mFarmers.setText("￥" + dataBeans.getN_tgt_fld8());
        mPay.setText("￥" + dataBeans.getPay_num());
        mPay1.setText("￥" + dataBeans.getPay_num());
        mTableArea.setText(dataBeans.getCotton_area());
        mTablePrice.setText(dataBeans.getPrice());
        mTableAmount.setText(dataBeans.getInsurance_amount() + "");
        mTableRate.setText(dataBeans.getRate() + "");
        mTablePremium.setText(dataBeans.getPremium() + "");
    }

    @OnClick(R.id.btn_confirm_order)
    public void confirm(Button btn) {
        if (mechanism != null) {
            OkHttp3Utils.doPost(ConstantUtil.tokenKey, Token, Concat.YUYUEBAOXIAN_URL, getParams(), new GsonObjectCallback<toubao>() {
                @Override
                public void onUi(toubao toubao) {
                    if (toubao.isSuccess()) {
                        o_water = toubao.getData().getO_water();
                        Intent intent = new Intent(InsuranceOrderActivity.this, SignatureActivity.class);
                        intent.putExtra("o_water", toubao.getData().getO_water());
                        intent.putExtra(ConstantUtil.INTENTTOKEN, Token);
                        startActivityForResult(intent, RESULT);
                    } else {
                        ToastUtils.showLong(InsuranceOrderActivity.this, toubao.getData().getErrmsg());
                    }
                }

                @Override
                public void onFailed(Call call, IOException e) {
                    ToastUtils.showLong(InsuranceOrderActivity.this,ConstantUtil.NETERROR);
                }
            });
        } else {
            ToastUtils.showLong(this, "请选择投保机构");
        }
    }

    @OnClick(R.id.tv_jigou)
    public void jigou(TextView view) {
        dialog();
    }

    private void dialog() {
        dialog = new AlertDialog.Builder(this).create();
        View view = View.inflate(this, R.layout.jigoudialog, null);
        selector = view.findViewById(R.id.address_jigou);
        dialog_address(selector);
        dialog.setView(view);
        dialog.setCancelable(false);
        dialog.show();
    }

    private void dialog_address(final AddressSelector selector) {
        showLoadingDialog(this);
        OkHttp3Utils.doGet(ConstantUtil.tokenKey, Token, Concat.SHENGJIGOU, new GsonObjectCallback<Sheng>() {
            @Override
            public void onUi(Sheng sheng) {
                list1 = sheng.getData();
                selector.setCities((ArrayList) list1, 3, true, InsuranceOrderActivity.this);
                selector.setDisapperListener(InsuranceOrderActivity.this);
                selector.setOnItemClickListener(InsuranceOrderActivity.this);
                selector.setOnTabSelectedListener(InsuranceOrderActivity.this);
                dismissdingDialog();
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }

    private void dialog_fengongsi() {
        OkHttp3Utils.doGet(ConstantUtil.tokenKey, Token, Concat.FENJIGOU, new GsonObjectCallback<FenGongSi>() {
            @Override
            public void onUi(FenGongSi fenJiGou) {
                list2 = fenJiGou.getData();
                selector.setCities((ArrayList) list2, 3, false, InsuranceOrderActivity.this);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }

    private void dialog_jigou(String name) {
        String url = Concat.JIGOU + name;
        OkHttp3Utils.doGet(ConstantUtil.tokenKey, Token, url, new GsonObjectCallback<FenJiGou>() {
            @Override
            public void onUi(FenJiGou fenJiGou) {
                list3 = fenJiGou.getData();
                selector.setCities((ArrayList) list3, 3, false, InsuranceOrderActivity.this);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }

    @Override
    public void onclick() {
        dialog.dismiss();
    }

    private String mechanism;

    @Override
    public void itemClick(AddressSelector addressSelector, CityInterface city, int tabPosition) {
        if (tabPosition == 0) {
            dialog_fengongsi();
            name = name + city.getCityName();
        } else if (tabPosition == 1) {
            dialog_jigou(city.getCityName());
            name = name + city.getCityName();
        } else if (tabPosition == 2) {
            name = name + city.getCityName();
            dialog.dismiss();
            mJigou.setText(name);
            mechanism = city.getArea_code();
        }
    }

    @Override
    public void onTabSelected(AddressSelector addressSelector, AddressSelector.Tab tab) {

    }

    @Override
    public void onTabReselected(AddressSelector addressSelector, AddressSelector.Tab tab) {

    }

    private Map<String, String> getParams() {
        Map<String, String> params = new HashMap<>();
        params.put("product_id", product_id);
        params.put("cooperative_id", "843400");//一期只有小棉袄合作社，所以为固定编号
        params.put("mechanism_code", mechanism);
        params.put("premium", dataBeans.getPremium() + "");
        params.put("pay_amount", dataBeans.getPay_num() + "");
        params.put("cate_id", 1 + "");
        return params;
    }

    private PayDialog2 payDialog;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT && resultCode == RESULTCODE) {
            if (payDialog == null) {
                payDialog = new PayDialog2(InsuranceOrderActivity.this, dataBeans.getCategory_name().getCategory_name(), "￥" + dataBeans.getN_tgt_fld8());//设置progress的颜色
                payDialog.getDimssLienter(InsuranceOrderActivity.this);
                payDialog.getPayLienter(InsuranceOrderActivity.this);
                payDialog.show();

            }
        }
    }

    @Override
    public void dimss() {
        payDialog.dismiss();
    }

    @Override
    public void pay(int payType) {
        Map<String, String> params = new HashMap<>();
        params.put("o_water", o_water);
        params.put("pay_way", payType + "");

        OkHttp3Utils.doPost(ConstantUtil.tokenKey, Token, Concat.PAY_URL, params, new GsonObjectCallback<PayEntity>() {
            @Override
            public void onUi(PayEntity payEntity) {
                if (payEntity.isSuccess()) {
                    //跳转到订单模块
                    Intent intent = new Intent(InsuranceOrderActivity.this, HomePageActivity.class);
                    intent.putExtra("id", 3);
                    startActivity(intent);
                } else {
                    ToastUtils.showLong(InsuranceOrderActivity.this, payEntity.getData().getErrmsg());
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {
                ToastUtils.showLong(InsuranceOrderActivity.this, ConstantUtil.NETERROR);
            }
        });
    }
}
