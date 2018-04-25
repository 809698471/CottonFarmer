package com.lianghuawang.cottonfarmer.mvp.module.login;

import com.lianghuawang.cottonfarmer.mvp.base.BaseView;

public interface LoginView extends BaseView {

    void login();

    void captcha(String message);
}
