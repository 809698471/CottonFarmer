package com.lianghuawang.cottonfarmer.activity.my;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.netutils.GsonArrayCallback;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.netutils.instance.ExitLoginInstance;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.DialogUtil;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

//我的设置
public class SetUpActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.btn_login_back)
    Button back;

    private LinearLayout set_up_receivingaddress;
    private LinearLayout set_up_paymentpasswordsettings;
    private LinearLayout set_up_help;
    private ImageView setup_return;

    private SharedPreferencesUtil loginSP;
    private String Token;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_up;
    }

    @Override
    protected void initView() {
        loginSP = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP);
        Token = loginSP.getString(ConstantUtil.LOGINTOKEN,"");
        setup_return = (ImageView) findViewById(R.id.setup_return);
        //收货地址
        set_up_receivingaddress = (LinearLayout) findViewById(R.id.set_up_receivingaddress);
        //支付密码设置
        set_up_paymentpasswordsettings = (LinearLayout) findViewById(R.id.set_up_paymentpasswordsettings);
        //帮助
        set_up_help = (LinearLayout) findViewById(R.id.set_up_help);
        setup_return.setOnClickListener(this);
        set_up_receivingaddress.setOnClickListener(this);
        set_up_paymentpasswordsettings.setOnClickListener(this);
        set_up_help.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setup_return:
                finish();
                break;
            //收货地址
            case R.id.set_up_receivingaddress:
                startActivity(new Intent(SetUpActivity.this,ReceivingAddressActivity.class));
                break;
            //支付密码设置
            case R.id.set_up_paymentpasswordsettings:
                startActivity(new Intent(SetUpActivity.this,PaymentPasswordSettingsActivity.class));

                break;
            //帮助
            case R.id.set_up_help:
                startActivity(new Intent(SetUpActivity.this,HelpActivity.class));

                break;
        }
    }

    @OnClick(R.id.btn_login_back)
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.btn_login_back:
//                DialogUtil.VerifyDialog(SetUpActivity.this,"确定");
                Map<String,String> params = new HashMap<>();
                OkHttp3Utils.doPost(ConstantUtil.tokenKey, Token, Concat.EXIT_LOGIN,
                        params, new GsonObjectCallback<ExitLoginInstance>() {
                            @Override
                            public void onUi(ExitLoginInstance exitLoginInstance) {
                                if (exitLoginInstance.isSuccess()){
                                    ToastUtils.showLong(SetUpActivity.this,exitLoginInstance.getData().getSuccessmsg());
                                    loginSP.putBoolean(ConstantUtil.LOGINSTATE,false);
                                    SetUpActivity.this.finish();
                                }
                            }

                            @Override
                            public void onFailed(Call call, IOException e) {

                            }
                        });
                break;
        }
    }
}
