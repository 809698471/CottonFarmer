package com.lianghuawang.cottonfarmer.activity.my.mycredit;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.mvp.manager.MvpManager;
import com.lianghuawang.cottonfarmer.mvp.model.TestModelImpl;
import com.lianghuawang.cottonfarmer.mvp.presenter.TestPresenterImpl;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.ui.base.BaseMVPACtivity;

//身份证验证
public class AuthenticationActivity extends BaseMVPACtivity<TestPresenterImpl, TestModelImpl> implements MvpManager.TestView {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_authentication;

    }

    @Override
    protected void initView() {

    }

    @Override
    public void setData(final String verifyBean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                LogUtils.e("",verifyBean);
            }
        });

    }

    @Override
    protected void loadData() {
        mPresenter.loadData("http://gwook.com:82/cotton/web/v1/areas/get-area?parent_id=0");
    }
}
