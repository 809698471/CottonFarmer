package com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.my.personalinformation.MassifInformationListActivity;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.my.Corps;
import com.lianghuawang.cottonfarmer.entity.my.PlaintingInformationEntity;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.netutils.instance.Perfect_Receive_Information2;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;
import com.lianghuawang.cottonfarmer.utils.VerifyUtil;
import com.lianghuawang.cottonfarmer.widget.linkage_menu.AddressSelector;
import com.lianghuawang.cottonfarmer.widget.linkage_menu.CityInterface;
import com.lianghuawang.cottonfarmer.widget.linkage_menu.OnClickDisappearListener;
import com.lianghuawang.cottonfarmer.widget.linkage_menu.OnItemAddressClickListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * create by fanwenke at 2018/7/3
 * 种植信息
 */
public class PlantingInformationActivity extends BaseActivity implements OnClickDisappearListener, OnItemAddressClickListener, AddressSelector.OnTabSelectedListener {

    @Bind(R.id.tv_area)
    TextView mArea;//种植地址
    @Bind(R.id.rl_block)
    RelativeLayout mBlock;//地块信息
    @Bind(R.id.plantinginformation_return)
    ImageView mReturn;//返回键
    @Bind(R.id.plantinginformation_next)
    Button mSubmit;//提交
    @Bind(R.id.et_acres)
    EditText mAcres;//种植亩数
    @Bind(R.id.et_kgs)
    EditText mKgs;//平均产量
    @Bind(R.id.edit_shuliang)
    EditText mNumber;//地块数量
    @Bind(R.id.tv_planting_skip)
    TextView mSkip;//跳过
    @Bind(R.id.address1)
    AddressSelector mAddress;

    private SharedPreferencesUtil mPlantingSP;
    private String mToken;
    private int type;
    private Map<Integer, String> key;
    private Map<Integer, String> mapAddress;
    private String address;
    private ArrayList<String> code;
    private static int Module;//进入的模式
    @Override
    protected int getLayoutId() {

        return R.layout.activity_planting_information;

    }

