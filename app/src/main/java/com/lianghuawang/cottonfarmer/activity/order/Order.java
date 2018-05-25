package com.lianghuawang.cottonfarmer.activity.order;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseFragment;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

public class Order extends BaseFragment {

    @Bind(R.id.sliding_tabss)
    TabLayout mSlidingTabLayout;

    @Bind(R.id.view_pagers)
    ViewPager mViewPager;

    private List<String> titles = Arrays.asList("全部",
            "待支付",
            "已付款",
            "待收货",
            "已完成",
            "已取消");

    private List<String> type = Arrays.asList(
            ConstantUtil.ALL,
            ConstantUtil.NON_PAYMENT,
            ConstantUtil.PAYMENT_HAS_BEEN,
            ConstantUtil.FOR_THE_GOODS,
            ConstantUtil.HAS_BEEN_COMPLETED,
            ConstantUtil.HAS_BEEN_CANCELLED
    );

    public static Order newInstance() {
        return new Order();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    public void initViews() {
        initData();
    }

    private void initData() {
        mViewPager.setAdapter(new OrderAdapter(getChildFragmentManager()));
        mViewPager.setOffscreenPageLimit(1);
        mSlidingTabLayout.setupWithViewPager(mViewPager);
    }

    private class OrderAdapter extends FragmentStatePagerAdapter {

        public OrderAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return OrderItemFragment.newInstance(type.get(position));
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
