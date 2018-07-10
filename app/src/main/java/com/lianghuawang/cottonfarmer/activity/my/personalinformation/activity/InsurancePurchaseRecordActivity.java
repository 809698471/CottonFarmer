package com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.my.bankcard.BankCardActivity;
import com.lianghuawang.cottonfarmer.activity.my.mycredit.BankCardBindingActivity;
import com.lianghuawang.cottonfarmer.adapter.InsuranceAdapter;
import com.lianghuawang.cottonfarmer.adapter.base.BankCardAdapter;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.my.InsuranceDelEntity;
import com.lianghuawang.cottonfarmer.entity.my.InsuranceEntity;
import com.lianghuawang.cottonfarmer.entity.my.InsuranceTypesEntity;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.ui.base.AbsRecyclerViewAdapter;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.DialogUtil;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * create by fanwenke at 2018/7/4
 * 保险购买记录
 */
public class InsurancePurchaseRecordActivity extends BaseActivity implements InsuranceAdapter.OnClickItemDel, InsuranceAdapter.OnClickItemUpdata {

    @Bind(R.id.iv_insurance_return)
    ImageView mReturn;//后退
    @Bind(R.id.recyc_insurance)
    RecyclerView mRecyclerView;
    @Bind(R.id.tv_insurance_skip)
    TextView mSkip;//跳过
    @Bind(R.id.ll_insurance_xinzeng)
    LinearLayout mAddInsurance;//新增保险
    @Bind(R.id.ll_insurance_next)
    LinearLayout mNext;//下一步

    private static final int RESULT = 1010;
    private static final int RESULTCODE = 1011;//修改回调成功