    @Override
    protected void initView() {
        Module = getIntent().getIntExtra(ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_STRING,0);
        if (Module == ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_INT){
            mSkip.setVisibility(View.VISIBLE);
            mSubmit.setText(ConstantUtil.REGISTER_NEXT);
        }
        mPlantingSP = SharedPreferencesUtil.newInstance(ConstantUtil.PLANTING_KEY);
        SharedPreferencesUtil LoginSP = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP);
        mToken = LoginSP.getString(ConstantUtil.LOGINTOKEN, "");
        if (mPlantingSP.getBoolean(ConstantUtil.PLANTING_ISSAVE, false)) {
            setView();
        } else {
            getApi();
        }
    }

    private void setView() {
        mAcres.setText(mPlantingSP.getString(ConstantUtil.PLANTING_ACRES, "0"));
        mArea.setText(mPlantingSP.getString(ConstantUtil.PLANTING_AREA, ""));
        mNumber.setText(mPlantingSP.getString(ConstantUtil.PLANTING_NUMBER, "0"));
        mKgs.setText(mPlantingSP.getString(ConstantUtil.PLANTING_KGS, "0"));
        if (code == null) {
            code = new ArrayList<>();
        }
        code.add(mPlantingSP.getString(ConstantUtil.PLANTING_DIVISION, "0"));
        code.add(mPlantingSP.getString(ConstantUtil.PLANTING_GROUP, "0"));
        code.add(mPlantingSP.getString(ConstantUtil.PLANTING_EVEN, "0"));
        code.add(mPlantingSP.getString(ConstantUtil.PLANTING_TOWNSHIP, "0"));
        code.add(mPlantingSP.getString(ConstantUtil.PLANTING_VILLAGE, "0"));
        type = mPlantingSP.getInt(ConstantUtil.PLANTING_AREA_TYPE, 0);
    }

    private void getApi() {
        OkHttp3Utils.doGet(ConstantUtil.tokenKey, mToken, Concat.PERSONALDETAILS_URL, new GsonObjectCallback<Perfect_Receive_Information2>() {
            @Override
            public void onUi(Perfect_Receive_Information2 data) {
                if (data.isSuccess()) {
                    setData(data.getData());
                    mPlantingSP.putBoolean(ConstantUtil.PLANTING_ISSAVE, true);
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {
                ToastUtils.showLong(PlantingInformationActivity.this, "网络连接失败");
            }
        });
    }

    private void setData(Perfect_Receive_Information2.DataBean data) {
        mAcres.setText(data.getCotton_area() + "");
        mPlantingSP.putString(ConstantUtil.PLANTING_ACRES, data.getCotton_area() + "");

        mNumber.setText(data.getPlot_number() + "");
        mPlantingSP.putString(ConstantUtil.PLANTING_NUMBER, data.getPlot_number() + "");

        mKgs.setText(data.getAverage() + "");
        mPlantingSP.putString(ConstantUtil.PLANTING_KGS, data.getAverage() + "");

        if (data.getPlant_area() != null) {
            mArea.setText(data.getPlant_area());
            mPlantingSP.putString(ConstantUtil.PLANTING_AREA, data.getPlant_area());
        }
        if (data.getArea_code() != null) {
            if (code == null) {
                code = new ArrayList<>();
            }
            if (data.getArea_code().getDivision() != null) {
                code.add(data.getArea_code().getDivision());
                mPlantingSP.putString(ConstantUtil.PLANTING_DIVISION, data.getArea_code().getDivision());
            }
            if (data.getArea_code().getGroup() != null) {
                code.add(data.getArea_code().getGroup());
                mPlantingSP.putString(ConstantUtil.PLANTING_GROUP, data.getArea_code().getGroup());
            }
            if (data.getArea_code().getEven() != null) {
                code.add(data.getArea_code().getEven());
                mPlantingSP.putString(ConstantUtil.PLANTING_EVEN, data.getArea_code().getEven());
            }
            if (data.getArea_code().getTownship() != null) {
                code.add(data.getArea_code().getTownship());
                mPlantingSP.putString(ConstantUtil.PLANTING_TOWNSHIP, data.getArea_code().getTownship());
            }
            if (data.getArea_code().getVillage() != null) {
                code.add(data.getArea_code().getVillage());
                mPlantingSP.putString(ConstantUtil.PLANTING_VILLAGE, data.getArea_code().getVillage());
            }
            type = data.getArea_code().getArea_type();
            mPlantingSP.putInt(ConstantUtil.PLANTING_AREA_TYPE, type);
        } else {
            mArea.setText("");
        }
    }

    @OnClick({R.id.plantinginformation_return, R.id.rl_block, R.id.plantinginformation_next,R.id.tv_planting_skip})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plantinginformation_return:
                finish();
                break;
            //地块信息列表
            case R.id.rl_block:
                if (code == null) {
                    ToastUtils.showLong(PlantingInformationActivity.this, "请先选择种植地址");
                } else {
                    Intent intent = new Intent(PlantingInformationActivity.this, MassifInformationListActivity.class);
                    intent.putExtra("type", type);
                    intent.putExtra("token", mToken);
                    intent.putStringArrayListExtra("code", code);
                    startActivity(intent);
                }
                break;

            //下一步---权属证明
            case R.id.plantinginformation_next:
                SubmitData();
                break;
            case R.id.tv_planting_skip:
                Intent intent = new Intent(PlantingInformationActivity.this,ProofOfOwnershipActivity.class);
                intent.putExtra(ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_STRING,
                        ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_INT);
                startActivity(intent);
                finish();
                break;
        }

    }

    @OnClick(R.id.tv_area)
    public void onClick(TextView textView) {
        type = 1;
        key_item = 1;
        mAddress.setVisibility(View.VISIBLE);
        mAddress.setCities((ArrayList) setClass(), 5, true, PlantingInformationActivity.this);
        initAddress();
    }

    private void getData(final int type, Object id) {
        String url = String.format(Concat.CORPS, type, id);
        OkHttp3Utils.doGet(ConstantUtil.LOGINTOKEN, mToken, url, new GsonObjectCallback<Corps>() {
            @Override
            public void onUi(Corps corps) {
                if (corps.getData() != null && corps.getData().size() != 0) {
                    List<Corps.DataBean> dataBeans = corps.getData();
                    mAddress.setCities((ArrayList) dataBeans, 5, false, null);
                    dismissdingDialog();
                } else if (corps.getData() != null && corps.getData().size() == 0) {
                    dismissdingDialog();
                    dimss();
                }
                dismissdingDialog();
            }

            @Override
            public void onFailed(Call call, IOException e) {
                dismissdingDialog();
                ToastUtils.showLong(PlantingInformationActivity.this, ConstantUtil.NETERROR);
            }
        });
    }

    private int key_item = 1;

    @Override
    public void itemClick(AddressSelector addressSelector, CityInterface city, int tabPosition) {
        showLoadingDialog(PlantingInformationActivity.this);
        String id;
        if (key_item == 1) {
            type = city.getId();
            id = 0 + "";
        } else {
            id = city.getArea_code();
        }
        getData(type, id);
        if (key == null) {
            key = new WeakHashMap<>();
        }
        key.put(key_item, id);
        if (mapAddress == null) {
            mapAddress = new WeakHashMap<>();
        }
        mapAddress.put(key_item, city.getCityName());

        key_item++;
    }

    @Override
    public void onTabSelected(AddressSelector addressSelector, AddressSelector.Tab tab) {
        //点击已经选择过tab调用
        switch (tab.getIndex()) {
            case 0:
                key_item = 1;
                mAddress.setCities((ArrayList) setClass(), 5, false, null);
                break;
            case 1:
                key_item = 2;
                String value = key.get(1);
                showLoadingDialog(PlantingInformationActivity.this);
                getData(type, value);
                break;
            case 2:
                key_item = 3;
                String value1 = key.get(2);
                showLoadingDialog(PlantingInformationActivity.this);
                getData(type, value1);
                break;
            case 3:
                key_item = 4;
                String value2 = key.get(3);
                showLoadingDialog(PlantingInformationActivity.this);
                getData(type, value2);
                break;
            case 4:
                key_item = 5;
                String value3 = key.get(4);
                showLoadingDialog(PlantingInformationActivity.this);
                getData(type, value3);
                break;
        }
    }

    @Override
    public void onTabReselected(AddressSelector addressSelector, AddressSelector.Tab tab) {
        //点击当前的tab调用
    }

    @Override
    public void onclick() {
        mAddress.setVisibility(View.GONE);
    }

    private void initAddress() {
        mAddress.setDisapperListener(this);
        mAddress.setOnItemClickListener(this);
        mAddress.setOnTabSelectedListener(this);
    }

    private void dimss() {
        mAddress.setVisibility(View.GONE);
        address = "";
        for (int i = 1; i < mapAddress.size() + 1; i++) {
            address = address + mapAddress.get(i);
        }

        address = address.replace("新疆地方", "新疆");
        mArea.setText(address);
        mapAddress = null;
        code = null;
        if (code == null) {
            code = new ArrayList<>();
        }
        for (int i = 2; i < key.size() + 1; i++) {
            code.add(this.key.get(i));
        }
        key = null;
        int num = code.size();
        for (int i = 0; i < 5; i++) {
            if (i >= num) {
                code.add("0");
            }
        }
    }

    private List<Corps.DataBean> setClass() {
        List<Corps.DataBean> list = new ArrayList<>();
        Corps.DataBean bean = new Corps.DataBean();
        bean.setArea_name("新疆兵团");
        bean.setId(1);
        list.add(bean);
        Corps.DataBean bean1 = new Corps.DataBean();
        bean1.setArea_name("新疆地方");
        bean1.setId(2);
        list.add(bean1);
        return list;
    }

    private void SubmitData() {
        String Acres = mAcres.getText().toString().trim();//种植面积
        if (VerifyUtil.IsEmpty(this, Acres, ConstantUtil.PLANTING_ACRES_NULL)) {
            mPlantingSP.putString(ConstantUtil.PLANTING_ACRES, Acres);
        } else {
            return;
        }
        String Kgs = mKgs.getText().toString().trim();//平均产量
        if (VerifyUtil.IsEmpty(this, Kgs, ConstantUtil.PLANTING_KGS_NULL)) {
            mPlantingSP.putString(ConstantUtil.PLANTING_KGS, Kgs);
        } else {
            return;
        }
        String Number = mNumber.getText().toString().trim();
        if (VerifyUtil.IsEmpty(this, Number, ConstantUtil.PLANTING_NUMBER_NULL)) {
            mPlantingSP.putString(ConstantUtil.PLANTING_NUMBER, Number);
        } else {
            return;
        }
        if (VerifyUtil.IsEmpty(this, address, ConstantUtil.PLANTING_AREA_NULL)) {
            mPlantingSP.putString(ConstantUtil.PLANTING_AREA, address);
            mPlantingSP.putString(ConstantUtil.PLANTING_DIVISION, code.get(0));
            mPlantingSP.putString(ConstantUtil.PLANTING_GROUP, code.get(1));
            mPlantingSP.putString(ConstantUtil.PLANTING_EVEN, code.get(2));
            mPlantingSP.putString(ConstantUtil.PLANTING_TOWNSHIP, code.get(3));
            mPlantingSP.putString(ConstantUtil.PLANTING_VILLAGE, code.get(4));
            mPlantingSP.putInt(ConstantUtil.PLANTING_AREA_TYPE, type);
        } else {
            return;
        }
        Map<String, String> params = new HashMap<>();
        params.put("crop_name", "棉花");//作物名称
        params.put("cotton_area", Acres);//种植面积
        params.put("plant_area", address);//种植地址（文字版）
        params.put("plot_number", Number);//地块数量
        params.put("average", Kgs);//平均产量
        params.put("division", code.get(0));//省/师代码
        params.put("group", code.get(1));//市/团代码
        params.put("even", code.get(2));//县/连代码
        params.put("township", code.get(3));//乡代码
        params.put("village", code.get(4));//村代码
        params.put("area_type", type + "");//区域类型

        OkHttp3Utils.doPat(ConstantUtil.tokenKey, mToken, Concat.PERFECTPLANTING_URL, params,
                new GsonObjectCallback<PlaintingInformationEntity>() {
                    @Override
                    public void onUi(PlaintingInformationEntity plaintingInformationEntity) {
                        if (plaintingInformationEntity.isSuccess()) {
                            ToastUtils.showLong(PlantingInformationActivity.this, ConstantUtil.SAVE_SUCCEED);
                            Intent intent = new Intent(PlantingInformationActivity.this,ProofOfOwnershipActivity.class);
                            if (Module == ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_INT) {
                                intent.putExtra(ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_STRING,
                                        ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_INT);
                            } else {
                                intent.putExtra(ConstantUtil.INTENT_LOGIN_JUMP_PERSONALINFORMATION_STRING,
                                        ConstantUtil.INTENT_MY_JUMP_PERSONALINFORMATION_INT);
                            }
                            startActivity(intent);
                        } else {
                            ToastUtils.showLong(PlantingInformationActivity.this,
                                    plaintingInformationEntity.getData().getErrmsg());
                        }
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {

                    }
                });
    }
}
