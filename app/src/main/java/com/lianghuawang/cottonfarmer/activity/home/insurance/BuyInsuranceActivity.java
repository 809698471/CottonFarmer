package com.lianghuawang.cottonfarmer.activity.home.insurance;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.flyco.tablayout.SlidingTabLayout;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.ui.base.BaseFragment;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.MeasureUtil;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;
import com.lianghuawang.cottonfarmer.utils.ViewUtil;
import com.lianghuawang.cottonfarmer.widget.CornersTransform;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

//保险二级页面--保险列表
public class BuyInsuranceActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.sliding_tabs)
    TabLayout mSlidingTabLayout;

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Bind(R.id.iv_left)
    ImageView mLeft;

    @Bind(R.id.iv_right)
    ImageView mRight;

    private String Token;

//    private List<String> titles = Arrays.asList("农业保险", "信用保险", "其他");
    private List<String> titles = Arrays.asList("农业保险", "其他");

    private List<Integer> images = Arrays.asList(
            R.mipmap.insurance_zuo_img,
            R.mipmap.insurance_you_img);

    private List<BaseFragment> fragments;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_buy_insurance1;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            // 设置全屏，并且不会Activity的布局让出状态栏的空间
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            showStatusBar(this);
        }
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
    }

    // 显示状态栏
    public static void showStatusBar(Activity activity) {
        WindowManager.LayoutParams attrs = activity.getWindow().getAttributes();
        attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
        activity.getWindow().setAttributes(attrs);
    }

    @Override
    protected void initView() {
        Token = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP).getString(ConstantUtil.LOGINTOKEN,"");
        initToolbar();
        initFragment();
        initData();
    }

    private void initFragment() {
        fragments = Arrays.asList(
                (BaseFragment) AgricultureFragment.newInstance(Token),
//                (BaseFragment) CreditFragment.newInstance(Token),
                (BaseFragment) PriceFragment.newInstance(Token)
        );
    }

    private void initData() {

        mViewPager.setAdapter(new BuyInsurancePageAdapter(getSupportFragmentManager()));
//        mViewPager.setOffscreenPageLimit(1);
        mSlidingTabLayout.setupWithViewPager(mViewPager);
//        mSlidingTabLayout.setScrollPosition(0, 0, true);
//        // 根据Tab的长度动态设置TabLayout的模式
        ViewUtil.dynamicSetTabLayoutMode(mSlidingTabLayout);
    }

    private void initToolbar() {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            // 4.4设置全屏并动态修改Toolbar的位置实现类5.0效果，确保布局延伸到状态栏的效果
            ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) mToolbar.getLayoutParams();
            mlp.topMargin = MeasureUtil.getStatusBarHeight(this);
        }
        final CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolbarLayout.setTitle("保险业务");
        toolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.transparent));
        toolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.white));
        Glide.with(this).load(images.get(0)).transform(new CornersTransform(this, 50)).into(mLeft);
        Glide.with(this).load(images.get(1)).transform(new CornersTransform(this, 50)).into(mRight);

    }

    private class BuyInsurancePageAdapter extends FragmentStatePagerAdapter {

        public BuyInsurancePageAdapter(FragmentManager fm) {

            super(fm);
        }


        @Override
        public Fragment getItem(int position) {

            return fragments.get(position);
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
