package com.lianghuawang.cottonfarmer.mvp.base;

/**
 * Created by 1 on 2018/2/5.
 */

public interface MvpListener<T> {
    void onSuccess(T result);
    void onError(String errorMsg);
}
