package com.lianghuawang.cottonfarmer.utils;

import android.content.Context;
import android.widget.Toast;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;

public class LoginUtils {

    public static boolean IsEmpty(Context context,String username, String password){
        if (username != null && !username.isEmpty()){
            if (!PhoneNumberValidation.isMobile(username)){
                Toast.makeText(context,context.getResources().getText(R.string.phone_illegal),Toast.LENGTH_LONG).show();
                return false;
            } else if (password == null || password.isEmpty()){
                Toast.makeText(context,context.getResources().getText(R.string.password_null),Toast.LENGTH_LONG).show();
                return false;
            }
            return true;
        } else {
            Toast.makeText(context,context.getResources().getString(R.string.username_null),Toast.LENGTH_LONG).show();
            return false;
        }
    }

    /**
     * 验证用户名是否为空
     * @param username
     * @return
     */
    public static boolean IsEmpty_Username(String username){
        if (username == null || username.isEmpty()){
            return false;
        }
        return true;
    }

    /**
     * 验证密码是否为空
     * @param password
     * @return
     */
    public static boolean IsEmpty_Passwrod(String password){
        if (password == null || password.isEmpty()){
            return false;
        }
        return true;
    }

    /**
     * 验证手机号合法性
     * @param username
     * @return
     */
    public static boolean isMobile(String username){

        return PhoneNumberValidation.isMobile(username);
    }
}
