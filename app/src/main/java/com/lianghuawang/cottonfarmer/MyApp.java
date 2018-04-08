package com.lianghuawang.cottonfarmer;

import android.app.Application;

import com.lianghuawang.cottonfarmer.netutils.LogUtils;


/**
 * Created by 1 on 2018/2/4.
 */

public class MyApp extends Application {

    private static MyApp instance;

    public static MyApp getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        LogUtils.isDebug = true;
      }
}
