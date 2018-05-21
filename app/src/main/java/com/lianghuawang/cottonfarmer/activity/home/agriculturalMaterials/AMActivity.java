package com.lianghuawang.cottonfarmer.activity.home.agriculturalMaterials;

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
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
/**
 * 精选农资
 */

public class AMActivity extends BaseActivity {


    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTabLayout;

    @Bind(R.id.view_pager)
    ViewPager mViewPager;


    private List<String> titles = Arrays.asList("全部", "分类1", "分类2", "分类3", "分类4", "分类5", "分类6");

    private List<String> titleTags = Arrays.asList(
            ConstantUtil.AGRICLURAL,
            ConstantUtil.TAG3,
            ConstantUtil.TAG4,
            ConstantUtil.TAG5,
            ConstantUtil.TAG6,
            ConstantUtil.TAG7,
            ConstantUtil.TAG8
    );


    @Override
    protected int getLayoutId() {
        return R.layout.activity_am;
    }

    @Override
    protected void initView() {
        initToolbar();
        initData();
    }


    private void initData() {

        mViewPager.setAdapter(new AMPageAdapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(1);
        mSlidingTabLayout.setViewPager(mViewPager);
    }


    private void initToolbar() {
        mToolbar.setTitle("农资购买");
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

    private class AMPageAdapter extends FragmentStatePagerAdapter {

        public AMPageAdapter(FragmentManager fm) {

            super(fm);
        }


        @Override
        public Fragment getItem(int position) {

            return AMFragment.newInstance(titleTags.get(position));
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
}
