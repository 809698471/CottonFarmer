package com.lianghuawang.cottonfarmer.activity.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.home.agriculturalMaterials.AMActivity;
import com.lianghuawang.cottonfarmer.activity.home.cooperation.CooperativeOrganizationActivity;
import com.lianghuawang.cottonfarmer.activity.home.insurance.BuyInsuranceActivity;
import com.lianghuawang.cottonfarmer.activity.my.MyCreditActivity;
import com.lianghuawang.cottonfarmer.adapter.NewsAndInformationAdapter;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 新版----首页
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private ViewPager viewpager;
    private View view_dot1;
    private View view_dot2;
    private View view_dot3;
    private LinearLayout ll_dot;
    private int doubl;
    private View view_dot;
    private RelativeLayout Rl_dot;
    private ViewFlipper filpper;
    private RecyclerView recy;
    private MyAdper myAdper;
    List<View> list = new ArrayList<>();
    List<Bean> beanList = new ArrayList<>();
    private LinearLayout home_lin_weather;
    private LinearLayout hzbx;
    private LinearLayout zjhz;
    private LinearLayout wyrs;
    private LinearLayout mhsc;
    private LinearLayout jxnz;
    private LinearLayout wdzl;
    private LinearLayout zhlhcx;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.homefragment, null);
        initView(view);
        initDate();
        getleng();
        myAdper = new MyAdper();
        viewpager.setAdapter(myAdper);
        return view;
    }

    private void initDate() {
        View view1 = View.inflate(getActivity(), R.layout.view1, null);
        View view2 = View.inflate(getActivity(), R.layout.view1, null);
        View view3 = View.inflate(getActivity(), R.layout.view1, null);
        View view4 = View.inflate(getActivity(), R.layout.view2, null);

        list.add(view1);
        list.add(view2);
        list.add(view3);
        list.add(view4);

    }

    private void initView(View view) {
        QMUIStatusBarHelper.setStatusBarDarkMode(getActivity());
        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        viewpager.setCurrentItem(0);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                float cc = doubl * positionOffset + doubl * position;
                RelativeLayout.LayoutParams bb = (RelativeLayout.LayoutParams) view_dot.getLayoutParams();
                bb.leftMargin = (int) cc;
                view_dot.setLayoutParams(bb);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        initTab();
        view_dot1 = (View) view.findViewById(R.id.view_dot1);
        view_dot2 = (View) view.findViewById(R.id.view_dot2);
        view_dot3 = (View) view.findViewById(R.id.view_dot3);
        ll_dot = (LinearLayout) view.findViewById(R.id.ll_dot);
        view_dot = (View) view.findViewById(R.id.view_dot);
        Rl_dot = (RelativeLayout) view.findViewById(R.id.Rl_dot);
        //链花头条
        filpper = (ViewFlipper) view.findViewById(R.id.filpper);
        for (int i = 0; i < 5; i++) {
            View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.layout_custom, null);
            filpper.addView(view1);
        }
        //资讯
        recy = (RecyclerView) view.findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(getContext()));
        for (int i = 0; i < 15; i++) {
            Bean bean = new Bean();
            bean.setName("2017-06-10");
            beanList.add(bean);
        }
        NewsAndInformationAdapter adapter = new NewsAndInformationAdapter(getActivity(),beanList);
        recy.setAdapter(adapter);

        home_lin_weather = (LinearLayout) view.findViewById(R.id.home_lin_weather);
        hzbx = (LinearLayout) view.findViewById(R.id.home_lin_hzbx);
        zjhz = (LinearLayout) view.findViewById(R.id.home_lin_zjhz);
        wyrs = (LinearLayout) view.findViewById(R.id.home_lin_wyrs);
        mhsc = (LinearLayout) view.findViewById(R.id.home_lin_mhsc);
        jxnz = (LinearLayout) view.findViewById(R.id.home_lin_jxnz);
        wdzl = (LinearLayout) view.findViewById(R.id.home_lin_wdzl);
        zhlhcx = (LinearLayout) view.findViewById(R.id.home_lin_zhlhcx);
        home_lin_weather.setOnClickListener(this);
        hzbx.setOnClickListener(this);
        zjhz.setOnClickListener(this);
        wyrs.setOnClickListener(this);
        mhsc.setOnClickListener(this);
        jxnz.setOnClickListener(this);
        wdzl.setOnClickListener(this);
        filpper.setOnClickListener(this);
        zhlhcx.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //天气
            case R.id.home_lin_weather:
                break;
            //互助保险
            case R.id.home_lin_hzbx:
                startActivity(new Intent(getActivity(),BuyInsuranceActivity.class));
                break;
            //资金互助
            case R.id.home_lin_zjhz:
                startActivity(new Intent(getActivity(),IWantToBorrowMoneyActivity.class));
                break;
            //我要入社
            case R.id.home_lin_wyrs:
                startActivity(new Intent(getActivity(),CooperativeOrganizationActivity.class));
                break;
            //棉花市场
            case R.id.home_lin_mhsc:
                startActivity(new Intent(getActivity(),CottonTradeActivity.class));
                break;
            //精选农资
            case R.id.home_lin_jxnz:
                startActivity(new Intent(getActivity(),AMActivity.class));
                break;
            //我的资料
            case R.id.home_lin_wdzl:
                startActivity(new Intent(getActivity(),MyCreditActivity.class));
                break;
            //链花头条
            case R.id.filpper:
                break;
            //中华联合财险
            case R.id.home_lin_zhlhcx:
                break;
        }
    }

    private void initTab() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            viewpager.setCurrentItem(viewpager.getCurrentItem() + 1);
                            if (viewpager.getCurrentItem() == 3) {
                                viewpager.setCurrentItem(0);
                            }
                        }
                    });

                }

            }

        }).start();
    }


    public void getleng() {
        ViewTreeObserver sObserver = ll_dot.getViewTreeObserver();
        sObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                doubl = ll_dot.getChildAt(1).getLeft() - ll_dot.getChildAt(0).getLeft();
            }
        });
    }


    private class MyAdper extends PagerAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return object == view;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }
    }
}
