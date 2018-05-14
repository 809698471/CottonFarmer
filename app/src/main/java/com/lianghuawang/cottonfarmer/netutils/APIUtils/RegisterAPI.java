package com.lianghuawang.cottonfarmer.netutils.APIUtils;

import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.instance.LoginInstance;

import java.util.HashMap;
import java.util.Map;

public class RegisterAPI extends BaseAPI {

    private Map<String, String> params;

    private static RegisterAPI newInstance() {
        return new RegisterAPI();
    }

    public static RegisterAPI Builder() {
        return newInstance();
    }

    public RegisterAPI setParams(Map<String, String> params) {
        if (params == null){
            this.params = new HashMap<>();
        } else {
            this.params = params;
        }
        return this;
    }

    public RegisterAPI request(GsonObjectCallback<LoginInstance> callback) {
        OkHttp3Utils.doPost(REGISTER_URL,params,callback);
        return this;
    }

    public void buidler() {
    }
}