    private InsuranceAdapter mAdapter;
    private static int Module;
    private String Token;
    private List<InsuranceEntity.DataBean> mDataBean;
    private static boolean InsuranceTypes = true;
    private SharedPreferencesUtil mInsuranceSP;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_insurance_purchase_record;
    }

    @Override
    protected void initView() {
        init();
        initRecycleView();
        showLoadingDialog(this);
        getInsuranceData();//获取购买保险记录
        if (InsuranceTypes) {
            mInsuranceSP.clear();
            getInsuranceTypesData();//获得保险类别
        }
    }

    private void init() {
        Module = getIntent().getIntExtra(ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_STRING, 0);
        if (Module == ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_INT) {
            mSkip.setVisibility(View.VISIBLE);
            mNext.setVisibility(View.VISIBLE);
        }
        Token = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP).getString(ConstantUtil.LOGINTOKEN, "");
        mInsuranceSP = SharedPreferencesUtil.newInstance(ConstantUtil.INSURANCE_KEY);
    }

    private void initRecycleView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new InsuranceAdapter(mRecyclerView, mDataBean);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnclickItemUpdata(this);
        mAdapter.OnClickItmeDel(this);
    }

    private void getInsuranceData() {
        OkHttp3Utils.doGet(ConstantUtil.tokenKey, Token,
                Concat.INSURANCEPURCHASERECORD_URL,
                new GsonObjectCallback<InsuranceEntity>() {
                    @Override
                    public void onUi(InsuranceEntity insuranceEntity) {
                        if (insuranceEntity.isSuccess()) {
                            mDataBean = insuranceEntity.getData();
                            mAdapter.notifyData(mDataBean);
                            dismissdingDialog();
                        } else {
                            dismissdingDialog();
                        }
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {
                        dismissdingDialog();
                        ToastUtils.showLong(InsurancePurchaseRecordActivity.this, ConstantUtil.NETERROR);
                    }
                });
    }

    private void getInsuranceTypesData() {
        OkHttp3Utils.doGet(ConstantUtil.tokenKey, Token, Concat.INSURANCEPURCHASERECORDTYPES_URL,
                new GsonObjectCallback<InsuranceTypesEntity>() {
                    @Override
                    public void onUi(InsuranceTypesEntity insuranceTypesEntity) {
                        if (insuranceTypesEntity.isSuccess()) {
                            InsuranceTypes = false;
                            for (InsuranceTypesEntity.DataBean dataBean : insuranceTypesEntity.getData()) {
                                mInsuranceSP.putString(dataBean.getProduct_number(), dataBean.getProduct_type());
                            }
                        }
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {
                        ToastUtils.showLong(InsurancePurchaseRecordActivity.this, ConstantUtil.NETERROR);
                    }
                });
    }

    @OnClick({R.id.iv_insurance_return, R.id.tv_insurance_skip, R.id.ll_insurance_xinzeng, R.id.ll_insurance_next})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_insurance_return:
                finish();
                break;
            case R.id.tv_insurance_skip://跳过---绑定银行卡
                Intent intent = new Intent(InsurancePurchaseRecordActivity.this, BankCardActivity.class);
                intent.putExtra(ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_STRING,
                        ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_INT);
                intent.putExtra(ConstantUtil.LOGINTOKEN, Token);
                startActivity(intent);
                InsurancePurchaseRecordActivity.this.finish();
                break;
            case R.id.ll_insurance_xinzeng:
                //新增
                Intent intent1 = new Intent(InsurancePurchaseRecordActivity.this,
                        InsurancePurchaseRecordAddActivity.class);
                intent1.putExtra(ConstantUtil.LOGINTOKEN, Token);
                startActivityForResult(intent1, RESULT);
                break;
            case R.id.ll_insurance_next://下一步
                Intent intent2 = new Intent(InsurancePurchaseRecordActivity.this, BankCardActivity.class);
                intent2.putExtra(ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_STRING,
                        ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_INT);
                intent2.putExtra(ConstantUtil.LOGINTOKEN, Token);
                startActivity(intent2);
                InsurancePurchaseRecordActivity.this.finish();
                break;
        }

    }

    @Override
    public void DelItem(int position, final InsuranceEntity.DataBean dataBean) {
        //删除记录
        DialogUtil.VerifyDialog(InsurancePurchaseRecordActivity.this, "提示", "是否删除此记录？","确定","取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == ConstantUtil.POSITIVE) {
                            remove(dataBean.getId());
                        }
                        dialog.dismiss();
                    }
                });
    }

    private void remove(int id) {
        Map<String, String> params = new HashMap<>();
        params.put("ins_id", id + "");
        OkHttp3Utils.doPost(ConstantUtil.tokenKey, Token, Concat.INSURANCEPURCHASERECORDDEL_URL, params,
                new GsonObjectCallback<InsuranceDelEntity>() {
                    @Override
                    public void onUi(InsuranceDelEntity insuranceDelEntity) {
                        if (insuranceDelEntity.isSuccess()) {
                            ToastUtils.showLong(InsurancePurchaseRecordActivity.this,
                                    insuranceDelEntity.getData().getSuccessmsg());
                            showLoadingDialog(InsurancePurchaseRecordActivity.this);
                            getInsuranceData();
                        } else {
                            ToastUtils.showLong(InsurancePurchaseRecordActivity.this,
                                    "删除失败");
                        }
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {
                        ToastUtils.showLong(InsurancePurchaseRecordActivity.this,
                                ConstantUtil.NETERROR);
                    }
                });
    }

    @Override
    public void updata(int positon, InsuranceEntity.DataBean dataBean) {
        //修改记录
        Intent intent = new Intent(this, InsurancePurchaseRecordAddActivity.class);
        intent.putExtra("insurance", true);
        intent.putExtra(ConstantUtil.LOGINTOKEN, Token);
        Bundle bundle = new Bundle();
        bundle.putSerializable("InsuranceEntity", dataBean);
        intent.putExtras(bundle);
        startActivityForResult(intent, RESULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULTCODE) {
            showLoadingDialog(this);
            getInsuranceData();
        }
    }
}
