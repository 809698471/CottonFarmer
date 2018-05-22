package com.lianghuawang.cottonfarmer.activity.home.cooperation;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.CooperationAdapter;
import com.lianghuawang.cottonfarmer.entity.home.cooperation.Cooper;
import com.lianghuawang.cottonfarmer.entity.home.cooperation.CooperData;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

//合作组织
public class CooperativeOrganizationActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.tv_bar_title)
    TextView mBarTitle;

    @Bind(R.id.iv_coop_banner)
    ImageView mBanner;

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;


    private LinearLayoutManager mLayoutManager;
    private List<Cooper> list;
    private CooperationAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_cooperative_organization;
    }

    @Override
    protected void initView() {
        initToolbar();
        initBanner();
        initRecyclerView();
    }

    private void initToolbar() {
        mToolbar.setTitle("");
        mBarTitle.setText("小棉袄合作社");
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

    private void initBanner() {
        mBanner.setBackgroundResource(R.mipmap.coop_banner);
    }

    private void initRecyclerView() {
        list = CooperData.newInstance().init();
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CooperationAdapter(mRecyclerView, list);
        mRecyclerView.setAdapter(mAdapter);
    }

    @OnClick({R.id.btn_team})
    public void onClick(Button btn){
        switch (btn.getId()){
            case R.id.btn_team:
                startActivity(new Intent(CooperativeOrganizationActivity.this,LinkmanActivity.class));
                break;
        }
    }
}
