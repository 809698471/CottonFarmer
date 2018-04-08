package com.lianghuawang.cottonfarmer.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lianghuawang.cottonfarmer.mvp.base.BaseView;


/**
 *
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();


}
//测试提交  -杨瑞杰