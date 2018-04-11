package com.lianghuawang.cottonfarmer.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.Find_tab_Adapter;
import com.lianghuawang.cottonfarmer.fragment.thebooks.AllTheBooksFragment;
import com.lianghuawang.cottonfarmer.fragment.thebooks.BookExpenditureFragment;
import com.lianghuawang.cottonfarmer.fragment.thebooks.BookIncomeFragment;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import java.util.ArrayList;

//我的账本
public class TheBooksActivity extends BaseActivity {


    private ViewPager vp_thebooks_pager;
    private AllTheBooksFragment allTheBooksFragment;
    private BookIncomeFragment bookIncomeFragment;
    private BookExpenditureFragment bookExpenditureFragment;
    private ArrayList<Fragment> list_fragment;
    private ArrayList<String> list_title;
    private TabLayout tab_thebooks_title;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_the_books;
    }

    @Override
    protected void initView() {
        tab_thebooks_title = (TabLayout) findViewById(R.id.tab_thebooks_title);
        vp_thebooks_pager = (ViewPager) findViewById(R.id.vp_thebooks_pager);
        //初始化各fragment
        allTheBooksFragment = new AllTheBooksFragment();
        bookIncomeFragment = new BookIncomeFragment();
        bookExpenditureFragment = new BookExpenditureFragment();
        //将fragment装进列表中
        list_fragment = new ArrayList<>();
        list_fragment.add(allTheBooksFragment);
        list_fragment.add(bookIncomeFragment);
        list_fragment.add(bookExpenditureFragment);
        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("全部");
        list_title.add("收入");
        list_title.add("支出");
        //设置TabLayout的模式
        tab_thebooks_title.setTabMode(TabLayout.MODE_FIXED);
        //为TabLayout添加tab名称
        tab_thebooks_title.addTab(tab_thebooks_title.newTab().setText(list_title.get(0)));
        tab_thebooks_title.addTab(tab_thebooks_title.newTab().setText(list_title.get(1)));
        tab_thebooks_title.addTab(tab_thebooks_title.newTab().setText(list_title.get(2)));

        Find_tab_Adapter find_tab_adapter = new Find_tab_Adapter(getSupportFragmentManager(), list_fragment, list_title);
        vp_thebooks_pager.setAdapter(find_tab_adapter);


    }
}
