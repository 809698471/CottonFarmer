package com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.my.mycredit.AuthenticationActivity;
import com.lianghuawang.cottonfarmer.netutils.APIUtils.PerfectAPI;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.netutils.instance.Perfect_Receive_Information;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.LoginUtils;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;
import com.lianghuawang.cottonfarmer.utils.VerifyUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * create by fanwenke at 2018/7/3
 * 基本信息页面
 * 注册时：
 * 1.所有字段都为必填项；
 * 2.可跳过此页面
 */
public class EssentialInformationActivity extends BaseActivity {


    @Bind(R.id.et_name)
    EditText mName;//姓名
    @Bind(R.id.rg_sex_rg)
    RadioGroup mSex;//性别
    @Bind(R.id.spinner_add_minzsp)
    Spinner mNation;//民族
    @Bind(R.id.et_idcard)
    EditText mIdCard;//身份证
    @Bind(R.id.et_phone)
    EditText mPhone;//联系方式
    @Bind(R.id.et_address)
    EditText mAddress;//家庭地址
    @Bind(R.id.et_zip)
    EditText mZip;//邮编
    @Bind(R.id.btn_authentication)
    Button mAuthentication;//提交信息
    @Bind(R.id.btn_save)
    Button mSve;
    @Bind(R.id.tv_essential_skip)
    TextView mSkip;//跳过

    private static int TYPE;//辨别是注册还是我的模块进入

    private String mNameString;//姓名
    private String mSexString;//性别
    private String mNationString;//民族
    private String mIdCardString;//身份证
    private String mPhoneString;//联系方式
    private String mAddressString;//家庭地址
    private String mZipString;//邮编

