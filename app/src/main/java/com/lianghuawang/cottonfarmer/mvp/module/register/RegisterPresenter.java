package com.lianghuawang.cottonfarmer.mvp.module.register;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;

import com.lianghuawang.cottonfarmer.MyApp;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.mvp.base.BasePresenter;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.utils.LoginUtils;
import com.lianghuawang.cottonfarmer.utils.TimekeeperUtil;

public class RegisterPresenter extends BasePresenter<RegisterModel,RegisterView> {

    private final static int NUMBER = 5;
    private int count_number = NUMBER;
    private TimekeeperUtil timekeeperUtil;
    private Button button;

    public void startRegister(Context context, String usename, String password) {
        if (!LoginUtils.isEmpty_Username(usename)) {//验证用户名不为空
            ToastUtils.showLong(context, context.getResources().getText(R.string.username_null));
            return;
        }
        if (!LoginUtils.isMobile(usename)) {//验证用户名合法性
            ToastUtils.showLong(context, context.getResources().getText(R.string.phone_illegal));
            return;
        }
        if (!LoginUtils.isEmpty_Passwrod(password)) {//验证密码不为空
            ToastUtils.showLong(context, context.getResources().getText(R.string.password_null));
            return;
        }

        startHttp();
    }

    /**
     * 请求注册接口
     */
    public void startHttp() {
        //模拟请求
        //请求成功
        getView().register();
    }

    public void captcha(Button mCaptcha) {
        timekeeperUtil = new TimekeeperUtil(handler,NUMBER,count_number);
        timekeeperUtil.start();
        button = mCaptcha;
        button.setEnabled(false);
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
            getView().captcha(message);
        }
    };
}
