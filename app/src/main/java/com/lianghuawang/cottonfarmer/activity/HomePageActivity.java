package com.lianghuawang.cottonfarmer.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.home.HomePageFragment;
import com.lianghuawang.cottonfarmer.activity.message.NewsFragment;
import com.lianghuawang.cottonfarmer.activity.my.MyFragment;
import com.lianghuawang.cottonfarmer.activity.order.Order;
import com.lianghuawang.cottonfarmer.activity.order.OrderFragment;
import com.lianghuawang.cottonfarmer.tools.MessageEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 */
public class HomePageActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private FrameLayout fragment;
    private RadioButton rb_01;
    private RadioButton rb_02;
    private RadioButton rb_03;
    private RadioButton rb_04;
    private RadioGroup layout;
    private FragmentManager msg;

    private RadioButton[] rbArray;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private int conut = 0;
    private List<Fragment> list_fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        initView();
        initData();
    }
    //记录用户首次点击返回键的时间
    private long firstTime=0;

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_BACK:
                long secondTime=System.currentTimeMillis();
                if(secondTime-firstTime>2000){
                    Toast.makeText(HomePageActivity.this,"再按一次退出程序--->onKeyUp",Toast.LENGTH_SHORT).show();
                    firstTime=secondTime;
                    return true;
                }else{
                    System.exit(0);
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }



    private void initData() {
        list_fragment.add(new HomePageFragment());
        list_fragment.add(new NewsFragment());
        list_fragment.add(Order.newInstance());
        list_fragment.add(new MyFragment());
        for (int i = 0; i < layout.getChildCount(); i++) {
            rbArray[i] = (RadioButton) layout.getChildAt(i);
        }
        ft.add(R.id.fragment, list_fragment.get(0));
        rbArray[0].setChecked(true);
        ft.commit();
        layout.setOnCheckedChangeListener(this);
    }

    private void initView() {
        //动态添加Fragment ,获取Fragment 管理器
        msg = getSupportFragmentManager();

        fragment = (FrameLayout) findViewById(R.id.fragment);
        layout = (RadioGroup) findViewById(R.id.layout);
        rbArray = new RadioButton[layout.getChildCount()];
        list_fragment = new ArrayList<>();
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
    }

    private void showFragment(int id) {
        FragmentTransaction tt = fm.beginTransaction();
        for (int i = 0; i < rbArray.length; i++) {
            if (id == rbArray[i].getId()) {
                if (list_fragment.get(i).isAdded()) {
                    tt.show(list_fragment.get(i)).hide(list_fragment.get(conut)).commit();
                } else {
                    tt.add(R.id.fragment, list_fragment.get(i)).hide(list_fragment.get(conut)).commit();
                }
                conut = i;
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MessageEvent evnt) {
        boolean name = evnt.names;
        if (name) {
            FragmentTransaction tt = msg.beginTransaction();
            tt.replace(R.id.fragment, list_fragment.get(2));
            rbArray[2].setChecked(true);
            tt.commit();
        } else {
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_01:
                showFragment(R.id.rb_01);
                break;
            case R.id.rb_02:
                showFragment(R.id.rb_02);
                break;
            case R.id.rb_03:
                showFragment(R.id.rb_03);
                break;
            case R.id.rb_04:
                showFragment(R.id.rb_04);
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}