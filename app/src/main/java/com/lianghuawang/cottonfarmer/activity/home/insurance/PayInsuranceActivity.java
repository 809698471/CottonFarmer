package com.lianghuawang.cottonfarmer.activity.home.insurance;

import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.widget.pay.PayDialog;

public class PayInsuranceActivity extends BaseActivity implements PayDialog.PayInterface {

    private PayDialog payDialog;
    boolean status = false;//替代方案，这里没有做网络请求，所以定义一个boolean字段来判断正确还是失败

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pay_insurance;
    }

    @Override
    protected void initView() {
        if (payDialog == null) {
            status = true;
            payDialog = new PayDialog(PayInsuranceActivity.this, "支付金额：80元", PayInsuranceActivity.this);//设置progress的颜色
            payDialog.setColorId(ContextCompat.getColor(this, R.color.green));
            payDialog.show();

        }
    }

    @Override
    public void Payfinish(String password) {
        //这里是当用户输入密码完成时 得到输入密码的回调方法
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //这里是做请求校验的，暂时用停留2秒做假请求
                if (status) {
                    //请求成功
                    payDialog.setSucc();
                } else {
                    //请求失败 传入失败理由
                    payDialog.setError("支付密码不正确");
                }

            }
        }, 2000);
    }

    @Override
    public void onSucc() {
        payDialog.cancel();
    }

    @Override
    public void onForget() {
//当progress显示时，说明在请求网络，这时点击忘记密码不作处理
        if (payDialog.payPassView.progress.getVisibility() != View.VISIBLE) {
            Toast.makeText(PayInsuranceActivity.this, "去找回密码", Toast.LENGTH_SHORT).show();
        }
    }
}
