package com.lianghuawang.cottonfarmer.netutils.APIUtils;

import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 验证码接口
 */
public class VerificationAPI extends BaseAPI {

    private Map<String,String> params;

    private static VerificationAPI getIntance(){
        return new VerificationAPI();
    }

    public static VerificationAPI Builder(){
       return getIntance();
    }

    public VerificationAPI setParams(Map<String,String> map){
        if (map == null){
            params = new HashMap<>();
        } else {
            params = map;
        }
        return this;
    }

    public VerificationAPI request(GsonObjectCallback object){
        OkHttp3Utils.doPost(VERIFICATIONCODE_URL, params, object);
        return this;
    }

    public void builder(){

    }
}
