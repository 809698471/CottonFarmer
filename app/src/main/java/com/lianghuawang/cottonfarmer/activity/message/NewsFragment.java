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
import com.lianghuawang.cottonfarmer.fragment.news.BusinessFragment;
import com.lianghuawang.cottonfarmer.fragment.news.FormulaFragment;
import com.lianghuawang.cottonfarmer.fragment.news.LoanFragment;
import com.lianghuawang.cottonfarmer.fragment.news.NewestFragment;
import com.lianghuawang.cottonfarmer.fragment.news.OtherFragment;
import com.lianghuawang.cottonfarmer.fragment.news.VoteFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息
 */
public class NewsFragment extends Fragment {
    private TabLayout tab_FindFragment_title; //定义TabLayout
    private ViewPager vp_FindFragment_pager; //定义viewPager
    private FragmentPagerAdapter fAdapter; //定义adapter
    private List<Fragment> list_fragment; //定义要装fragment的列表
    private List<String> list_title; //tab名称列表
    private NewestFragment newestFragment;
    private FormulaFragment formulaFragment;
    private VoteFragment voteFragment;
    private LoanFragment loanFragment;
    private BusinessFragment businessFragment;
    private OtherFragment otherFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.newfragment, null);
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
        newestFragment = new NewestFragment();
        formulaFragment = new FormulaFragment();
        voteFragment = new VoteFragment();
        loanFragment = new LoanFragment();
        businessFragment = new BusinessFragment();
        otherFragment = new OtherFragment();
        //将fragment装进列表中
        list_fragment = new ArrayList<>();
        list_fragment.add(newestFragment);
        list_fragment.add(formulaFragment);
       list_fragment.add(voteFragment);
        list_fragment.add(loanFragment);
       list_fragment.add(businessFragment);
        list_fragment.add(otherFragment);

        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("最新");
        list_title.add("公示");
        list_title.add("投票");
        list_title.add("贷款");
        list_title.add("买卖");
        list_title.add("其他");
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
