package com.lianghuawang.cottonfarmer.utils;

import android.os.Build;

/**
 * 系统工具
 */
public class SystemUtil {

    public static String getSystemModel(){
        return Build.MODEL;
    }

    public static String getBrand(){
        return Build.BRAND;
    }

}
