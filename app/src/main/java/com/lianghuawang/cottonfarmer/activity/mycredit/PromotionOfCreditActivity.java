package com.lianghuawang.cottonfarmer.activity.mycredit;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.mycredit.activity.AuthenticationActivity;
import com.lianghuawang.cottonfarmer.activity.mycredit.activity.BankCardBindingActivity;
import com.lianghuawang.cottonfarmer.activity.personalinformation.PersonalInformationActivity;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

//提升信用
public class PromotionOfCreditActivity extends BaseActivity implements View.OnClickListener {


    private LinearLayout promotionofcredit_perfect;
    private LinearLayout promotionofcredit_authentication;
    private LinearLayout promotionofcredit_bankcardbinding;
    private LinearLayout promotionofcredit_invitingtheunderwriter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_promotion_of_credit;
    }

    @Override
    protected void initView() {
        //完善个人信息
        promotionofcredit_perfect = (LinearLayout) findViewById(R.id.promotionofcredit_perfect);
        //身份证验证
        promotionofcredit_authentication = (LinearLayout) findViewById(R.id.promotionofcredit_authentication);
        //银行卡绑定
        promotionofcredit_bankcardbinding = (LinearLayout) findViewById(R.id.promotionofcredit_bankcardbinding);
        //邀请承保人
        promotionofcredit_invitingtheunderwriter = (LinearLayout) findViewById(R.id.promotionofcredit_invitingtheunderwriter);

        promotionofcredit_perfect.setOnClickListener(this);
        promotionofcredit_authentication.setOnClickListener(this);
        promotionofcredit_bankcardbinding.setOnClickListener(this);
        promotionofcredit_invitingtheunderwriter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //完善个人信息
            case R.id.promotionofcredit_perfect:
                startActivity(new Intent(PromotionOfCreditActivity.this,PersonalInformationActivity.class));
                break;
            //身份证验证
            case R.id.promotionofcredit_authentication:
                startActivity(new Intent(PromotionOfCreditActivity.this,AuthenticationActivity.class));

                break;
            //银行卡绑定
            case R.id.promotionofcredit_bankcardbinding:
                startActivity(new Intent(PromotionOfCreditActivity.this,BankCardBindingActivity.class));

                break;
            //邀请承保人
            case R.id.promotionofcredit_invitingtheunderwriter:
                break;
        }
    }
}
