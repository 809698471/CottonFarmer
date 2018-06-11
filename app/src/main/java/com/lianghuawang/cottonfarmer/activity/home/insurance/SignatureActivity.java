package com.lianghuawang.cottonfarmer.activity.home.insurance;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.my.Qianming;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.FileUtils;
import com.lianghuawang.cottonfarmer.utils.PermissionUtil;
import com.lianghuawang.cottonfarmer.widget.SignatureView;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 客户签字
 */
public class SignatureActivity extends BaseActivity {

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

    private String Token;
    private String o_water;
    private String path;

    private static final int MY_PERMISSIONS_EXTERNAL = 1;

    private PermissionUtil p = PermissionUtil.newInstance(this, MY_PERMISSIONS_EXTERNAL);

    @Override
    protected int getLayoutId() {
        return R.layout.activity_signature;
    }

    @Override
    protected void initView() {
        Token = getIntent().getStringExtra(ConstantUtil.INTENTTOKEN);
        o_water = getIntent().getStringExtra("o_water");
        initTooble();
        initPermissiont();
        initData();
    }

    private void initPermissiont() {
        p.Build()
                .add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .setPermission(new PermissionUtil.Calls() {
                    @Override
                    public void GoOn(int key) {

                    }
                })
                .build();
    }

    private void initData() {
        mSign.setSignatureCallBack(new SignatureView.ISignatureCallBack() {
            @Override
            public void onSignCompeleted(View view, Bitmap bitmap) {
                path = FileUtils.ImagePath();
                try {
                    mSign.save(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }

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

    @OnClick({R.id.btn_chonglai, R.id.btn_error, R.id.btn_queren})
    public void onClick(Button btn) {
        switch (btn.getId()) {
            case R.id.btn_chonglai://重写
                mToolbar.setTitle("请客户签名");
                mSign.setVisibility(View.VISIBLE);
                mRl.setVisibility(View.GONE);
                break;
            case R.id.btn_error://返回
                this.finish();
                break;
            case R.id.btn_queren://确认
                //记录图片地址
                commit();
//                startActivity(new Intent(this, PayInsuranceActivity.class));
                break;
            default:
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        p.Call(requestCode, permissions, grantResults, new PermissionUtil.Call() {
            @Override
            public void succeed() {

            }

            @Override
            public void error(String permission) {
                SignatureActivity.this.finish();
            }
        });
    }

    private Map<String, Object> getParams(){
        File file = new File(path);
        Map<String,Object> params = new HashMap<>();
        params.put("o_water",o_water);
        params.put("images",file);
        return params;
    }

    private void commit(){
        OkHttp3Utils.sendImage(Token, Concat.QIANMING_URL, getParams(), new GsonObjectCallback<Qianming>() {
            @Override
            public void onUi(Qianming qianming) {
                if (qianming.isSuccess()){
                    Intent intent = new Intent(SignatureActivity.this,PayInsuranceActivity.class);
                    intent.putExtra(ConstantUtil.INTENTTOKEN,Token);
                    intent.putExtra("o_water",o_water);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
