package com.lianghuawang.cottonfarmer.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.home.HomeFragment;
import com.lianghuawang.cottonfarmer.activity.message.NewsFragment;
import com.lianghuawang.cottonfarmer.activity.my.MyFragment;
import com.lianghuawang.cottonfarmer.activity.order.Order;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.tools.MessageEvent;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.LoginUtils;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 首页
 * 范文轲
 * bug:在未登录时，Fragment跳转有问题，现已暂时解决（治标不治本），后续优化----已解决
 *
 */
public class HomePageActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    @Bind(R.id.rb_01)
    RadioButton rb_01;
    @Bind(R.id.rb_02)
    RadioButton rb_02;
    @Bind(R.id.rb_03)
    RadioButton rb_03;
    @Bind(R.id.rb_04)
    RadioButton rb_04;
    @Bind(R.id.layout)
    RadioGroup layout;
    @Bind(R.id.fragment)
    FrameLayout fragment;

    private static final int CODE = 1;
    private static final int RECODE = 2;
    private static final int RECODE1 = 3;
    private FragmentManager msg;

    private FragmentManager fm;
    private FragmentTransaction ft;
    private int mShowConut = 0;
    private int mDissConut = 0;
    private List<Fragment> list_fragment;

    private Fragment home;//首页Fragment
    private Fragment news;//消息Fragment
    private Fragment order;//订单Fragment
    private MyFragment my;//我的Fragment
    private RadioButton[] mRbList;
    private SharedPreferencesUtil loginSP;//登录SP
    public int mPayStart;//支付完成后跳转到订单Fragment
    private final int mPayStartDef = -1;
    //记录用户首次点击返回键的时间
    private long firstTime = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_page;
    }

    @Override
    protected void initView() {
        mPayStart = getIntent().getIntExtra("id", mPayStartDef);
        loginSP = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP);
        //动态添加Fragment ,获取Fragment 管理器
        msg = getSupportFragmentManager();
        list_fragment = new ArrayList<>();
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        initData();
    }

    private void initData() {
        home = new HomeFragment();
        order = Order.newInstance();
        news = new NewsFragment();
        my = new MyFragment();
        list_fragment.add(home);
        list_fragment.add(news);
        list_fragment.add(order);
        list_fragment.add(my);
        LogUtils.d(order.toString());//Order{ae30b41}
        ft.add(R.id.fragment, list_fragment.get(0)).commit();
        mRbList = new RadioButton[4];
        mRbList[0] = rb_01;
        mRbList[1] = rb_02;
        mRbList[2] = rb_03;
        mRbList[3] = rb_04;
        rb_01.setOnClickListener(this);
        rb_01.setOnCheckedChangeListener(this);
        rb_02.setOnClickListener(this);
        rb_02.setOnCheckedChangeListener(this);
        rb_03.setOnClickListener(this);
        rb_03.setOnCheckedChangeListener(this);
        rb_04.setOnClickListener(this);
        rb_04.setOnCheckedChangeListener(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MessageEvent evnt) {
        LogUtils.d("even");
            mRbList[2].setChecked(true);
            mShowConut = 2;
            showFragment(3,2);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == 4) {
            my.onResumeData();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPayStart != mPayStartDef) {
            mRbList[mPayStart - 1].setChecked(true);
            mShowConut = 2;
            showFragment(0,2);
        }
    }

    @Override
    public void onClick(View v) {
        boolean login = loginSP.getBoolean(ConstantUtil.LOGINSTATE, false);
        if (!login) {//登录前
            switch (v.getId()) {
                case R.id.rb_01:
                    mShowConut = 0;
                    break;
                case R.id.rb_02:
                    mRbList[mShowConut].setChecked(true);
                    LoginUtils.StartActivity(HomePageActivity.this, null, CODE, RECODE);
                    break;
                case R.id.rb_03:
                    mRbList[mShowConut].setChecked(true);
                    LoginUtils.StartActivity(HomePageActivity.this, null, CODE, RECODE1);
                    break;
                case R.id.rb_04:
                    mShowConut = 3;
                    break;
            }
            if (mShowConut == mDissConut && mShowConut == 0) {
                LogUtils.d("showFragment-3-0");
                if (list_fragment.get(3).isAdded()) {
                    showFragment(3, 0);
                }
            } else if (mShowConut == mDissConut && mShowConut == 3) {
                LogUtils.d("showFragment-0-3");
                showFragment(0, 3);
            } else {
                LogUtils.d("showFragment" + mDissConut + "----" + mShowConut);
                showFragment(mDissConut, mShowConut);
            }
        } else {//登陆后
            switch (v.getId()) {
                case R.id.rb_01:
                    mShowConut = 0;
                    break;
                case R.id.rb_02:
                    mShowConut = 1;
                    break;
                case R.id.rb_03:
                    mShowConut = 2;
                    break;
                case R.id.rb_04:
                    mShowConut = 3;
                    break;
            }
            LogUtils.d("showFragment" + mDissConut + "----" + mShowConut);
            showFragment(mDissConut, mShowConut);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        boolean login = loginSP.getBoolean(ConstantUtil.LOGINSTATE, false);
        if (login) {
            switch (buttonView.getId()) {
                case R.id.rb_01:
                    if (!isChecked) {
                        mDissConut = 0;
                        LogUtils.d("rb_01_mDiss");
                    }
                    break;
                case R.id.rb_02:
                    if (!isChecked) {
                        LogUtils.d("rb_02_mDiss");
                        mDissConut = 1;
                    }
                    break;
                case R.id.rb_03:
                    if (!isChecked) {
                        LogUtils.d("rb_03_mDiss");
                        mDissConut = 2;
                    }
                    break;
                case R.id.rb_04:
                    if (!isChecked) {
                        LogUtils.d("rb_04_mDiss");
                        mDissConut = 3;
                    }
                    break;
            }
        } else {
            switch (buttonView.getId()) {
                case R.id.rb_01:
                    if (!isChecked) {
                        mDissConut = 0;
                        LogUtils.d("rb_01_mDiss");
                    }
                    break;
                case R.id.rb_04:
                    if (!isChecked) {
                        LogUtils.d("rb_04_mDiss");
                        mDissConut = 3;
                    }
                    break;
            }
        }
    }

    private void showFragment(int first, int two) {
        FragmentTransaction tt = fm.beginTransaction();
        if (list_fragment.get(two).isAdded()) {
            LogUtils.d("true");
            tt.show(list_fragment.get(two)).hide(list_fragment.get(first)).commit();
        } else {
            LogUtils.d("false");
            tt.add(R.id.fragment, list_fragment.get(two)).hide(list_fragment.get(first)).commit();
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 2000) {
                    Toast.makeText(HomePageActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    firstTime = secondTime;
                    return true;
                } else {
                    System.exit(0);
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }
}