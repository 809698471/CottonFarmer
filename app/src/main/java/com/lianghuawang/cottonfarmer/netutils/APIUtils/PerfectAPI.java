package com.lianghuawang.cottonfarmer.netutils.APIUtils;

import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.instance.Perfect_Receive_Information;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;

import java.util.Map;

/**
 * 完善信息接口
 */
public class PerfectAPI extends BaseAPI{

    private String key;
    private String token;
    private Map<String,String> params;

    public static  PerfectAPI newInstance(){
        return new PerfectAPI();
    }

    private PerfectAPI(){
        SP = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP);
    }

    public PerfectAPI getToken(){
        this.key = ConstantUtil.tokenKey;
        this.token = SP.getString(ConstantUtil.LOGINTOKEN,"");
        return this;
    }

    public PerfectAPI getParams(Map<String,String> params){
        this.params = params;
        return this;
    }

    public PerfectAPI requestPat(GsonObjectCallback<Perfect_Receive_Information> callback){
        OkHttp3Utils.doPat(this.key,this.token,IMPROVINGBASICINFORMATION_URL,this.params,callback);
        return this;
    }

    public PerfectAPI requestGet(GsonObjectCallback<Perfect_Receive_Information> callback){
        OkHttp3Utils.doGet(this.key,this.token,PERSONALDETAILS_URL,callback);
        return this;
    }


    public void over(){
        return;
    }

}
