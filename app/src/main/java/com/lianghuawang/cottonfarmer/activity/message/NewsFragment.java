package com.lianghuawang.cottonfarmer.activity.message;


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
import com.lianghuawang.cottonfarmer.activity.message.news.BusinessFragment;
import com.lianghuawang.cottonfarmer.activity.message.news.FormulaFragment;
import com.lianghuawang.cottonfarmer.activity.message.news.LoanFragment;
import com.lianghuawang.cottonfarmer.activity.message.news.NewestFragment;
import com.lianghuawang.cottonfarmer.activity.message.news.OtherFragment;
import com.lianghuawang.cottonfarmer.activity.message.news.VoteFragment;
import com.lianghuawang.cottonfarmer.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

/**
 * 消息
 */
public class NewsFragment extends BaseFragment {

    @Bind(R.id.tab_news_title)
    TabLayout tab_news_title;

    @Bind(R.id.vp_news_pager)
    ViewPager vp_news_pager;

    private FragmentPagerAdapter fAdapter; //定义adapter
    private List<Fragment> list_fragment; //定义要装fragment的列表
    private NewestFragment newestFragment;
    private FormulaFragment formulaFragment;
    private VoteFragment voteFragment;
    private LoanFragment loanFragment;
    private BusinessFragment businessFragment;
    private OtherFragment otherFragment;

    private List<String> list_title = Arrays.asList(
            "最近",
            "保险",
            "合作社",
            "互助资金",
            "购物",
            "其他"
    ); //tab名称列表

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = View.inflate(getActivity(), R.layout.newsfragment, null);
//        initControls(view);
//        return view;
//    }

    @Override
    public int getLayoutId() {
        return R.layout.newsfragment;
    }

    @Override
    public void initViews() {
        initFragment();
        initControls();
    }

    private void initFragment() {
        list_fragment = Arrays.asList(
                new NewestFragment(),
                new FormulaFragment(),
                new VoteFragment(),
                new LoanFragment(),
                new BusinessFragment(),
                new OtherFragment()
        );
    }

    /**
     * 初始化各控件
     */
    private void initControls() {
        //初始化各fragment
//        newestFragment = new NewestFragment();
//        formulaFragment = new FormulaFragment();
//        voteFragment = new VoteFragment();
//        loanFragment = new LoanFragment();
//        businessFragment = new BusinessFragment();
//        otherFragment = new OtherFragment();
//        //将fragment装进列表中
//        list_fragment = new ArrayList<>();
//        list_fragment.add(newestFragment);
//        list_fragment.add(formulaFragment);
//        list_fragment.add(voteFragment);
//        list_fragment.add(loanFragment);
//        list_fragment.add(businessFragment);
//        list_fragment.add(otherFragment);

        //设置TabLayout的模式
//        tab_news_title.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tab_news_title.addTab(tab_news_title.newTab().setText(list_title.get(0)));
        tab_news_title.addTab(tab_news_title.newTab().setText(list_title.get(1)));
        tab_news_title.addTab(tab_news_title.newTab().setText(list_title.get(2)));
        tab_news_title.addTab(tab_news_title.newTab().setText(list_title.get(3)));
        tab_news_title.addTab(tab_news_title.newTab().setText(list_title.get(4)));
        tab_news_title.addTab(tab_news_title.newTab().setText(list_title.get(5)));
        fAdapter = new Find_tab_Adapter(getActivity().getSupportFragmentManager(), list_fragment, list_title);
        //viewpager加载adapter
        vp_news_pager.setAdapter(fAdapter);
        //tab_FindFragment_title.setViewPager(vp_FindFragment_pager);
        //TabLayout加载viewpager
        tab_news_title.setupWithViewPager(vp_news_pager);
        //tab_FindFragment_title.set
    }


}
