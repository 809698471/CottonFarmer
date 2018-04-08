package com.lianghuawang.cottonfarmer.mvp.presenter;


import com.lianghuawang.cottonfarmer.mvp.base.MvpListener;
import com.lianghuawang.cottonfarmer.mvp.manager.MvpManager;

/**
 *
 */

public class TestPresenterImpl  extends MvpManager.TestPresenter {

    @Override
    public void loadData(String url ) {
           mModel.loadDaily(url,new MvpListener<String>() {
               @Override
               public void onSuccess(String result) {
                   MvpManager.TestView view = getView();
                   view.setData(result);
               }

               @Override
               public void onError(String errorMsg) {

               }
           });
    }
}
