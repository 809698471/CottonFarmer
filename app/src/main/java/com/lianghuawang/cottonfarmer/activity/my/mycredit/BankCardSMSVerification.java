package com.lianghuawang.cottonfarmer.activity.my.mycredit;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.my.bankcard.BankCardActivity;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.my.CardYanZheng;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.tools.VerificationCodeView;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

//银行卡绑定---短信验证
public class BankCardSMSVerification extends BaseActivity {

    @Bind(R.id.bankcardsmsverification_return)
    ImageView bankcardsmsverification_return;

    @Bind(R.id.verificationcodeview)
    VerificationCodeView verificationcodeview;

    private String name;
    private String finalCard;
    private String phone;
    private String key;
    private String dizhi;
    private String Token;
    private String citys;
    private String shi;
    //获取输入框的内容
    private String contents;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_bank_card_smsverification;
    }

    @Override
    protected void initView() {

        Token = getIntent().getStringExtra(ConstantUtil.INTENTTOKEN);
        name = getIntent().getStringExtra("username");
        finalCard = getIntent().getStringExtra("bank_card");
        phone = getIntent().getStringExtra("mobile_phone");
        key = getIntent().getStringExtra("verification_key");
        citys = getIntent().getStringExtra("bank_province");
        shi = getIntent().getStringExtra("bank_city");
        dizhi = getIntent().getStringExtra("bank_address");
        verificationcodeview.setOnCodeFinishListener(new VerificationCodeView.OnCodeFinishListener() {

            @Override
            public void onComplete(String content) {
                contents = content;
            }
        });
    }

    @OnClick({R.id.bankcardsmsverification_return,R.id.bankcardbinding_btn})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.bankcardsmsverification_return:
                finish();
                break;
            case R.id.bankcardbinding_btn:
                getData();
                break;
        }

    }

    private void getData(){
        if (contents == null){
            contents = "1234";
        }
        Map<String,String> params = new HashMap<>();
        params.put("username", name);
        params.put("bank_card", finalCard);
        params.put("mobile_phone", phone);
        params.put("verification_key",key);
        params.put("verification_code",contents);
        params.put("bank_province",citys);
        params.put("bank_city",shi);
        params.put("bank_address",dizhi);

        OkHttp3Utils.doPat(ConstantUtil.tokenKey, Token, Concat.BINDINGBANKCARD_URL, params,
                new GsonObjectCallback<CardYanZheng>() {
                    @Override
                    public void onUi(CardYanZheng cardYanZheng) {
                        if (cardYanZheng.isSuccess()){
                            ToastUtils.showLong(BankCardSMSVerification.this,cardYanZheng.getData().getSuccessmsg());
                            startActivity(new Intent(BankCardSMSVerification.this, BankCardActivity.class));
                        } else {
                            ToastUtils.showLong(BankCardSMSVerification.this,cardYanZheng.getData().getErrmsg());
                        }
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {

                    }
                });

    }
}
