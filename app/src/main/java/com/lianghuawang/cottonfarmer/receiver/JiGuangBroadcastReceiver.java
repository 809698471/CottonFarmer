package com.lianghuawang.cottonfarmer.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import cn.jpush.android.service.PushService;

public class JiGuangBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("aaaaa","广播");
        Intent pushintent=new Intent(context,PushService.class);//启动极光推送的服务
        context.startService(pushintent);
    }
}