    private SharedPreferencesUtil mEssentialSP;//基本信息SP
    private boolean mInputOK = false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_essential_information;
    }

    @Override
    protected void initView() {
        initData();
        mEssentialSP = SharedPreferencesUtil.newInstance(ConstantUtil.ESSENTIAL_INFORMATION_KEY);
        if (mEssentialSP.getBoolean(ConstantUtil.ESSENTIAL_INFORMATION_ISSAVE, false)) {
            setView();//有缓存数据，加载缓存数据
        } else {
            getApi();//没有缓存数据，从服务器请求
        }
    }

    private void initData() {
        TYPE = getIntent().getIntExtra(ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_STRING, 0);
        if (TYPE == ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_INT) {
            //注册进入
            mSkip.setVisibility(View.VISIBLE);
            mSve.setText(ConstantUtil.REGISTER_NEXT);
        } else if (TYPE == ConstantUtil.INTENT_MY_JUMP_PERSONALINFORMATION_INT) {
            //从我的模块进入
        }
    }

    private void setView() {
        mName.setText(mEssentialSP.getString(ConstantUtil.ESSENTIAL_INFORMATION_USERNAME, ""));
        String sexs = mEssentialSP.getString(ConstantUtil.ESSENTIAL_INFORMATION_SEX, "男");
        if (sexs.equals("男")) {
            mSex.check(R.id.male_rb);
        } else if (sexs.equals("女")) {
            mSex.check(R.id.famale_rb);
        }
        mNation.setSelection((int) mEssentialSP.getLong(ConstantUtil.ESSENTIAL_INFORMATION_NATION, 0));
        mIdCard.setText(mEssentialSP.getString(ConstantUtil.ESSENTIAL_INFORMATION_IDCARD, ""));
        if (mEssentialSP.getBoolean(ConstantUtil.ESSENTIAL_AUTHENTICATION, false)) {
            mAuthentication.setEnabled(false);
            mAuthentication.setText("已实名认证");
        }
        mPhone.setText(mEssentialSP.getString(ConstantUtil.ESSENTIAL_INFORMATION_PHONE, ""));
        mAddress.setText(mEssentialSP.getString(ConstantUtil.ESSENTIAL_INFORMATION_ADDRESS, ""));
        mZip.setText(mEssentialSP.getString(ConstantUtil.ESSENTIAL_INFORMATION_ZIP, ""));
    }

    /**
     * 从服务器获取基础信息
     */
    private void getApi() {
        PerfectAPI api = PerfectAPI.newInstance();
        api.getToken()
                .requestGet(new GsonObjectCallback<Perfect_Receive_Information>() {
                    @Override
                    public void onUi(Perfect_Receive_Information data) {
                        if (data.isSuccess()) {
                            LogUtils.d("请求成功" + data.getData().getUsername());
                            setData(data.getData());
                        } else {
                            ToastUtils.showLong(EssentialInformationActivity.this, data.getData().getErrmsg());
                        }
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {
                        ToastUtils.showLong(EssentialInformationActivity.this, "网络连接失败");
                    }
                })
                .over();
    }

    /**
     * 从服务器获取数据成功，并缓存到SP中
     *
     * @param data
     */
    private void setData(Perfect_Receive_Information.DataBean data) {
        if (data.getUsername() != null) {
            mName.setText(data.getUsername());
            mEssentialSP.putString(ConstantUtil.ESSENTIAL_INFORMATION_USERNAME, data.getUsername());
        }
        if (data.getGender() != null) {
            String sexs = data.getGender();
            if (sexs.equals("男")) {
                mSex.check(R.id.male_rb);
            } else if (sexs.equals("女")) {
                mSex.check(R.id.famale_rb);
            }
            mEssentialSP.putString(ConstantUtil.ESSENTIAL_INFORMATION_SEX, sexs);
        }
        String nation = data.getNation();
        if (nation != null) {
            SpinnerAdapter adapter = mNation.getAdapter();
            for (int i = 0; i < adapter.getCount(); i++) {
                if (nation.equals(adapter.getItem(i).toString())) {
                    mNation.setSelection(i);
                    mEssentialSP.putLong(ConstantUtil.ESSENTIAL_INFORMATION_NATION, i);
                }
            }
        }
        if (data.getId_code() != null) {
            mIdCard.setText(data.getId_code());
            mEssentialSP.putString(ConstantUtil.ESSENTIAL_INFORMATION_IDCARD, data.getId_code());
        }
        if (data.getContact_phone() != null) {
            mPhone.setText(data.getContact_phone());
            mEssentialSP.putString(ConstantUtil.ESSENTIAL_INFORMATION_PHONE, data.getContact_phone());
        }
        if (data.getAddress() != null) {
            mAddress.setText(data.getAddress());
            mEssentialSP.putString(ConstantUtil.ESSENTIAL_INFORMATION_ADDRESS, data.getAddress());
        }
        if (data.getPostcode() != null) {
            mZip.setText(data.getPostcode());
            mEssentialSP.putString(ConstantUtil.ESSENTIAL_INFORMATION_ZIP, data.getPostcode());
        }
        if (data.getIs_identity() == 1) {
            mAuthentication.setEnabled(false);
            mAuthentication.setText("已实名认证");
            mEssentialSP.putBoolean(ConstantUtil.ESSENTIAL_AUTHENTICATION, true);
        }
        mEssentialSP.putBoolean(ConstantUtil.ESSENTIAL_INFORMATION_ISSAVE, true);
    }

    /**
     * 获取输入的数据，并进行校验
     */
    private void getData() {
        mNameString = mName.getText().toString().trim();
        if (VerifyUtil.IsEmpty(this, mNameString, ConstantUtil.ESSENTIAL_INFORMATION_USERNAME_NULL)) {
            mEssentialSP.putString(ConstantUtil.ESSENTIAL_INFORMATION_USERNAME, mNameString);
        } else {
            return;
        }

        RadioButton radioButton = findViewById(mSex.getCheckedRadioButtonId());
        mSexString = radioButton.getText().toString();
        mEssentialSP.putString(ConstantUtil.ESSENTIAL_INFORMATION_SEX, mSexString);

        mNationString = mNation.getSelectedItem() + "";
        if (VerifyUtil.IsEmpty(this, mNationString, ConstantUtil.ESSENTIAL_INFORMATION_NATION_NULL)) {
            mEssentialSP.putLong(ConstantUtil.ESSENTIAL_INFORMATION_NATION, mNation.getSelectedItemId());
        } else {
            return;
        }
        SpinnerAdapter adapter = mNation.getAdapter();
        mNationString = (String) adapter.getItem((int) mNation.getSelectedItemId());

        mIdCardString = mIdCard.getText().toString().trim();
        if (VerifyUtil.IsEmpty(this, mIdCardString, ConstantUtil.ESSENTIAL_INFORMATION_IDCARD_NULL)) {
            mEssentialSP.putString(ConstantUtil.ESSENTIAL_INFORMATION_IDCARD, mIdCardString);
        } else {
            return;
        }

        mPhoneString = mPhone.getText().toString().trim();
        VerifyUtil.IsEmpty(this, mPhoneString, ConstantUtil.ESSENTIAL_INFORMATION_PHONE_NULL);
        if (!LoginUtils.isMobile(mPhoneString)) {//验证手机的合法性
            ToastUtils.showLong(this, ConstantUtil.INPUT_CORRECT_PHONE);
            return;
        }
        mEssentialSP.putString(ConstantUtil.ESSENTIAL_INFORMATION_PHONE, mPhoneString);

        mAddressString = mAddress.getText().toString().trim();
        if (VerifyUtil.IsEmpty(this, mAddressString, ConstantUtil.ESSENTIAL_INFORMATION_ADDRESS_NULL)) {
            mEssentialSP.putString(ConstantUtil.ESSENTIAL_INFORMATION_ADDRESS, mAddressString);
        } else {
            return;
        }

        mZipString = mZip.getText().toString().trim();
        if (VerifyUtil.IsEmpty(this, mZipString, ConstantUtil.ESSENTIAL_INFORMATION_ZIP_NULL)) {
            mEssentialSP.putString(ConstantUtil.ESSENTIAL_INFORMATION_ZIP, mZipString);
        } else {
            return;
        }
        mInputOK = true;
    }

    @OnClick({R.id.btn_save, R.id.btn_authentication, R.id.tv_essential_skip})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_essential_skip://跳过
                Intent intent = new Intent(EssentialInformationActivity.this, PlantingInformationActivity.class);
                intent.putExtra(ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_STRING,
                        ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_INT);
                startActivity(intent);
                finish();
                break;
            //下一步---种植信息
            case R.id.btn_save:
                HttpAPI();
                break;
            case R.id.btn_authentication:
                startActivity(new Intent(EssentialInformationActivity.this, AuthenticationActivity.class));
                break;
        }
    }

    /**
     * 提交数据到服务器
     */
    private void HttpAPI() {
        showLoadingDialog(this);
        Map<String, String> params = getParams();
        if (!mInputOK) {
            dismissdingDialog();
            return;
        }
        PerfectAPI api = PerfectAPI.newInstance();
        api.getToken()
                .getParams(params)
                .requestPat(new GsonObjectCallback<Perfect_Receive_Information>() {
                    @Override
                    public void onUi(Perfect_Receive_Information data) {
                        if (data.isSuccess()) {
                            dismissdingDialog();
                            mEssentialSP.putBoolean(ConstantUtil.ESSENTIAL_INFORMATION_ISSAVE, true);
                            ToastUtils.showLong(EssentialInformationActivity.this, ConstantUtil.SAVE_SUCCEED);
                            if (TYPE == ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_INT) {
                                Intent intent = new Intent(EssentialInformationActivity.this, PlantingInformationActivity.class);
                                intent.putExtra(ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_STRING,
                                        ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_INT);
                                startActivity(intent);
                            } else if (TYPE == ConstantUtil.INTENT_MY_JUMP_PERSONALINFORMATION_INT){
                                EssentialInformationActivity.this.finish();
                            }
                        } else {
                            dismissdingDialog();
                            ToastUtils.showLong(EssentialInformationActivity.this, data.getData().getErrmsg());
                        }
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {
                        dismissdingDialog();
                        ToastUtils.showLong(EssentialInformationActivity.this, ConstantUtil.NETERROR);
                    }
                })
                .over();
    }

    private Map<String, String> getParams() {
        getData();
        Map<String, String> params = new HashMap<>();
        params.put("username", mNameString);
        params.put("gender", mSexString);
        params.put("nation", mNationString);
        params.put("id_code", mIdCardString);
        params.put("contact_phone", mPhoneString);
        params.put("address", mAddressString);
        params.put("postcode", mZipString);
        return params;
    }
}
