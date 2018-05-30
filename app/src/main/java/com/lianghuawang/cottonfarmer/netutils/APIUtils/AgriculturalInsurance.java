package com.lianghuawang.cottonfarmer.netutils.APIUtils;

import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.netutils.instance.AgriculturalInsurances;
import com.lianghuawang.cottonfarmer.netutils.listener.APIListener;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;

/**
 * 农业保险
 */
public class AgriculturalInsurance extends BaseAPI {

    private int mPage = 1;

    private Map<String,String> mParams;

    private APIListener listener;

    private AgriculturalInsurance(){

        SP = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP);
    }

    private static AgriculturalInsurance newInstance(){
        return new AgriculturalInsurance();
    }

    public static AgriculturalInsurance Builder(){
        return newInstance();
    }

    public AgriculturalInsurance setPage(){
        return this;
    }

    public AgriculturalInsurance setPage(int page){
        this.mPage = page;
        return this;
    }

    public AgriculturalInsurance setListener(APIListener listener){
        this.listener = listener;
        return this;
    }

    public AgriculturalInsurance request(){
        OkHttp3Utils.doGet(ConstantUtil.tokenKey,SP.getString(ConstantUtil.LOGINTOKEN,""), PRODUCTLIST_URL2 + mPage, new GsonObjectCallback<AgriculturalInsurances>() {
            @Override
            public void onUi(AgriculturalInsurances buyInsurances) {
                if (buyInsurances.isSuccess()) {
                    for (AgriculturalInsurances.DataBean bean : buyInsurances.getData()){
                        String Image = bean.getImage_url();
                        bean.setImage_url(IMAGE_URL + "/" + Image);
                    }
                    listener.onSuccess(buyInsurances.getData());
                } else {
                    listener.onError(buyInsurances.getMessage());
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {
                    listener.onError("请求失败");
            }
        });
        return this;
    }

    public void builder(){

    }
}
