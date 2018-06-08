package com.lianghuawang.cottonfarmer.activity.home;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
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
    private TextView text_dingwei;
    private static final int WRITE_COARSE_LOCATION_REQUEST_CODE = 100;
    private static final int ACCESS_FINE_LOCATION = 200;
    private static final int WRITE_EXTERNAL_STORAGE = 300;
    private static final int READ_EXTERNAL_STORAGE = 400;
    private static final int READ_PHONE_STATE = 500;
    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation amapLocation) {
            if (amapLocation != null) {
                if (amapLocation.getErrorCode() == 0) {
                /*    amapLocation.getProvince();//省信息
                    amapLocation.getCity();//城市信息
                    amapLocation.getDistrict();//城区信息*/
                    String str = amapLocation.getProvince() + amapLocation.getDistrict();
                    text_dingwei.setText(str);
                    Log.e("AmapError2222", amapLocation.getAddress());
                } else {
                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError", "location Error, ErrCode:"
                            + amapLocation.getErrorCode() + ", errInfo:"
                            + amapLocation.getErrorInfo());
                }
            }

        }
    };
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;
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
        text_dingwei = (TextView) view.findViewById(R.id.text_dingwei);
        initDingWeiData();
        checkPermission();
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

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            //申请ACCESS_COARSE_LOCATION权限
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    WRITE_COARSE_LOCATION_REQUEST_CODE);//自定义的code
        }
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            //申请ACCESS_FINE_LOCATION权限
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    ACCESS_FINE_LOCATION);//自定义的code
        }
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //申请WRITE_EXTERNAL_STORAGE权限
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    WRITE_EXTERNAL_STORAGE);//自定义的code
        }
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //申请READ_EXTERNAL_STORAGE权限
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    READ_EXTERNAL_STORAGE);//自定义的code
        }
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            //申请READ_PHONE_STATE权限
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_PHONE_STATE},
                    READ_PHONE_STATE);//自定义的code
        }
    }

    private void initDingWeiData() {
        //初始化定位
        mLocationClient = new AMapLocationClient(getActivity().getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);
        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //获取一次定位结果：
        //该方法默认为false。
        mLocationOption.setOnceLocation(true);
        //获取最近3s内精度最高的一次定位结果：
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        mLocationOption.setOnceLocationLatest(true);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //天气
            case R.id.home_lin_weather:
                startActivity(new Intent(getActivity(),WeatherActivity.class));
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
