package com.lianghuawang.cottonfarmer;

import android.app.Application;
import android.content.Context;

import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.utils.SystemUtil;

import cn.jpush.android.api.JPushInterface;


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
        JPushInterface.init(this);
        //您可以在开发状态中启用调试模式。当释放时，应该关闭调试模式。
        JPushInterface.setDebugMode(true);
        LogUtils.isDebug = true;
      }
}
