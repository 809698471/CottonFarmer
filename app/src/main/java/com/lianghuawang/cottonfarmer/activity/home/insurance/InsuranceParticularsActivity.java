package com.lianghuawang.cottonfarmer.activity.home.insurance;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;

import butterknife.Bind;
import butterknife.OnClick;

public class InsuranceParticularsActivity extends BaseActivity{

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.tv_ins_par_content)
    TextView content;

    @Bind(R.id.cb_argeed)
    CheckBox mCheck;

    @Bind(R.id.btn_argeed)
    Button mArgeed;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_buy_insurance_particulars;
    }

    @Override
    protected void initView() {
        initToolbar();
        initData();
    }

    private void initToolbar() {
        mToolbar.setTitle("保险名称");
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

    private void initData(){
        content.setText(ConstantUtil.TEST);
    }

    @OnClick(R.id.cb_argeed)
    public void click(CheckBox checkBox){
        if (checkBox.isChecked()){
            mArgeed.setEnabled(true);
        } else {
            mArgeed.setEnabled(false);
        }
    }

    @OnClick(R.id.btn_argeed)
    public void btnClick(Button button){
        startActivity(new Intent(this,InsuranceOrderActivity.class));
    }
}
