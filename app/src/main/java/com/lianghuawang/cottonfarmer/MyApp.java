package com.lianghuawang.cottonfarmer;

import android.app.Application;
import android.content.Context;

import com.lianghuawang.cottonfarmer.netutils.LogUtils;


/**
 * Created by 1 on 2018/2/4.
 */

public class MyApp extends Application {

    private static MyApp instance;
    private static Context mContext;

    public static MyApp getInstance() {
        return instance;
    }

    public static Context getContext(){
        return mContext;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mContext = this;
        LogUtils.isDebug = true;
      }
}
