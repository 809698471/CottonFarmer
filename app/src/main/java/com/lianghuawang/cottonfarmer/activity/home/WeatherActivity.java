package com.lianghuawang.cottonfarmer.activity.home;

import android.util.Log;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public class WeatherActivity extends BaseActivity {

    private TextView weather_province;
    private TextView weather_city_district;
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
                    String province = amapLocation.getProvince();
                    String city_district = amapLocation.getCity() + amapLocation.getDistrict();
                    weather_province.setText(province);
                    weather_city_district.setText(city_district);
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
    protected int getLayoutId() {
        return R.layout.activity_weather;
    }

    @Override
    protected void initView() {
        //静态栏--黑色字体
        QMUIStatusBarHelper.setStatusBarLightMode(this);
        weather_province = (TextView) findViewById(R.id.weather_Province);
        weather_city_district = (TextView) findViewById(R.id.weather_City_District);
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
}
