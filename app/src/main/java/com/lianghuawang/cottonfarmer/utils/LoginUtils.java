package com.lianghuawang.cottonfarmer.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.lianghuawang.cottonfarmer.mvp.module.login.LoginActivity;

/**
 * 登录／注册工具
 */
public class LoginUtils {
    /**
     * 验证用户名是否为空
     *
     * @param username
     * @return
     */
    public static boolean isEmpty_Username(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * 验证密码是否为空
     *
     * @param password
     * @return
     */
    public static boolean isEmpty_Passwrod(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * 验证手机号合法性
     *
     * @param username
     * @return
     */
    public static boolean isMobile(String username) {

        return PhoneNumberValidation.isMobile(username);
    }

    /**
     * 验证是否已登录
     */
    public static void StartActivity(Activity context, Class<?> clas,int code, int resultCode){
        SharedPreferencesUtil sp = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP);
        boolean login = sp.getBoolean(ConstantUtil.LOGINSTATE,false);
        Intent intent = null;
        if (login){
            intent = new Intent(context,clas);
        } else {
            intent = new Intent(context, LoginActivity.class);
            intent.putExtra("resultCode", resultCode);
        }
        context.startActivityForResult(intent,code);

    }
}
