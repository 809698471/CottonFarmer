package com.lianghuawang.cottonfarmer.activity.home.insurance;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import butterknife.Bind;

public class InsuranceOrderActivity extends BaseActivity{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_insurance_order;
    }

    @Override
    protected void initView() {
        initToolbar();
    }

    private void initToolbar() {
        mToolbar.setTitle("保险订单");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.back1);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
