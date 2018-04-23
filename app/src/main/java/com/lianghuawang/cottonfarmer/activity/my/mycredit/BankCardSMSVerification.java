package com.lianghuawang.cottonfarmer.activity.my.mycredit;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.tools.VerificationCodeView;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//银行卡绑定---短信验证
public class BankCardSMSVerification extends BaseActivity {

    private VerificationCodeView verificationcodeview;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bank_card_smsverification;
    }

    @Override
    protected void initView() {
        verificationcodeview = (VerificationCodeView) findViewById(R.id.verificationcodeview);
        verificationcodeview.setOnCodeFinishListener(new VerificationCodeView.OnCodeFinishListener() {
            //获取输入框的内容
            private String contents;

            @Override
            public void onComplete(String content) {
                contents = content;
            }
        });
    }
}