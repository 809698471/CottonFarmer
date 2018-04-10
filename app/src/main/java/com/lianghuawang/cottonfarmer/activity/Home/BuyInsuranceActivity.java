package com.lianghuawang.cottonfarmer.activity.Home;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

//购买保险
public class BuyInsuranceActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;


    private List<String> titles = Arrays.asList("农业保险", "即将推出", "即将推出");

    private List<String> titleTags = Arrays.asList(
            ConstantUtil.AGRICULTURE,
            ConstantUtil.TAG1,
            ConstantUtil.TAG2);



    @Override
    protected int getLayoutId() {
        return R.layout.activity_buy_insurance;
    }

    @Override
    protected void initView() {
        initToolbar();
    }


    private void initToolbar() {
        mToolbar.setTitle("购买保险");
        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }
}
