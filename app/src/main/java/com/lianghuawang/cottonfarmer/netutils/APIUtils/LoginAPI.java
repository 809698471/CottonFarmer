package com.lianghuawang.cottonfarmer.netutils.APIUtils;

import com.lianghuawang.cottonfarmer.entity.home.insurance.Test;
import com.lianghuawang.cottonfarmer.netutils.GsonArrayCallback;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.instance.LoginInstance;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

/**
 * 登录接口
 */
public class LoginAPI extends BaseAPI{

    private Map<String,String> map;

    private static LoginAPI newInstace(){
        return new LoginAPI();
    }

    public static LoginAPI Buidler(){
        return newInstace();
    }

    public LoginAPI setParams(Map<String,String> map){
        if (map == null){
            this.map = new HashMap<>();
        } else {
            this.map = map;
        }

        return this;
    }

    public LoginAPI request(GsonObjectCallback<LoginInstance> callback){
        OkHttp3Utils.doPost(SIGNIN_URL, map, callback);
        return this;
    }

    public void builder(){}
}
