package com.lianghuawang.cottonfarmer.activity.home;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public class WeatherActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_weather;
    }

    @Override
    protected void initView() {
        //静态栏--黑色字体
        QMUIStatusBarHelper.setStatusBarLightMode(this);

    }
}
