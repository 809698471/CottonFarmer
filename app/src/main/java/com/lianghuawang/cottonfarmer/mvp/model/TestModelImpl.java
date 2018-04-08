package com.lianghuawang.cottonfarmer.mvp.model;


import com.lianghuawang.cottonfarmer.mvp.base.MvpListener;
import com.lianghuawang.cottonfarmer.mvp.manager.MvpManager;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 韩学文 on 2018/4/2.
 */
//http://ali-weather.showapi.com/spot-to-weather?
public class TestModelImpl implements MvpManager.TestModel {
    @Override
    public void loadDaily(String url, final MvpListener<String> listener) {
        OkHttp3Utils instance = OkHttp3Utils.getInstance();
        instance.doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String s = e.toString();
                listener.onError(s);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                listener.onSuccess(string);
            }
        });
    }
}
