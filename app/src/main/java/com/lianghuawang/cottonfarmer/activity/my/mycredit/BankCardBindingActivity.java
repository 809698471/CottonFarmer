package com.lianghuawang.cottonfarmer.activity.my.mycredit;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.tools.BankCardTextWatcher;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import me.leefeng.citypicker.CityPicker;
import me.leefeng.citypicker.CityPickerListener;

//银行卡绑定
public class BankCardBindingActivity extends BaseActivity implements View.OnClickListener, CityPickerListener {
    private TextView mShow;
    private Button mSelector;
    private CityPicker cityPicker;
    private ImageView bankcardbinding_return;
    private Button bankcardbinding_btn;
    private EditText bankcardbinding_name;
    private EditText bankcardbinding_cardnumber;
    private EditText bankcardbinding_phone;
    private EditText bankcardbinding_dizhi;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bank_card_binding;
    }

    @Override
    protected void initView() {
        bankcardbinding_return = (ImageView) findViewById(R.id.bankcardbinding_return);
        //去绑定
        bankcardbinding_btn = (Button) findViewById(R.id.bankcardbinding_btn);
        bankcardbinding_btn.setOnClickListener(this);
        //持卡人
        bankcardbinding_name = (EditText) findViewById(R.id.bankcardbinding_name);
        //卡号
        bankcardbinding_cardnumber = (EditText) findViewById(R.id.bankcardbinding_cardnumber);
        BankCardTextWatcher.bind(bankcardbinding_cardnumber);
        //预留手机号
        bankcardbinding_phone = (EditText) findViewById(R.id.bankcardbinding_phone);
        //银行详细地址
        bankcardbinding_dizhi = (EditText) findViewById(R.id.bankcardbinding_dizhi);
        //开户行地区
        mSelector = (Button) findViewById(R.id.btn_selector);
        mShow = (TextView) findViewById(R.id.tv_show);
        cityPicker = new CityPicker(BankCardBindingActivity.this, this);
        mSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cityPicker.show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bankcardbinding_return:
                finish();
                break;
            //去绑定
            case R.id.bankcardbinding_btn:
                startActivity(new Intent(BankCardBindingActivity.this, BankCardSMSVerification.class));
                break;
        }
    }

    @Override
    public void getCity(String s) {
        mShow.setText(s);
    }

    @Override
    public void onBackPressed() {
        if (cityPicker.isShow()) {
            cityPicker.close();
            return;
        }
        super.onBackPressed();
    }
}
