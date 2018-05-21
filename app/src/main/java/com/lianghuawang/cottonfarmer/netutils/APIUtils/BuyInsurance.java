package com.lianghuawang.cottonfarmer.netutils.APIUtils;

import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;

public class BuyInsurance extends BaseAPI {

    private int mPage = 1;

    private Map<String,String> mParams;

    private BuyInsurance(){

        SP = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP);
    }

    private static BuyInsurance newInstance(){
        return new BuyInsurance();
    }

    public static BuyInsurance Builder(){
        return newInstance();
    }

    public BuyInsurance setPage(){
        return this;
    }

    public BuyInsurance setPage(int page){
        this.mPage = page;
        return this;
    }

    public BuyInsurance setParams(Map<String,String> params){
        this.mParams = params;
        return this;
    }

    public BuyInsurance request(){
        OkHttp3Utils.doGet(SP.getString(ConstantUtil.LOGINTOKEN,""), PRODUCTLIST_URL2 + mPage, new GsonObjectCallback<Object>() {
            @Override
            public void onUi(Object buyInsurances) {

            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
        return this;
    }

    public void builder(){

    }
}
