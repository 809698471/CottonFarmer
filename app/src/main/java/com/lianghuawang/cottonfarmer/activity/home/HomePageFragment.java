package com.lianghuawang.cottonfarmer.activity.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.GridAdapter;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.home.agriculturalMaterials.AMActivity;
import com.lianghuawang.cottonfarmer.activity.home.cooperation.CooperativeOrganizationActivity;
import com.lianghuawang.cottonfarmer.activity.home.insurance.BuyInsuranceActivity;
import com.lianghuawang.cottonfarmer.activity.my.MyCreditActivity;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 */
public class HomePageFragment extends Fragment {
    private Banner grid_banner;
    private GridView main_grid;
    private ImageView homepage_img1;
    private ImageView homepage_img2;
    //设置图片资源:url或本地资源
    String[] images = new String[]{
//            "http://218.192.170.132/BS80.jpg",
            "http://img.zcool.cn/community/0166c756e1427432f875520f7cc838.jpg",
            "http://img.zcool.cn/community/018fdb56e1428632f875520f7b67cb.jpg",
            "http://img.zcool.cn/community/01c8dc56e1428e6ac72531cbaa5f2c.jpg",
            "http://img.zcool.cn/community/01fda356640b706ac725b2c8b99b08.jpg",
            "http://img.zcool.cn/community/01fd2756e142716ac72531cbf8bbbf.jpg",
            "http://img.zcool.cn/community/0114a856640b6d32f87545731c076a.jpg"};

    //设置图片标题:自动对应
    String[] titles = new String[]{"十大星级品牌联盟，全场2折起", "全场2折起", "十大星级品牌联盟", "嗨购5折不要停", "12趁现在", "嗨购5折不要停，12.12趁现在", "实打实大顶顶顶顶"};

    List<Bean> beans = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.homepagefragment, null);
        initView(view);
        banner();
        if (beans.size() <= 0 ) {
            grid();
        }else {
            beans.clear();
            grid();
        }

//        Log.e("==========","==============");
        return view;

    }

    private void initView(View view) {
        grid_banner = (Banner) view.findViewById(R.id.grid_banner);
        main_grid = (GridView) view.findViewById(R.id.main_grid);
        homepage_img1 = (ImageView) view.findViewById(R.id.homepage_img1);
        homepage_img2 = (ImageView) view.findViewById(R.id.homepage_img2);
        //热销保险
        homepage_img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             startActivity(new Intent(getActivity(),HotSaleInsuranceActivity.class));
            }
        });
        //热销农资
        homepage_img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),HotSaleOfAgriculturalCapitalActivity.class));

            }
        });

    }

    private void grid() {


        final Bean bean1 = new Bean("购买保险", R.mipmap.ic_launcher);
        Bean bean2 = new Bean("我要借款", R.mipmap.ic_launcher);
        Bean bean3 = new Bean("订购农资", R.mipmap.ic_launcher);
        Bean bean4 = new Bean("棉花交易", R.mipmap.ic_launcher);
        Bean bean5 = new Bean("合作组织", R.mipmap.ic_launcher);
        Bean bean6 = new Bean("我的信用", R.mipmap.ic_launcher);
        beans.add(bean1);
        beans.add(bean2);
        beans.add(bean3);
        beans.add(bean4);
        beans.add(bean5);
        beans.add(bean6);

        GridAdapter adapter = new GridAdapter(getActivity(), beans);
        main_grid.setAdapter(adapter);
        main_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //  Toast.makeText(getActivity(), beans.get(position).getName(), Toast.LENGTH_SHORT).show();
                if (position == 0) {
                    //购买保险
                    startActivity(new Intent(getActivity(),BuyInsuranceActivity.class));
                } else if (position == 1) {
                    //我要借款
                    startActivity(new Intent(getActivity(),IWantToBorrowMoneyActivity.class));
                } else if (position == 2) {
                    //订购农资
                    startActivity(new Intent(getActivity(),AMActivity.class));
                } else if (position == 3) {
                    //棉花交易
                    startActivity(new Intent(getActivity(),CottonTradeActivity.class));
                } else if (position == 4) {
                    //合作组织
                    startActivity(new Intent(getActivity(),CooperativeOrganizationActivity.class));
                } else if (position == 5) {
                    //我的信用
                    startActivity(new Intent(getActivity(),MyCreditActivity.class));
                }
            }
        });
    }

    private void banner() {
        //设置样式,默认为:Banner.NOT_INDICATOR(不显示指示器和标题)
        //可选样式如下:
        //1. Banner.CIRCLE_INDICATOR    显示圆形指示器
        //2. Banner.NUM_INDICATOR   显示数字指示器
        //3. Banner.NUM_INDICATOR_TITLE 显示数字指示器和标题
        //4. Banner.CIRCLE_INDICATOR_TITLE  显示圆形指示器和标题
        grid_banner.setBannerStyle(Banner.CIRCLE_INDICATOR_TITLE);

        //设置轮播样式（没有标题默认为右边,有标题时默认左边）
        //可选样式:
        //Banner.LEFT   指示器居左
        //Banner.CENTER 指示器居中
        //Banner.RIGHT  指示器居右
        grid_banner.setIndicatorGravity(Banner.CENTER);

        //设置轮播要显示的标题和图片对应（如果不传默认不显示标题）
        // grid_banner.setBannerTitle(titles);

        //设置是否自动轮播（不设置则默认自动）
        grid_banner.isAutoPlay(true);

        //设置轮播图片间隔时间（不设置默认为2000）
        grid_banner.setDelayTime(1000);
        //设置图片资源:可选图片网址/资源文件，默认用Glide加载,也可自定义图片的加载框架
        //所有设置参数方法都放在此方法之前执行
        //banner.setImages(images);

        //自定义图片加载框架
        grid_banner.setImages(images, new Banner.OnLoadImageListener() {
            @Override
            public void OnLoadImage(ImageView view, Object url) {
                System.out.println("加载中");
                Glide.with(getActivity()).load(url).into(view);
                System.out.println("加载完");
            }
        });
        //设置点击事件，下标是从1开始
        grid_banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {//设置点击事件
            @Override
            public void OnBannerClick(View view, int position) {
                Toast.makeText(getActivity(), "你点击了：" + position, Toast.LENGTH_LONG).show();
            }
        });
    }


}