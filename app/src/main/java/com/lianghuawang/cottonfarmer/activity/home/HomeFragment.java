package com.lianghuawang.cottonfarmer.activity.home;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
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
import com.lianghuawang.cottonfarmer.activity.home.news.HeadLineActivity;
import com.lianghuawang.cottonfarmer.activity.my.MyCreditActivity;
import com.lianghuawang.cottonfarmer.adapter.NewsAndInformationAdapter;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.home.news.News;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.ui.base.BaseFragment;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.LoginUtils;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.zaaach.citypicker.db.DBManager;
import com.zaaach.citypicker.model.City;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 新版----首页
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private static final int RECODE = 1;
    private static final int CODE = 1;
    private static final int WRITE_COARSE_LOCATION_REQUEST_CODE = 100;
    private static final int ACCESS_FINE_LOCATION = 200;
    private static final int WRITE_EXTERNAL_STORAGE = 300;
    private static final int READ_EXTERNAL_STORAGE = 400;
    private static final int READ_PHONE_STATE = 500;

    private int doubl;
    private MyAdper myAdper;
    List<View> list = new ArrayList<>();
    List<Bean> beanList = new ArrayList<>();

    private SharedPreferencesUtil LoginSP;
    private String Token;

    @Bind(R.id.text_dingwei)
    TextView text_dingwei;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.view_dot1)
    View view_dot1;
    @Bind(R.id.view_dot2)
    View view_dot2;
    @Bind(R.id.view_dot3)
    View view_dot3;
    @Bind(R.id.ll_dot)
    LinearLayout ll_dot;
    @Bind(R.id.view_dot)
    View view_dot;
    @Bind(R.id.Rl_dot)
    RelativeLayout Rl_dot;
    @Bind(R.id.recy)
    RecyclerView recy;
    @Bind(R.id.home_lin_weather)
    LinearLayout home_lin_weather;
    @Bind(R.id.home_lin_hzbx)
    LinearLayout hzbx;
    @Bind(R.id.home_lin_zjhz)
    LinearLayout zjhz;
    @Bind(R.id.home_lin_wyrs)
    LinearLayout wyrs;
    @Bind(R.id.home_lin_mhsc)
    LinearLayout mhsc;
    @Bind(R.id.home_lin_jxnz)
    LinearLayout jxnz;
    @Bind(R.id.home_lin_wdzl)
    LinearLayout wdzl;
    @Bind(R.id.home_lin_zhlhcx)
    LinearLayout zhlhcx;
    @Bind(R.id.filpper)
    ViewFlipper filpper;
    @Bind(R.id.home_text_wendu)
    TextView home_text_wendu;
    @Bind(R.id.home_text_fengli)
    TextView home_text_fengli;

    private List<News.DataBean> dataBeans;

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
                    // String str = amapLocation.getProvince() + amapLocation.getDistrict();
                    String str = amapLocation.getDistrict();
                    text_dingwei.setText(str);
                    String bianma = bianma(amapLocation.getProvince(), amapLocation.getDistrict());
                    Log.e("asdasdasdasdada", "" + bianma);
                    LoadWeather(bianma);
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
    public int getLayoutId() {
        return R.layout.homefragment;
    }

    @Override
    public void initViews() {
        News(1);
        initView();
        initDate();
        getleng();
        myAdper = new MyAdper();
        viewpager.setAdapter(myAdper);
    }

    private void initDate() {
        LoginSP = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP);
        Token = LoginSP.getString(ConstantUtil.LOGINTOKEN, "");

        View view1 = View.inflate(getActivity(), R.layout.view1, null);
        View view2 = View.inflate(getActivity(), R.layout.view1, null);
        View view3 = View.inflate(getActivity(), R.layout.view1, null);
        View view4 = View.inflate(getActivity(), R.layout.view2, null);

        list.add(view1);
        list.add(view2);
        list.add(view3);
        list.add(view4);

    }

    private void initView() {
        QMUIStatusBarHelper.setStatusBarDarkMode(getActivity());
        initDingWeiData();
        checkPermission();
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
        //链花头条
        //资讯
        recy.setLayoutManager(new LinearLayoutManager(getContext()));
        for (int i = 0; i < 15; i++) {
            Bean bean = new Bean();
            bean.setName("2017-06-10");
            beanList.add(bean);
        }
        NewsAndInformationAdapter adapter = new NewsAndInformationAdapter(getActivity(), beanList);
        recy.setAdapter(adapter);


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

    /**
     * 获取当前编码
     */

    public String bianma(String province, String name) {

        String cityCode = "失败";

        Log.e("Test", "province : " + province);
        Log.e("Test", "name : " + name);
        DBManager dbManager = new DBManager(getActivity());
        List<City> allCities = dbManager.getAllCities();
        for (int i = 0; i < allCities.size(); i++) {
            Log.e("Test", "getProvince : " + allCities.get(i).getProvince());
            if (province.contains(allCities.get(i).getProvince())) {
                Log.e("Test", "getName : " + allCities.get(i).getName());
                if (name.contains(allCities.get(i).getName())) {
                    cityCode = allCities.get(i).getCode();
                    return cityCode;
                }
            }
        }
        return cityCode;
    }

    private void LoadWeather(String bianma) {
        final String path = "http://v.juhe.cn/xiangji_weather/real_time_weather.php?areaid=" + bianma + "&key=fff40e6954a6f1fc5c5864c5e21ec683";
        OkHttp3Utils.getInstance().doGet(path, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body().string());
                            JSONObject result = jsonObject.getJSONObject("result");
                            JSONObject data = result.getJSONObject("data");
                            String cw = data.getString("cw");
                            String w = data.getString("w");
                            String rh = data.getString("rh");//相对湿度
                            String cwd = data.getString("cwd");//风力描述
                            String wd = data.getString("wd");//风向描述
                            String wdg = data.getString("wdg");//风力级别
                            String tmp = data.getString("tmp");//温度
                            String airp = data.getString("airp");//气压
                            String st = data.getString("st");//体感温度
//                            ToastUtils.show(getApplicationContext(),cw+"---"+w,1);

                            home_text_fengli.setText(wd + wdg + "级");
                            home_text_wendu.setText(tmp + "℃");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

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
                LoginUtils.StartActivity(getActivity(), WeatherActivity.class, CODE, RECODE);
                break;
            //互助保险
            case R.id.home_lin_hzbx:
                LoginUtils.StartActivity(getActivity(), BuyInsuranceActivity.class, CODE, RECODE);
                break;
            //资金互助
            case R.id.home_lin_zjhz:
                LoginUtils.StartActivity(getActivity(), IWantToBorrowMoneyActivity.class, CODE, RECODE);
                break;
            //我要入社
            case R.id.home_lin_wyrs:
                LoginUtils.StartActivity(getActivity(), CooperativeOrganizationActivity.class, CODE, RECODE);
                break;
            //棉花市场
            case R.id.home_lin_mhsc:
                LoginUtils.StartActivity(getActivity(), CottonTradeActivity.class, CODE, RECODE);
                break;
            //精选农资
            case R.id.home_lin_jxnz:
                LoginUtils.StartActivity(getActivity(), AMActivity.class, CODE, RECODE);
                break;
            //我的资料
            case R.id.home_lin_wdzl:
                LoginUtils.StartActivity(getActivity(), MyCreditActivity.class, CODE, RECODE);
                break;
            //链花头条
            case R.id.filpper:
                Intent intent = new Intent(getContext(), HeadLineActivity.class);
                intent.putExtra(ConstantUtil.HEAD_LINE, dataBeans.get(filpper.getDisplayedChild()).getId());
                startActivity(intent);
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

    /**
     * -----------------------头条、资讯------------------------------------
     **/

    private void News(int type) {
        String URL = String.format(Concat.NEWS, type);
        OkHttp3Utils.doGet(URL, new GsonObjectCallback<News>() {
            @Override
            public void onUi(News news) {
                if (news.isSuccess()) {
                    dataBeans = news.getData();
                    headline(dataBeans);
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }

    private void headline(List<News.DataBean> dataBeans) {
        for (int i = 0; i < dataBeans.size(); i++) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_custom, null);
            TextView title1 = view.findViewById(R.id.tv_head_title1);
            title1.setText(dataBeans.get(i).getTitle());
            filpper.addView(view);

        }
    }

}
