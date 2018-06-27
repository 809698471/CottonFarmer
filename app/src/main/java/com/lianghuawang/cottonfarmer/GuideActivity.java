package com.lianghuawang.cottonfarmer;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lianghuawang.cottonfarmer.activity.HomePageActivity;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导页
 */

public class GuideActivity extends BaseActivity {
    private ViewPager viewPager;
    private List<View> mImageViews; // 滑动的图片集合
    private int[] imageResId; // 图片ID
    private int currentItem = 0; // 当前图片的索引号
    private GestureDetector gestureDetector; // 用户滑动
    /**
     * 记录当前分页ID
     */
    private int flaggingWidth;// 互动翻页所需滚动的长度是当前屏幕宽度的1/3

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView() {
        gestureDetector = new GestureDetector(new GuideViewTouch());
        // 获取分辨率
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        flaggingWidth = dm.widthPixels / 3;
        imageResId = new int[]
                {R.mipmap.yindaoye_1,R.mipmap.yindaoye_2, R.mipmap.yindaoye_3,R.mipmap.yindaoye_4};
        mImageViews = new ArrayList<View>();
        // 初始化图片资源
        LayoutInflater viewInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // 0
        View convertView0 = viewInflater.inflate(R.layout.guide_item, null);
        LinearLayout linearLayout0 = (LinearLayout) convertView0.findViewById(R.id.guide_item);
        linearLayout0.setBackgroundResource(imageResId[0]);
        mImageViews.add(linearLayout0);
        // 1
        View convertView1 = viewInflater.inflate(R.layout.guide_item, null);
        LinearLayout linearLayout1 = (LinearLayout) convertView1.findViewById(R.id.guide_item);
        linearLayout1.setBackgroundResource(imageResId[1]);
        mImageViews.add(linearLayout1);
        // 2
        View convertView2 = viewInflater.inflate(R.layout.guide_item, null);
        LinearLayout linearLayout2 = (LinearLayout) convertView2.findViewById(R.id.guide_item);
        linearLayout2.setBackgroundResource(imageResId[2]);
        mImageViews.add(linearLayout2);
        // 3
        View convertView3 = viewInflater.inflate(R.layout.guide_item, null);
        LinearLayout linearLayout3 = (LinearLayout) convertView3.findViewById(R.id.guide_item);
        linearLayout3.setBackgroundResource(imageResId[3]);
        mImageViews.add(linearLayout3);

        ImageView igm = (ImageView) convertView3.findViewById(R.id.start);
        igm.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                GoToMainActivity();
            }
        });

        viewPager = (ViewPager) findViewById(R.id.guide_view);
        viewPager.setAdapter(new MyAdapter());// 设置填充ViewPager页面的适配器
        // 设置一个监听器，当ViewPager中的页面改变时调用
        viewPager.setOnPageChangeListener(new MyPageChangeListener());
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (gestureDetector.onTouchEvent(event)) {
            event.setAction(MotionEvent.ACTION_CANCEL);
        }
        return super.dispatchTouchEvent(event);
    }

    private class GuideViewTouch extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (currentItem == 3) {
                if (Math.abs(e1.getX() - e2.getX()) > Math.abs(e1.getY() - e2.getY()) && (e1.getX() - e2.getX() <= (-flaggingWidth) || e1.getX() - e2.getX() >= flaggingWidth)) {
                    if (e1.getX() - e2.getX() >= flaggingWidth) {
                        GoToMainActivity();
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /**
     * 进入登录界面
     */
    void GoToMainActivity() {
        SharedPreferencesUtil sp = SharedPreferencesUtil.newInstance(ConstantUtil.STARTPAGE);
        sp.putBoolean(ConstantUtil.ISSTART,false);
        Intent intent = new Intent(GuideActivity.this, HomePageActivity.class);
        startActivity(intent);
        LogUtils.d("sp.putBoolean----:" + sp.getBoolean(ConstantUtil.ISSTART,true));
        finish();
    }

    /**
     * 当ViewPager中页面的状态发生改变时调用
     *
     * @author Administrator
     */
    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {
        public void onPageSelected(int position) {
            currentItem = position;
        }

        public void onPageScrollStateChanged(int arg0) {
        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }
    }

    /**
     * 填充ViewPager页面的适配器
     *
     * @author Administrator
     */
    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageResId.length;
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            ((ViewPager) arg0).addView(mImageViews.get(arg1));
            return mImageViews.get(arg1);
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {

        }

        @Override
        public void finishUpdate(View arg0) {

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            GoToMainActivity();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

}