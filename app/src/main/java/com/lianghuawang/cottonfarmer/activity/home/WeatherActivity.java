package com.lianghuawang.cottonfarmer.activity.home;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.tools.SunriseView;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.db.DBManager;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.LocateState;
import com.zaaach.citypicker.model.LocatedCity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends BaseActivity implements View.OnClickListener, AbsListView.OnScrollListener {
    private String district;
    private TextView weather_cistrict;
    //三天数据
    private List<WeatherBean> threedaysdata = new ArrayList<WeatherBean>();
    //十五天数据
    private List<WeatherBean> fifteendaysdata = new ArrayList<WeatherBean>();

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;
    private LinearLayout weather_lin;
    private TextView weather_province;
    private TextView weather_city;
    private String dt;
    private String s;
    private View headlayout;
    private View loadMoreView;
    private TextView weather_tv_fengli;
    private TextView weather_tv_shidu;
    private TextView weather_tv_wendu;
    private TextView weather_tv_tianqixianxiang;
    private TextView weather_tv_qiya;
    private TextView weather_tv_tiganwendu;
    private TextView weather_tv_xingqi;
    private TextView weather_tv_mon_day;
    private Button loadMoreButton;
    private ListView listView;
    private PaginationAdapter adapter;
    private int visibleLastIndex = 0; // 最后的可视项索引
    private int visibleItemCount; // 当前窗口可见项总数
    private int datasize = 15; // 模拟数据集的条数
    private Handler handler = new Handler();
    private int itemsLastIndex;
    private String w_am;
    private String wind;
    private String tmp_max;
    private String tmp_min;
    private SunriseView mSunriseView;
    private String sunrise_time;
    private String sunset_time;
    private AMapLocationListener mLocationListener;
    private TextView weather_sunriseTime;
    private TextView weather_sunsetTime;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_weather;
    }

    @Override
    protected void initView() {
        //静态栏--黑色字体
        QMUIStatusBarHelper.setStatusBarLightMode(this);
        initLocation();
        weather_lin = (LinearLayout) findViewById(R.id.weather_lin);
        weather_lin.setOnClickListener(this);
        //省
        weather_province = (TextView) findViewById(R.id.weather_Province);
        //市
        weather_city = (TextView) findViewById(R.id.weather_City);
        //区
        weather_cistrict = (TextView) findViewById(R.id.weather_District);
        initDingWeiData();

        listView = (ListView) findViewById(R.id.lvNews);
        headlayout = getLayoutInflater().inflate(R.layout.headlayout, null);//头部视图
        loadMoreView = getLayoutInflater().inflate(R.layout.loadmore, null);//尾部视图

        listView.addHeaderView(headlayout); //设置列表头部视图
        listView.addFooterView(loadMoreView); // 设置列表底部视图initializeAdapter();
        listView.setOnScrollListener(this);

        //风力
        weather_tv_fengli = (TextView) headlayout.findViewById(R.id.weather_tv_fengli);
        //湿度
        weather_tv_shidu = (TextView) headlayout.findViewById(R.id.weather_tv_shidu);
        //温度
        weather_tv_wendu = (TextView) headlayout.findViewById(R.id.weather_tv_wendu);
        //天气现象
        weather_tv_tianqixianxiang = (TextView) headlayout.findViewById(R.id.weather_tv_tianqixianxiang);
        //气压
        weather_tv_qiya = (TextView) headlayout.findViewById(R.id.weather_tv_qiya);
        //体感温度
        weather_tv_tiganwendu = (TextView) headlayout.findViewById(R.id.weather_tv_tiganwendu);
        //星期
        weather_tv_xingqi = (TextView) headlayout.findViewById(R.id.weather_tv_xingqi);
        //月、日
        weather_tv_mon_day = (TextView) headlayout.findViewById(R.id.weather_tv_mon_day);
        //日出时间
        getTime();
        //15天趋势预报
        loadMoreButton = (Button) loadMoreView.findViewById(R.id.loadMoreButton);
        loadMoreButton.setOnClickListener(this);
        getOldDate();
        mSunriseView = (SunriseView) loadMoreView.findViewById(R.id.sun);
        //日出
        weather_sunriseTime = (TextView) loadMoreView.findViewById(R.id.weather_sunriseTime);
        //日落
        weather_sunsetTime = (TextView) loadMoreView.findViewById(R.id.weather_sunsetTime);
        // startSunAnim(6, 18);

    }

    public void startSunAnim(int sunrise, int sunset) {
        Calendar calendarNow = Calendar.getInstance();
        int hour = calendarNow.get(Calendar.HOUR_OF_DAY);
        Log.e("获取当前时间", "" + hour);
        if (hour < sunrise) {
            mSunriseView.sunAnim(0);
        } else if (hour > sunset) {
            mSunriseView.sunAnim(1);
        } else {
            mSunriseView.sunAnim(((float) hour - (float) sunrise) / ((float) sunset - (float) sunrise));
        }
    }


    /**
     * 获取当前编码
     */
    public String bianma(String province, String name) {

        String cityCode = "失败";

        Log.e("Test", "province : " + province);
        Log.e("Test", "name : " + name);
        DBManager dbManager = new DBManager(WeatherActivity.this);
        List<City> allCities = dbManager.getAllCities();
        for (int i = 0; i < allCities.size(); i++) {
            //   Log.e("Test", "getProvince : " + allCities.get(i).getProvince());
            if (province.contains(allCities.get(i).getProvince())) {
                //  Log.e("Test", "getName : " + allCities.get(i).getName());
                if (name.contains(allCities.get(i).getName())) {
                    cityCode = allCities.get(i).getCode();
                    return cityCode;
                }
            }
        }
        return cityCode;
    }

    /**
     * 处理首页时间
     */
    public void getTime() {
        final Calendar calendar = Calendar.getInstance();//获取实例
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));//设置时区
        String curYear = String.valueOf(calendar.get(Calendar.YEAR));//年
        String curMon = String.valueOf(calendar.get(Calendar.MONTH) + 1);//月
        String curDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));//日
        String curWeek = String.valueOf(calendar.get(Calendar.DAY_OF_WEEK));
        switch (curWeek) {
            case "1":
                curWeek = "天";
                break;
            case "2":
                curWeek = "一";
                break;
            case "3":
                curWeek = "二";
                break;
            case "4":
                curWeek = "三";
                break;
            case "5":
                curWeek = "四";
                break;
            case "6":
                curWeek = "五";
                break;
            case "7":
                curWeek = "六";
                break;
        }
        weather_tv_xingqi.setText("星期" + curWeek);
        weather_tv_mon_day.setText(curYear + " / " + curMon + " / " + curDay);
    }

    /**
     * 获取前n天日期、后n天日期
     * 前几天 如获取前7天日期则传-7即可；如果后7天则传7
     */
    public void getOldDate() {
        //获取当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        //当前时间
        dt = simpleDateFormat.format(new Date());
        Log.e("++++++", dt);
        //15天
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) + 14);
        Date endDate = date.getTime();
        s = simpleDateFormat.format(endDate);
        Log.e("++++++", s.toString());

    }

    /**
     * 定位城市
     */
    private void initLocation() {
        //声明定位回调监听器
        mLocationListener = new AMapLocationListener() {
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

                        String bianma = bianma(amapLocation.getProvince(), amapLocation.getDistrict());
                        Log.e("asdasdasdasdada", "" + bianma);
                        LoadWeather(bianma);
                        initializeAdapter(bianma);
                        //  weather_province.setText(province);
                        //  weather_city.setText(city);
                        weather_cistrict.setText(district);
                        LogUtils.e("===========" + amapLocation.getAdCode());
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
                okhttp();
                break;
            case R.id.loadMoreButton:
                //   loadMoreButton.setText("正在加载中..."); // 设置按钮文字
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
                loadMoreData();
                adapter.notifyDataSetChanged();
                //  loadMoreButton.setText("15天的趋势预报"); // 恢复按钮文字
//                    }
//                }, 1000);
                break;
        }
    }

    /**
     * 初始化ListView的适配器
     */
    private void initializeAdapter(String code) {
        final String pathurl = "http://v.juhe.cn/xiangji_weather/15_area.php?areaid=" + code + "&startTime=" + dt + "&endTime=" + s + "&key=fff40e6954a6f1fc5c5864c5e21ec683";
        OkHttp3Utils.getInstance().doGet(pathurl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(response.body().string());
                            JSONObject result = jsonObject.getJSONObject("result");
                            JSONArray data = result.getJSONArray("series");
                            if (threedaysdata.size() > 0 && fifteendaysdata.size() > 0) {
                                threedaysdata.clear();
                                fifteendaysdata.clear();
                            }
                            for (int i = 0; i < data.length(); i++) {
                                JSONObject jsonObject1 = data.getJSONObject(i);
                                WeatherBean items = new WeatherBean();
                                //天气现象
                                w_am = jsonObject1.getString("w_am");
                                String wd = jsonObject1.getString("wd");//风向描述
                                //风力
                                wind = jsonObject1.getString("wind");
                                //预测最高温度
                                tmp_max = jsonObject1.getString("tmp_max");
                                //预测最低温度
                                tmp_min = jsonObject1.getString("tmp_min");
                                //日出时间
                                sunrise_time = jsonObject1.getString("sunrise");
                                //日落时间
                                sunset_time = jsonObject1.getString("sunset");

                                items.setW_am(w_am);//天气现象
                                items.setWind(wind + "风");//风力
                                items.setTmp_max(tmp_max);//预测最高高度
                                items.setTmp_min(tmp_min + "℃");//预测最高低度
                                weather_sunriseTime.setText("日出 " + sunrise_time);//日出时间
                                weather_sunsetTime.setText("日落 " + sunset_time);//日落时间
                                String startTime = sunrise_time;
                                String endTime = sunset_time;
                                String subStartTime = startTime.substring(0, startTime.indexOf(":"));
                                String subEndTime = endTime.substring(0, endTime.indexOf(":"));
                                Integer integerStart = Integer.parseInt(subStartTime);
                                Integer integerEnd = Integer.parseInt(subEndTime);
                                startSunAnim(integerStart, integerEnd);
                                if (i < 3) {
                                    threedaysdata.add(items);
                                }
                                fifteendaysdata.add(items);
                            }

                            adapter = new PaginationAdapter(threedaysdata);
                            listView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("Sws", "" + e.getMessage());
                        }
                    }
                });

            }
        });


    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        int itemsLastIndex = adapter.getCount() - 1; // 数据集最后一项的索引
        int lastIndex = itemsLastIndex + 1;
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE
                && visibleLastIndex == lastIndex) {
            // 如果是自动加载,可以在这里放置异步加载数据的代码

        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.visibleItemCount = visibleItemCount;
        visibleLastIndex = firstVisibleItem + visibleItemCount - 1;

        Log.e("===========", "========================");
        Log.e("firstVisibleItem = ", firstVisibleItem + "");

        Log.e("visibleItemCount = ", visibleItemCount + "");

        Log.e("totalItemCount = ", totalItemCount + "");

        Log.e("=========== ", "========================");

        // 如果所有的记录选项等于数据集的条数，则移除列表底部视图

        if (totalItemCount == datasize + 1) {

            listView.removeFooterView(loadMoreView);

            Toast.makeText(this, "数据全部加载完!", Toast.LENGTH_LONG).show();

        }

    }

    /**
     * 加载更多数据
     */

    private void loadMoreData() {
        adapter = new PaginationAdapter(fifteendaysdata);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        loadMoreButton.setText("点击回到顶部");
    }

    class PaginationAdapter extends BaseAdapter {

        List<WeatherBean> newsItems = new ArrayList<>();

        public PaginationAdapter(List<WeatherBean> newsitems) {
            this.newsItems = newsitems;
        }

        @Override
        public int getCount() {
            return newsItems.size();
        }

        @Override
        public Object getItem(int position) {
            return newsItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.list_item, null);
            }
            TextView weather_time = (TextView) view.findViewById(R.id.weather_time);
            initTimerSetText(weather_time, position);
            //weather_time.setText(newsItems.get(position).getW_am());
            // 天气现象上午
            TextView weather_w_am = (TextView) view.findViewById(R.id.weather_w_am);
            weather_w_am.setText(newsItems.get(position).getW_am());
            // 风力
            TextView weather_wind = (TextView) view.findViewById(R.id.weather_wind);
            weather_wind.setText(newsItems.get(position).getWind());
            //预测最高温度
            TextView weather_tmp_max = (TextView) view.findViewById(R.id.weather_tmp_max);
            weather_tmp_max.setText(newsItems.get(position).getTmp_max());
            //预测最高低度
            TextView weather_tmp_min = (TextView) view.findViewById(R.id.weather_tmp_min);
            weather_tmp_min.setText(newsItems.get(position).getTmp_min());
            return view;

        }

        /**
         * 添加数据列表项
         *
         * @param newsitem
         */

        public void addNewsItem(WeatherBean newsitem) {
            newsItems.add(newsitem);
        }

    }

    /**
     * 计算15天时间
     */
    private void initTimerSetText(TextView weather_time, int position) {

        if (position == 0) {
            weather_time.setText("今天");
        } else if (position == 1) {
            weather_time.setText("明天");
        } else if (position == 2) {
            weather_time.setText("后天");

        } else {
            List<String> sevendate = getSevendate();
            String s = sevendate.get(position);
            weather_time.setText(s);
//            for (int i = 3; i < sevendate.size(); i++){
//                String s = sevendate.get(i);
//
//            }
        }
    }

    /**
     * 城市选择
     */

    private void okhttp() {
        CityPicker.getInstance()
                .setFragmentManager(getSupportFragmentManager())
                .setLocatedCity(null)
//                        .setHotCities(hotCities)
                .setOnPickListener(new OnPickListener() {
                    @Override
                    public void onPick(int position, City data) {

                        if (data != null) {
                            LoadWeather(data.getCode());
                            initializeAdapter(data.getCode());
                            loadMoreButton.setText("15天趋势预报");
                        }
                        //   weather_cistrict.setText(data == null ? district : String.format("当前城市：%s，%s", data.getName(), data.getCode()));
                        weather_cistrict.setText(data == null ? district : String.format(data.getName()));
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
    }

    /**
     * 当前天气
     */

    public void LoadWeather(String code) {

        final String path = "http://v.juhe.cn/xiangji_weather/real_time_weather.php?areaid=" + code + "&key=fff40e6954a6f1fc5c5864c5e21ec683";
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

                            weather_tv_fengli.setText(wd + wdg + "级");
                            weather_tv_wendu.setText(tmp + "°");
                            weather_tv_shidu.setText(rh + "%");
                            weather_tv_tianqixianxiang.setText(w);
                            weather_tv_qiya.setText(airp);
                            weather_tv_tiganwendu.setText(st);
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


    /**
     * 获取今天往后一周的日期（几月几号）
     */
    public static List<String> getSevendate() {
        List<String> dates = new ArrayList<String>();
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));

        for (int i = 0; i < 15; i++) {
            String mYear = String.valueOf(c.get(Calendar.YEAR));// 获取当前年份
            String mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
            String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH) + i);// 获取当前日份的日期号码
            //String date = mMonth + "月" + mDay + "日";
            if (Integer.valueOf(mMonth) < 10) {
                mMonth = "0" + mMonth;
            }
            if (Integer.valueOf(mDay) < 10) {
                mDay = "0" + mDay;
            }
            String date = mMonth + "-" + mDay;

            dates.add(date);
        }
        return dates;
    }
}