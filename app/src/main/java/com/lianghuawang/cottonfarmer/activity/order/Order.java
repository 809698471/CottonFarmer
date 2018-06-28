package com.lianghuawang.cottonfarmer.activity.order;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.oder.OrderAll;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.ui.base.BaseFragment;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import okhttp3.Call;

public class Order extends BaseFragment {

    @Bind(R.id.sliding_tabss)
    TabLayout mSlidingTabLayout;

    @Bind(R.id.view_pagers)
    ViewPager mViewPager;

    private List<String> titles = Arrays.asList("全部",
            "待支付",
            "已付款",
            "已完成");

    private List<Integer> type = Arrays.asList(
            ConstantUtil.ALL,
            ConstantUtil.NON_PAYMENT,
            ConstantUtil.PAYMENT_HAS_BEEN,
            ConstantUtil.HAS_BEEN_COMPLETED
    );

    private SharedPreferencesUtil LoginSP;
    private String Token;
    private List<OrderAll.DataBean> dataBeans;
    public static Order newInstance() {
        return new Order();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    public void initViews() {
        LoginSP = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP);
        Token = LoginSP.getString(ConstantUtil.LOGINTOKEN,"");
        initData();
    }

    private void initData() {
        OkHttp3Utils.doGet(ConstantUtil.tokenKey, Token, Concat.ORDERLIST_URL, new GsonObjectCallback<OrderAll>() {
            @Override
            public void onUi(OrderAll orderAll) {
                if (orderAll.isSuccess()){
                    dataBeans = orderAll.getData();
                    initView();
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }

    private void initView() {
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
            return OrderItemFragment.newInstance(type.get(position),dataBeans);
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
