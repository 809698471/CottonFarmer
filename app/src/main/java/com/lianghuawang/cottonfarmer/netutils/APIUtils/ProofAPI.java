package com.lianghuawang.cottonfarmer.netutils.APIUtils;

import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.instance.ProofInstance;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;

/**
 * 获取权属证明API
 */
public class ProofAPI extends BaseAPI {

    private String key;
    private String token;

    private ProofAPI(){
        SP = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP);
    }

    public static ProofAPI newInastance(){
        return new ProofAPI();
    }

    public ProofAPI getToken(){
        this.key = ConstantUtil.tokenKey;
        this.token = SP.getString(ConstantUtil.LOGINTOKEN,"");
        return this;
    }

    public void request(GsonObjectCallback<ProofInstance> callback){
        OkHttp3Utils.doGet(this.key,this.token,PROOFLIST_URL,callback);
    }

}
