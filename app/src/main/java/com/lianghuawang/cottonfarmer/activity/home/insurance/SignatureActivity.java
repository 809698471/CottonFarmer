package com.lianghuawang.cottonfarmer.activity.home.insurance;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.FileUtils;
import com.lianghuawang.cottonfarmer.widget.SignatureView;

import java.io.File;
import java.io.IOException;

import butterknife.Bind;

/**
 * 客户签字
 */
public class SignatureActivity extends BaseActivity{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.id_sign)
    SignatureView mSign;

    @Bind(R.id.rl_confirm_signature)
    RelativeLayout mRl;

    @Bind(R.id.iv_signature)
    ImageView mSignature;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_signature;
    }

    @Override
    protected void initView() {
        initTooble();
        initData();
    }

    private void initData() {
        mSign.setSignatureCallBack(new SignatureView.ISignatureCallBack() {
            @Override
            public void onSignCompeleted(View view, Bitmap bitmap) {
                String path = FileUtils.ImagePath();
                try {
                    mSign.save(path);
                } catch (IOException e) {
                    e.printStackTrace();
                    LogUtils.d("e---" + e.getMessage());
                }

                LogUtils.d("path---:" + path );
                mSign.setVisibility(View.GONE);
                mRl.setVisibility(View.VISIBLE);
                showImg(path);
            }
        });
    }

    private void showImg(String path) {
        mToolbar.setTitle("请确认签名");
        Glide.with(this).load(path).into(mSignature);
    }

    private void initTooble() {
        mToolbar.setTitle("请客户签名");
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null)
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.back1);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
