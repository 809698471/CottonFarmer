package com.lianghuawang.cottonfarmer.activity.order;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.Find_tab_Adapter;
import com.lianghuawang.cottonfarmer.fragment.order.AlreadyPaidFragment;
import com.lianghuawang.cottonfarmer.fragment.order.CompletedFragment;
import com.lianghuawang.cottonfarmer.fragment.order.GoodsToBeReceivedFragment;
import com.lianghuawang.cottonfarmer.fragment.order.HaveBeenCancelledFragment;
import com.lianghuawang.cottonfarmer.fragment.order.PendingPaymentFragment;
import com.lianghuawang.cottonfarmer.fragment.order.WholeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单
 */
public class OrderFragment extends Fragment {
    private TabLayout tab_FindFragment_title; //定义TabLayout
    private ViewPager vp_FindFragment_pager; //定义viewPager
    private FragmentPagerAdapter fAdapter; //定义adapter
    private List<Fragment> list_fragment; //定义要装fragment的列表
    private List<String> list_title; //tab名称列表
    private WholeFragment wholeFragment;
    private PendingPaymentFragment pendingPaymentFragment;
    private AlreadyPaidFragment alreadyPaidFragment;
    private GoodsToBeReceivedFragment goodsToBeReceivedFragment;
    private CompletedFragment completedFragment;
    private HaveBeenCancelledFragment haveBeenCancelledFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.orderfragment, null);
        initControls(view);
        return view;
    }
    /**
     * 初始化各控件
     */
    private void initControls(View view) {
        tab_FindFragment_title = (TabLayout)view.findViewById(R.id.tab_FindFragment_title);
        vp_FindFragment_pager = (ViewPager)view.findViewById(R.id.vp_FindFragment_pager);
        //初始化各fragment
        wholeFragment = new WholeFragment();
        pendingPaymentFragment = new PendingPaymentFragment();
        alreadyPaidFragment = new AlreadyPaidFragment();
        goodsToBeReceivedFragment = new GoodsToBeReceivedFragment();
        completedFragment = new CompletedFragment();
        haveBeenCancelledFragment = new HaveBeenCancelledFragment();
        //将fragment装进列表中
        list_fragment = new ArrayList<>();
        list_fragment.add(wholeFragment);
        list_fragment.add(pendingPaymentFragment);
        list_fragment.add(alreadyPaidFragment);
        list_fragment.add(goodsToBeReceivedFragment);
        list_fragment.add(completedFragment);
        list_fragment.add(haveBeenCancelledFragment);

        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("全部");
        list_title.add("待付款");
        list_title.add("已付款");
        list_title.add("待收货");
        list_title.add("已完成");
        list_title.add("已取消");
        //设置TabLayout的模式
        tab_FindFragment_title.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(0)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(1)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(2)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(3)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(4)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(5)));
        fAdapter = new Find_tab_Adapter(getActivity().getSupportFragmentManager(),list_fragment,list_title);
        //viewpager加载adapter
        vp_FindFragment_pager.setAdapter(fAdapter);
        //tab_FindFragment_title.setViewPager(vp_FindFragment_pager);
        //TabLayout加载viewpager
        tab_FindFragment_title.setupWithViewPager(vp_FindFragment_pager);
        //tab_FindFragment_title.set
    }


}
