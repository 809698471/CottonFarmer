package com.lianghuawang.cottonfarmer.activity.home;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.LocateState;
import com.zaaach.citypicker.model.LocatedCity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends BaseActivity implements View.OnClickListener {
    private String district;
    private TextView weather_cistrict;

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
                    //  String province = amapLocation.getProvince();
                    // String city = amapLocation.getCity();
                    district = amapLocation.getDistrict();

                    //  weather_province.setText(province);
                    //  weather_city.setText(city);
                    weather_cistrict.setText(district);

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
    private LinearLayout weather_lin;
    private TextView weather_province;
    private TextView weather_city;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_weather;
    }

    @Override
    protected void initView() {
        //静态栏--黑色字体
        QMUIStatusBarHelper.setStatusBarLightMode(this);
        weather_lin = (LinearLayout) findViewById(R.id.weather_lin);
        weather_lin.setOnClickListener(this);
        //省
        weather_province = (TextView) findViewById(R.id.weather_Province);
        //市
        weather_city = (TextView) findViewById(R.id.weather_City);
        //区
        weather_cistrict = (TextView) findViewById(R.id.weather_District);
        initDingWeiData();

    }

    private void initDingWeiData() {
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.weather_lin:
                CityPicker.getInstance()
                        .setFragmentManager(getSupportFragmentManager())
                        .setLocatedCity(null)
//                        .setHotCities(hotCities)
                        .setOnPickListener(new OnPickListener() {
                            @Override
                            public void onPick(int position, City data) {

                                if (data != null) {
                                    LoadWeather(data.getCode());
                                }
                                weather_cistrict.setText(data == null ? district : String.format("当前城市：%s，%s", data.getName(), data.getCode()));
                                if (data != null) {
                                    Toast.makeText(
                                            getApplicationContext(),
                                            String.format("点击的数据：%s，%s", data.getName(), data.getCode()),
                                            Toast.LENGTH_SHORT)
                                            .show();
                                }
                            }

                            @Override
                            public void onLocate() {
                                //开始定位，这里模拟一下定位
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        CityPicker.getInstance().locateComplete(new LocatedCity(district, "", ""), LocateState.SUCCESS);
                                    }
                                }, 3000);
                            }
                        })
                        .show();
                break;
        }
    }


    public void LoadWeather(String code) {
        String path = "http://v.juhe.cn/xiangji_weather/real_time_weather.php?areaid=" + code + "&key=fff40e6954a6f1fc5c5864c5e21ec683";
        OkHttp3Utils.getInstance().doGet(path, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Log.e("TAG", response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
