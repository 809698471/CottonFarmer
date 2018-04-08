package com.lianghuawang.cottonfarmer.mvp.manager;


import com.lianghuawang.cottonfarmer.mvp.base.BaseModel;
import com.lianghuawang.cottonfarmer.mvp.base.BasePresenter;
import com.lianghuawang.cottonfarmer.mvp.base.BaseView;
import com.lianghuawang.cottonfarmer.mvp.base.MvpListener;

/**
 *
 */

public interface MvpManager {
    /**
     * 测试
     */
    interface TestModel extends BaseModel {
        void loadDaily(String url, MvpListener<String> listener);
    }

    interface TestView extends BaseView {
        void setData(String verifyBean);
    }

    abstract class TestPresenter extends BasePresenter<TestModel, TestView> {
        public abstract void loadData(String url);
    }
}
