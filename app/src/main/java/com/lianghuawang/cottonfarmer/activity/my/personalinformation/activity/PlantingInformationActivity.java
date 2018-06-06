package com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity;


import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.my.personalinformation.MassifInformationListActivity;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.my.Corps;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.netutils.instance.ProofInstance;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;
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

//种植信息
public class PlantingInformationActivity extends BaseActivity implements OnClickDisappearListener, OnItemAddressClickListener, AddressSelector.OnTabSelectedListener {

    @Bind(R.id.tv_area)
    TextView mArea;
    @Bind(R.id.rl_block)
    RelativeLayout mBlock;
    @Bind(R.id.plantinginformation_return)
    ImageView mReturn;
    @Bind(R.id.plantinginformation_next)
    Button mSubmit;

    private AddressSelector address1;
    private SharedPreferencesUtil sp;
    private String token;
    private int type;
    private Map<Integer, String> key;
    private Map<Integer, String> mapAddress;

    @Override
    protected int getLayoutId() {

        return R.layout.activity_planting_information;

    }

    @Override
    protected void initView() {

        sp = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP);
        token = sp.getString(ConstantUtil.LOGINTOKEN, "");
        address1 = findViewById(R.id.address1);
    }

    @OnClick({R.id.plantinginformation_return,R.id.rl_block})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plantinginformation_return:
                finish();
                break;
            //地块信息列表
            case R.id.rl_block:
                startActivity(new Intent(PlantingInformationActivity.this, MassifInformationListActivity.class));
                break;

            //下一步---权属证明
            case R.id.plantinginformation_next:
                startActivity(new Intent(PlantingInformationActivity.this, ProofOfOwnershipActivity.class));
                break;
        }

    }

    @OnClick(R.id.tv_area)
    public void onClick(TextView textView) {
        type = 1;
        key_item = 1;
        address1.setVisibility(View.VISIBLE);
        address1.setCities((ArrayList) setClass(), 5, true, PlantingInformationActivity.this);
        initAddress();
    }

    private void getData(final int type, Object id) {
        String url = String.format(Concat.CORPS, type, id);
        OkHttp3Utils.doGet(ConstantUtil.LOGINTOKEN, token, url, new GsonObjectCallback<Corps>() {
            @Override
            public void onUi(Corps corps) {
                if (corps.getData() != null && corps.getData().size() != 0) {
                    List<Corps.DataBean> dataBeans = corps.getData();
                    address1.setCities((ArrayList) dataBeans, 5, false, null);
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
                ToastUtils.showLong(PlantingInformationActivity.this, "亲，多读书");
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
                address1.setCities((ArrayList) setClass(), 5, false, null);
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
        address1.setVisibility(View.GONE);
    }

    private void initAddress() {
        address1.setDisapperListener(this);
        address1.setOnItemClickListener(this);
        address1.setOnTabSelectedListener(this);
    }

    private void dimss() {
        address1.setVisibility(View.GONE);
        String address = "";
        for (int i : mapAddress.keySet()) {

            address = mapAddress.get(i) + address;
        }
        address = address.replace("新疆地方","新疆");
        mArea.setText(address);
        mapAddress = null;
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
}
