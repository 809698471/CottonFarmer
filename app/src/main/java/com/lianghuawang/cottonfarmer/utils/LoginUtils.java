package com.lianghuawang.cottonfarmer.utils;

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
}
