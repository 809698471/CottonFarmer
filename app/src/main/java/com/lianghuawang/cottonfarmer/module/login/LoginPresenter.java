package com.lianghuawang.cottonfarmer.module.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.mvp.base.BasePresenter;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.utils.LoginUtils;


public class LoginPresenter extends BasePresenter<LoginModel, LoginView> {

    private final static int NUMBER = 50;
    private Handler handler;
    private int count_number = NUMBER;

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
        if (!LoginUtils.isEmpty_Passwrod(password)) {//验证密码不为空
            ToastUtils.showLong(context, context.getResources().getText(R.string.password_null));
            return;
        }

        startHttp();
    }

    /**
     * 请求登录接口
     */
    public void startHttp() {
        //模拟请求
        //请求成功
        getView().login();
    }

    @SuppressLint("HandlerLeak")
    public void captcha(final Context context) {
        final Times[] times = {new Times()};
        times[0].start();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                int i = msg.what;
                String message = i + "";
                if (i == -1) {
                    times[0] = null;
                    message = (String) context.getResources().getText(R.string.captcha);
                }
                getView().captcha(message);
            }
        };
    }

    class Times extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                if (count_number < 0) {
                    count_number = NUMBER;
                    return;
                }
                Message message = new Message();
                message.what = count_number;
                if (count_number == 0) {
                    message.what = -1;
                }
                LoginPresenter.this.handler.sendMessage(message);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count_number--;
            }
        }
    }
}
