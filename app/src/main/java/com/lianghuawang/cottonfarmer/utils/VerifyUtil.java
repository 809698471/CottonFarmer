package com.lianghuawang.cottonfarmer.utils;

import android.content.Context;

import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;

/**
 * create by fanwenke at 2018/7/3
 * 验证输入的信息是否为空
 */
public class VerifyUtil {

    public static boolean IsEmpty(Context context,String value, String message){
        if (value == null || value.isEmpty()){
            //为空
            ToastUtils.showLong(context,message);
            LogUtils.d(message);
            return false;
        }
        return true;
    }

}
