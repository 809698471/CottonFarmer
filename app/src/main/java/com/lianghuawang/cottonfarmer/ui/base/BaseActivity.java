package com.lianghuawang.cottonfarmer.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.mvp.base.BaseView;
import com.lianghuawang.cottonfarmer.utils.MeasureUtil;
import com.lianghuawang.cottonfarmer.widget.LoadingDialog;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private LoadingDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        //设置沉浸式
        QMUIStatusBarHelper.translucent(this);
        initView();
        initToolbar();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    private void initToolbar() {

        // 针对父布局非DrawerLayout的状态栏处理方式
        // 设置toolbar上面的View实现类状态栏效果，这里是因为状态栏设置为透明的了，而默认背景是白色的，不设的话状态栏处就是白色
        final View statusView = findViewById(R.id.status_view);
        if (statusView != null) {
            statusView.getLayoutParams().height = MeasureUtil.getStatusBarHeight(this);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            // 24.0.0版本后导航图标会有默认的与标题的距离，这里设置去掉
            toolbar.setContentInsetStartWithNavigation(0);
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
            toolbar.setNavigationIcon(R.drawable.back1);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) toolbar.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, MeasureUtil.getStatusBarHeight(this),
                    layoutParams.rightMargin,layoutParams.bottomMargin);
            toolbar.setLayoutParams(layoutParams);
//            toolbar.getLayoutParams().height = MeasureUtil.getStatusBarHeight(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    public void showLoadingDialog(Activity activity){
        LoadingDialog.Builder builder=new LoadingDialog.Builder(activity)
                .setMessage("加载中...")
                .setCancelable(false);
        dialog=builder.create();
        dialog.show();
    }

    public void dismissdingDialog(){
        if (dialog != null){
            dialog.dismiss();
        }
    }
}
