package com.lianghuawang.cottonfarmer.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.home.HomePageFragment;
import com.lianghuawang.cottonfarmer.activity.my.MyFragment;
import com.lianghuawang.cottonfarmer.activity.message.NewsFragment;
import com.lianghuawang.cottonfarmer.activity.order.OrderFragment;

/**
 * 首页
 */
public class HomePageActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout fragment;
    private RadioButton rb_01;
    private RadioButton rb_02;
    private RadioButton rb_03;
    private RadioButton rb_04;
    private RadioGroup layout;
    private HomePageFragment homePageFragment;
    private NewsFragment newsFragment;
    private OrderFragment orderFragment;
    private MyFragment myFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        initView();

    }

    private void initView() {
        fragment = (FrameLayout) findViewById(R.id.fragment);
        rb_01 = (RadioButton) findViewById(R.id.rb_01);
        rb_02 = (RadioButton) findViewById(R.id.rb_02);
        rb_03 = (RadioButton) findViewById(R.id.rb_03);
        rb_04 = (RadioButton) findViewById(R.id.rb_04);
        layout = (RadioGroup) findViewById(R.id.layout);

        rb_01.setOnClickListener(this);
        rb_02.setOnClickListener(this);
        rb_03.setOnClickListener(this);
        rb_04.setOnClickListener(this);
        //动态添加Fragment ,获取Fragment 管理器
        FragmentManager msg = getSupportFragmentManager();
        //开启Fragment事物
        FragmentTransaction transaction = msg.beginTransaction();
        //方法2隐藏所有的Fragment。
        hideAll(transaction);
        if (homePageFragment == null) {
            homePageFragment = new HomePageFragment();
            transaction.add(R.id.fragment, homePageFragment);

        } else {
            transaction.show(homePageFragment);
        }
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        //动态添加Fragment ,获取Fragment 管理器
        FragmentManager msg = getSupportFragmentManager();
        //开启Fragment事物
        FragmentTransaction transaction = msg.beginTransaction();
        //方法2隐藏所有的Fragment。
        hideAll(transaction);
        switch (v.getId()) {
            case R.id.rb_01:
                if (homePageFragment == null) {
                    homePageFragment = new HomePageFragment();
                    transaction.add(R.id.fragment, homePageFragment);

                } else {
                    transaction.show(homePageFragment);
                }
                break;
            case R.id.rb_02:
                if (newsFragment == null) {
                    newsFragment = new NewsFragment();
                    transaction.add(R.id.fragment, newsFragment);

                } else {
                    transaction.show(newsFragment);
                }
                break;
            case R.id.rb_03:
                if (orderFragment == null) {
                    orderFragment = new OrderFragment();
                    transaction.add(R.id.fragment, orderFragment);

                } else {
                    transaction.show(orderFragment);
                }
                break;
            case R.id.rb_04:
                if (myFragment == null) {
                    myFragment = new MyFragment();
                    transaction.add(R.id.fragment, myFragment);

                } else {
                    transaction.show(myFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hideAll(FragmentTransaction transaction) {
        if (homePageFragment != null) {
            transaction.hide(homePageFragment);
        }
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        if (orderFragment != null) {
            transaction.hide(orderFragment);
        }
        if (myFragment != null) {
            transaction.hide(myFragment);
        }
    }
}
