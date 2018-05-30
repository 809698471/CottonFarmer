package com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.netutils.APIUtils.PerfectAPI;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.netutils.instance.Perfect_Receive_Information;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;

//基本信息
public class EssentialInformationActivity extends BaseActivity {


    @Bind(R.id.et_name)
    EditText name;//姓名

    @Bind(R.id.rg_sex_rg)
    RadioGroup sex;//性别

    @Bind(R.id.spinner_add_minzsp)
    Spinner minzsp;//民族

    @Bind(R.id.et_idcard)
    EditText idCard;//身份证

    @Bind(R.id.et_phone)
    EditText phone;//联系方式

    @Bind(R.id.et_address)
    EditText address;//家庭地址

    @Bind(R.id.et_zip)
    EditText zip;//邮编

    private String mName;
    private String mSex;
    private String mMinzsp;
    private String mIdCard;
    private String mPhone;
    private String mAddress;
    private String mZip;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_essential_information;
    }

    @Override
    protected void initView() {
        getApi();
    }

    private void setData(Perfect_Receive_Information.DataBean data){
        name.setText(data.getUsername());
        String sexs = data.getGender();
        if (sexs.equals("男")){
            sex.check(R.id.male_rb);
        } else if (sexs.equals("女")){
            sex.check(R.id.famale_rb);
        }
        String nation = data.getNation();
        SpinnerAdapter adapter = minzsp.getAdapter();
        for (int i = 0; i < adapter.getCount(); i++){
            if (nation.equals(adapter.getItem(i).toString())){
                minzsp.setSelection(i);
            }
        }
        idCard.setText(data.getId_code());
        phone.setText(data.getContact_phone());
        address.setText(data.getAddress());
        zip.setText(data.getPostcode());
    }

    private void getApi() {
        PerfectAPI api = PerfectAPI.newInstance();
        api.getToken()
                .requestGet(new GsonObjectCallback<Perfect_Receive_Information>() {
                    @Override
                    public void onUi(Perfect_Receive_Information data) {
                        if (data.isSuccess()) {
                            LogUtils.d("请求成功"+data.getData().getUsername());
                            setData(data.getData());
                        } else {
                            ToastUtils.showLong(EssentialInformationActivity.this,data.getData().getErrmsg());
                        }
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {
                        ToastUtils.showLong(EssentialInformationActivity.this, "网络连接失败");
                    }
                })
                .over();
    }

    private void getData() {
        mName = name.getText().toString().trim();
        RadioButton radioButton = findViewById(sex.getCheckedRadioButtonId());
        mSex = radioButton.getText().toString();
        mMinzsp = (String) minzsp.getSelectedItem();
        mIdCard = idCard.getText().toString().trim();
        mPhone = phone.getText().toString().trim();
        mAddress = address.getText().toString().trim();
        mZip = zip.getText().toString().trim();
    }

    @OnClick({R.id.btn_save})
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.essentialinformation_return:
//                finish();
//                break;
            //下一步---种植信息
            case R.id.btn_save:
                HttpAPI();
                break;
        }
    }

    private void HttpAPI() {
        PerfectAPI api = PerfectAPI.newInstance();
        api.getToken()
                .getParams(getParams())
                .requestPat(new GsonObjectCallback<Perfect_Receive_Information>() {
                    @Override
                    public void onUi(Perfect_Receive_Information data) {
                        if (data.isSuccess()) {
                            LogUtils.d("请求成功"+data.getData().getUsername());
                        } else {
                            ToastUtils.showLong(EssentialInformationActivity.this,data.getData().getErrmsg());
                        }
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {
                        ToastUtils.showLong(EssentialInformationActivity.this, "网络连接失败");
                    }
                })
                .over();

    }

    private Map<String, String> getParams() {
        getData();
        Map<String, String> params = new HashMap<>();
        params.put("username", mName);
        params.put("gender", mSex);
        params.put("nation", mMinzsp);
        params.put("id_code", mIdCard);
        params.put("contact_phone", mPhone);
        params.put("address", mAddress);
        params.put("postcode", mZip);
        return params;
    }
}
