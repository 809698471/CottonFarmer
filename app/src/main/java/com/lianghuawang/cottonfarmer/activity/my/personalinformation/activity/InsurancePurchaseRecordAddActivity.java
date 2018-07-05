package com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.my.InsuranceEntity;
import com.lianghuawang.cottonfarmer.entity.my.InsuranceUpdateEntity;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * create by fanwenke at 2018/7/5
 * 增加/修改保险记录
 */
public class InsurancePurchaseRecordAddActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {

    @Bind(R.id.iv_insurance_purchase_return)
    ImageView mReturn;
    @Bind(R.id.tv_insurance_purchase_title)
    TextView mTitle;
    @Bind(R.id.spinner_insurance_purchase_year)
    Spinner mYear;
    @Bind(R.id.spinner_insurance_purchase_types)
    Spinner mTypes;
    @Bind(R.id.et_insurance_purchase_area)
    EditText mArea;
    @Bind(R.id.btn_insurance_purchase_submit)
    Button mSubmit;

    private static final String TYPESID = "product_number";
    private static final String TYPESNAME = "product_type";

    private static final int RESULTCODE = 1011;

    private boolean mUpdata;
    private String Token;
    private InsuranceEntity.DataBean mDataBean;
    private List<Map<String, Object>> mDataTypes;//险种list

    private String mRisk;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_insurance_purchase_record_add;
    }

    @Override
    protected void initView() {
        initTypes();
        getIntents();
    }

    private void initTypes() {
        SharedPreferencesUtil types = SharedPreferencesUtil.newInstance(ConstantUtil.INSURANCE_KEY);
        mDataTypes = new ArrayList<>();
        Map<String, Object> map = types.getAll();
        for (String value : map.keySet()) {
            Map<String, Object> map1 = new HashMap<>();
            map1.put(TYPESID, value);
            map1.put(TYPESNAME, map.get(value));
            mDataTypes.add(0, map1);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, mDataTypes,
                R.layout.activity_insurance_purchase_spinner,
                new String[]{TYPESNAME},
                new int[]{R.id.tv_insurance_purchase_spinner});
        mTypes.setAdapter(adapter);
        mTypes.setOnItemSelectedListener(this);
    }

    private void getIntents() {//判断是新增还是修改
        Token = getIntent().getStringExtra(ConstantUtil.LOGINTOKEN);
        mUpdata = getIntent().getBooleanExtra("insurance", false);
        if (mUpdata) {
            mTitle.setText("修改记录");
            mDataBean = (InsuranceEntity.DataBean) getIntent().getSerializableExtra("InsuranceEntity");
            init();
        }
    }

    private void init() {//初始化数据
        SpinnerAdapter adapter = mYear.getAdapter();
        for (int i = 0; i < adapter.getCount(); i++) {
            if ((mDataBean.getYear() + "").equals(adapter.getItem(i).toString())) {
                mYear.setSelection(i);
            }
        }
        SpinnerAdapter adapter1 = mTypes.getAdapter();
        for (int i = 0; i < adapter1.getCount(); i++) {
            if (mDataBean.getRisk_name().equals(((Map<String, String>) adapter1.getItem(i)).get(TYPESNAME))) {
                mTypes.setSelection(i);
            }
        }
        mArea.setText(mDataBean.getIns_area() + "");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        LogUtils.d(mDataTypes.get(position).get(TYPESID) + "");
        if (mUpdata) {
            mDataBean.setRisk(mDataTypes.get(position).get(TYPESID) + "");
            mDataBean.setRisk_name(mDataTypes.get(position).get(TYPESNAME) + "");
        } else {
            mRisk = mDataTypes.get(position).get(TYPESID) + "";
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @OnClick({R.id.btn_insurance_purchase_submit})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_insurance_purchase_submit:
                if (mUpdata){
                    //修改
                    showLoadingDialog(this);
                    SpinnerAdapter adapter1 = mYear.getAdapter();
                    Map<String,String> params = new HashMap<>();
                    params.put("ins_id",mDataBean.getId()+"");
                    params.put("year", (String) adapter1.getItem((int) mYear.getSelectedItemId()));
                    params.put("risk",mDataBean.getRisk());
                    params.put("ins_area",mArea.getText().toString().trim());
                    OkHttp3Utils.doPat(ConstantUtil.tokenKey, Token, Concat.INSURANCEPURCHASERECORDUPDATE_URL,
                            params, new GsonObjectCallback<InsuranceUpdateEntity>() {
                                @Override
                                public void onUi(InsuranceUpdateEntity insuranceUpdateEntity) {
                                    if (insuranceUpdateEntity.isSuccess()){
                                        ToastUtils.showLong(InsurancePurchaseRecordAddActivity.this,
                                                insuranceUpdateEntity.getData().getSuccessmsg());
                                        dismissdingDialog();
                                        setResult(RESULTCODE);
                                        finish();
                                    } else {
                                        ToastUtils.showLong(InsurancePurchaseRecordAddActivity.this,
                                                insuranceUpdateEntity.getData().getErrmsg());
                                        dismissdingDialog();
                                    }
                                }

                                @Override
                                public void onFailed(Call call, IOException e) {
                                        ToastUtils.showLong(InsurancePurchaseRecordAddActivity.this,ConstantUtil.NETERROR);
                                }
                            });
                } else {
                    //新增
                    SpinnerAdapter adapter1 = mYear.getAdapter();
                    Map<String,String> params = new HashMap<>();
                    params.put("year", (String) adapter1.getItem((int) mYear.getSelectedItemId()));
                    params.put("risk", mRisk);
                    params.put("ins_area",mArea.getText().toString().trim());
                    OkHttp3Utils.doPost(ConstantUtil.tokenKey, Token, Concat.INSURANCEPURCHASERECORDUPADD_URL,
                            params, new GsonObjectCallback<InsuranceUpdateEntity>() {
                                @Override
                                public void onUi(InsuranceUpdateEntity insuranceUpdateEntity) {
                                    if (insuranceUpdateEntity.isSuccess()){
                                        ToastUtils.showLong(InsurancePurchaseRecordAddActivity.this,
                                                "新增成功");
                                        dismissdingDialog();
                                        setResult(RESULTCODE);
                                        finish();
                                    } else {
                                        ToastUtils.showLong(InsurancePurchaseRecordAddActivity.this,
                                                "新增失败");
                                        dismissdingDialog();
                                    }
                                }

                                @Override
                                public void onFailed(Call call, IOException e) {
                                    ToastUtils.showLong(InsurancePurchaseRecordAddActivity.this,ConstantUtil.NETERROR);
                                }
                            });
                }
                break;
        }
    }
}
