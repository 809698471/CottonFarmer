package com.lianghuawang.cottonfarmer.mvp.module.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;

import com.lianghuawang.cottonfarmer.MyApp;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.mvp.base.BasePresenter;
import com.lianghuawang.cottonfarmer.netutils.APIUtils.LoginAPI;
import com.lianghuawang.cottonfarmer.netutils.APIUtils.VerificationAPI;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.netutils.instance.LoginInstance;
import com.lianghuawang.cottonfarmer.netutils.instance.VerficationInstance;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.LoginUtils;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;
import com.lianghuawang.cottonfarmer.utils.TimekeeperUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;


public class LoginPresenter extends BasePresenter<LoginModel, LoginView> {

    private final static int NUMBER = 10;
    private int count_number = NUMBER;
    private TimekeeperUtil timekeeperUtil;
    private String getKey;
    private Button button;
    private SharedPreferencesUtil sp = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP);
    /**
     * 登录验证
     *
     * @param context
     * @param usename
     * @param password
     */
    public void startlogin(Context context, String usename, String password) {

        if (!LoginUtils.isEmpty_Username(usename)) {//验证用户名不为空
            ToastUtils.showLong(context, context.getResources().getText(R.string.username_null));
            return;
        }
        if (!LoginUtils.isMobile(usename)) {//验证用户名合法性
            ToastUtils.showLong(context, context.getResources().getText(R.string.phone_illegal));
            return;
        }
        if (!LoginUtils.isEmpty_Passwrod(password)) {//验证验证码不为空
            ToastUtils.showLong(context, context.getResources().getText(R.string.password_null));
            return;
        }
        Map<String, String> params = new HashMap<>();
        params.put("mobile_phone", usename);
        if (getKey == null) {
            params.put("verification_key", "");
        } else {
            params.put("verification_key", getKey);
        }
        params.put("verification_code", password);
        startHttp(context, params);
    }

    /**
     * 请求登录接口
     *
     * @param context
     * @param params
     */
    public void startHttp(final Context context, Map<String, String> params) {
        LoginAPI.Buidler()
                .setParams(params)
                .request(new GsonObjectCallback<LoginInstance>() {
                    @Override
                    public void onUi(LoginInstance loginInstance) {
                        if (loginInstance.isSuccess()) {
                            //请求成功
                            sp.putString(ConstantUtil.LOGINTOKEN, "Bearer " + loginInstance.getData().getAccess_token());
                            sp.putBoolean(ConstantUtil.LOGINSTATE, true);
                            LogUtils.d("Token:--- " + "Bearer " + loginInstance.getData().getAccess_token());
                            getView().login();
                        } else {
                            ToastUtils.showLong(context, loginInstance.getData().getErrmsg());
                        }
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {
                        ToastUtils.showLong(context, e.getMessage());
                    }
                })
                .builder();
    }


    public void captcha(Button mCaptcha, String phoneNumber) {
        timekeeperUtil = new TimekeeperUtil(handler, NUMBER, count_number);
        timekeeperUtil.start();
        button = mCaptcha;
        button.setEnabled(false);
        verification(phoneNumber);
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int i = msg.what;
            String message = i + "";
            if (i == -1) {
                timekeeperUtil = null;
                message = (String) MyApp.getInstance().getText(R.string.captcha);
                button.setEnabled(true);
            }
            if (getView() == null) {
                LogUtils.d("getView为null");
            } else {
                getView().captcha(message);
            }
        }
    };


    private void verification(String phoneNumber) {
        Map<String, String> params = new HashMap<>();
        params.put("mobile_phone", phoneNumber);
        VerificationAPI.Builder()
                .setParams(params)
                .request(new GsonObjectCallback<VerficationInstance>() {
                    @Override
                    public void onUi(VerficationInstance verficationInstance) {
                        LogUtils.d("验证码为：" + verficationInstance.getData().getKey());
                        getKey = verficationInstance.getData().getKey();
                        LogUtils.d(verficationInstance.toString());
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {
                        LogUtils.d("获取验证码失败");
                        LogUtils.d("失败原因：" + e.getMessage());
                    }
                })
                .builder();
    }
}
