package com.lianghuawang.cottonfarmer.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lianghuawang.cottonfarmer.mvp.base.BaseModel;
import com.lianghuawang.cottonfarmer.mvp.base.BasePresenter;
import com.lianghuawang.cottonfarmer.utils.ReflectUtil;


/**
 * Created by 1 on 2018/2/4.
 */

public abstract class BaseMVPACtivity <T extends BasePresenter, M extends BaseModel> extends BaseActivity {
    protected T mPresenter;
    protected M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter  = ReflectUtil.getT(this, 0);
        mModel = ReflectUtil.getT(this, 1);
        mPresenter.onAttach(mModel, this);
        loadData();
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    protected abstract void loadData();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }
}
