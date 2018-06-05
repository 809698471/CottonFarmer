package com.lianghuawang.cottonfarmer.activity.my.personalinformation.activity;


import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.my.personalinformation.MassifInformationListActivity;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.my.Corps;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
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
public class PlantingInformationActivity extends BaseActivity implements View.OnClickListener, OnClickDisappearListener, OnItemAddressClickListener, AddressSelector.OnTabSelectedListener {

    @Bind(R.id.radio)
    RadioGroup mRadio;
    @Bind(R.id.ra_a)
    RadioButton mCorps;
    @Bind(R.id.ra_b)
    RadioButton mPlace;
    @Bind(R.id.ra_c)
    RadioButton mOther;

    private AddressSelector address1;
    private ImageView plantinginformation_return;
    private Button plantinginformation_next;
    private EditText edit_shuliang;
    private SharedPreferencesUtil sp;
    private String token;
    private int type;
    private Map<Integer, String> key;

    @Override
    protected int getLayoutId() {

        return R.layout.activity_planting_information;

    }

    @Override
    protected void initView() {
        plantinginformation_return = (ImageView) findViewById(R.id.plantinginformation_return);
        plantinginformation_next = (Button) findViewById(R.id.plantinginformation_next);
        edit_shuliang = (EditText) findViewById(R.id.edit_shuliang);

        plantinginformation_return.setOnClickListener(this);
        edit_shuliang.setOnClickListener(this);
        plantinginformation_next.setOnClickListener(this);

        sp = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP);
        token = sp.getString(ConstantUtil.LOGINTOKEN, "");
        address1 = findViewById(R.id.address1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plantinginformation_return:
                finish();
                break;
            //地块信息列表
            case R.id.edit_shuliang:
                //隐藏软键盘
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                startActivity(new Intent(PlantingInformationActivity.this, MassifInformationListActivity.class));
                break;

            //下一步---权属证明
            case R.id.plantinginformation_next:
                startActivity(new Intent(PlantingInformationActivity.this, ProofOfOwnershipActivity.class));
                break;

        }

    }

    @OnClick({R.id.ra_a, R.id.ra_b, R.id.ra_c})
    public void onClick(RadioButton button) {
        switch (button.getId()) {
            case R.id.ra_a:
                showLoadingDialog(PlantingInformationActivity.this);
                Corps();
                break;
            case R.id.ra_b:
                Place();
                break;
            case R.id.ra_c:
                Other();
                break;
        }
    }

    boolean flag = true;

    //选择兵团数据
    private void Corps() {
        type = 1;
        initAddress();
        address1.setVisibility(View.VISIBLE);
        flag = true;
        getData(type, 0);
    }

    //选择地方数据
    private void Place() {
        type = 2;
        initAddress();
        address1.setVisibility(View.VISIBLE);
        flag = true;
        getData(type, 0);
    }

    //选择其他
    private void Other() {

    }

    private void getData(final int type, Object id) {
        String url = String.format(Concat.CORPS, type, id);
        OkHttp3Utils.doGet(ConstantUtil.LOGINTOKEN, token, url, new GsonObjectCallback<Corps>() {
            @Override
            public void onUi(Corps corps) {
                if (corps.getData() != null && corps.getData().size() != 0) {
                    List<Corps.DataBean> dataBeans = corps.getData();
                    if (flag) {
                        address1.setCities((ArrayList) dataBeans, type, true, PlantingInformationActivity.this);
                        initAddress();
                        flag = false;
                    } else {
                        address1.setCities((ArrayList) dataBeans, type, false, null);
                    }

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

        String id = city.getArea_code();
        getData(type, id);
        if (key == null) {
            key = new WeakHashMap<>();
        }
        key.put(key_item, id);
        key_item++;
    }

    @Override
    public void onTabSelected(AddressSelector addressSelector, AddressSelector.Tab tab) {
        //点击已经选择过tab调用
        switch (tab.getIndex()) {
            case 0:
                key_item = 1;
                getData(type, 0);
                break;
            case 1:
                key_item = 2;
                String value = key.get(1);
                getData(type, value);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
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
}
