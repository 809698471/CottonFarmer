package com.lianghuawang.cottonfarmer.activity.my.mycredit;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.my.Card;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.tools.BankCardTextWatcher;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import me.leefeng.citypicker.CityPicker;
import me.leefeng.citypicker.CityPickerListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

//银行卡绑定
public class BankCardBindingActivity extends BaseActivity implements CityPickerListener {
    private CityPicker cityPicker;

    @Bind(R.id.bankcardbinding_return)
    ImageView back;

    @Bind(R.id.bankcardbinding_btn)
    Button bangding;

    @Bind(R.id.bankcardbinding_name)
    EditText name;

    @Bind(R.id.bankcardbinding_cardnumber)
    EditText card;

    @Bind(R.id.bankcardbinding_phone)
    EditText phone;

    @Bind(R.id.btn_selector)
    Button mSelector;

    @Bind(R.id.tv_show)
    TextView city;

    @Bind(R.id.bankcardbinding_dizhi)
    EditText dizhi;

    private String Token;
    private String citys;
    private String shi;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bank_card_binding;
    }

    @Override
    protected void initView() {
        Token = getIntent().getStringExtra(ConstantUtil.INTENTTOKEN);
        BankCardTextWatcher.bind(card);
        //银行详细地址
        //开户行地区
        cityPicker = new CityPicker(BankCardBindingActivity.this, this);
    }

    @OnClick({R.id.bankcardbinding_return, R.id.bankcardbinding_btn, R.id.btn_selector})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bankcardbinding_return:
                finish();
                break;
            //去绑定
            case R.id.bankcardbinding_btn:
                getKey();
                break;
            case R.id.btn_selector:
                cityPicker.show();
                break;
        }
    }

    @Override
    public void getCity(String s) {
        citys = "";
        shi = "";
        String[] names = s.split(" ");
        citys = names[0];
        shi = names[1];
        city.setText(s);
    }

    @Override
    public void onBackPressed() {
        if (cityPicker.isShow()) {
            cityPicker.close();
            return;
        }
        super.onBackPressed();
    }

    private void getKey() {
        final String name = this.name.getText().toString().trim();
        String card = this.card.getText().toString().trim();
        String cards[] = card.split(" ");
        card = "";
        for (String car : cards) {
            card = card + car;
        }
        final String phone = this.phone.getText().toString().trim();
        final String dizhi = this.dizhi.getText().toString().trim();
        Map<String, String> params = new HashMap<>();
        params.put("username", name);
        params.put("bank_card", card);
        params.put("mobile_phone", phone);

        final String finalCard = card;
        OkHttp3Utils.doPost(ConstantUtil.tokenKey, Token, Concat.VERIFICATIONOFBANKCARDINFORMATION_URL,
                params, new GsonObjectCallback<Card>() {
                    @Override
                    public void onUi(Card cardData) {
                        if (cardData.isSuccess()) {
                            ToastUtils.showLong(BankCardBindingActivity.this,"验证码已发送");
                            Intent intent = new Intent(BankCardBindingActivity.this, BankCardSMSVerification.class);
                            intent.putExtra(ConstantUtil.INTENTTOKEN,Token);
                            intent.putExtra("username", name);
                            intent.putExtra("bank_card", finalCard);
                            intent.putExtra("mobile_phone", phone);
                            intent.putExtra("verification_key", cardData.getData().getKey());
                            intent.putExtra("bank_province", citys);
                            intent.putExtra("bank_city", shi);
                            intent.putExtra("bank_address", dizhi);
                            startActivity(intent);
                        } else {
                            ToastUtils.showLong(BankCardBindingActivity.this, cardData.getData().getErrmsg());
                        }
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {

                    }
                });
    }
}
