package com.lianghuawang.cottonfarmer.activity.home.insurance;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.entity.home.insurance.Test;
import com.lianghuawang.cottonfarmer.netutils.APIUtils.LoginAPI;
import com.lianghuawang.cottonfarmer.netutils.APIUtils.VerificationAPI;
import com.lianghuawang.cottonfarmer.netutils.GsonArrayCallback;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import okhttp3.Call;

//购买保险
public class BuyInsuranceActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTabLayout;

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

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
        initData();
//        http();
//        getPost();
//        upPost();
    }

    private void http() {
        OkHttp3Utils.doGet("EuLUEwkkOECfeeUH1RC9otgReROf1lax",
                "http://gwook.com:82/cotton/web/v1/products",
                new GsonObjectCallback<Test>() {

                    @Override
                    public void onUi(Test test) {
                        if (test == null){
                            LogUtils.d("list == null");
                            return;
                        }
//                        if (test.getData().size() == 0){
//                            LogUtils.d("list.size() == 0");
//                            return;
//                        }
                        LogUtils.d(test.toString());
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {
                        LogUtils.d("请求失败---" + call.toString());
                        LogUtils.d("请求失败---" + e.getMessage());

                    }
                });
    }

    private void getPost(){

        Map<String, String> params = new HashMap<>();
//        params.put("insStatus","1");
        params.put("image","");

        OkHttp3Utils.doPost("EuLUEwkkOECfeeUH1RC9otgReROf1lax",
                "http://gwook.com:82/cotton/web/v1/cotton-farmers/upload-image",
                params,
                new GsonObjectCallback<Test>() {
                    @Override
                    public void onUi(Test test) {
                        LogUtils.d(test.toString());
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {
                        LogUtils.d("call--" + call.toString());
                        LogUtils.d("e--" + e.getMessage());
                    }
                });
    }

    private void upPost(){
        Map<String, Object> params = new HashMap<>();
//        params.put("insStatus","1");
        params.put("image","");
        OkHttp3Utils.uploadPic(ConstantUtil.TOKEN,
                this,
                "http://gwook.com:82/cotton/web/v1/cotton-farmers/upload-image",
                params);
    }

    private void initData() {

        mViewPager.setAdapter(new BuyInsurancePageAdapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(1);
        mSlidingTabLayout.setViewPager(mViewPager);
    }


    private void initToolbar() {
        mToolbar.setTitle("购买保险");
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

    private class BuyInsurancePageAdapter extends FragmentStatePagerAdapter {

        public BuyInsurancePageAdapter(FragmentManager fm) {

            super(fm);
        }


        @Override
        public Fragment getItem(int position) {

            return AgricultureFragment.newInstance(titleTags.get(position));
        }


        @Override
        public CharSequence getPageTitle(int position) {

            return titles.get(position);
        }


        @Override
        public int getCount() {

            return titles.size();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
