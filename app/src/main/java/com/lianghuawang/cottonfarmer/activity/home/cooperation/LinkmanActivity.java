package com.lianghuawang.cottonfarmer.activity.home.cooperation;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.CooperationAdapter;
import com.lianghuawang.cottonfarmer.entity.home.cooperation.Cooper;
import com.lianghuawang.cottonfarmer.entity.home.cooperation.CooperData;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import java.util.List;

import butterknife.Bind;

public class LinkmanActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;


    private LinearLayoutManager mLayoutManager;
    private List<Cooper> list;
    private CooperationAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_linkman;
    }

    @Override
    protected void initView() {
        initToolbar();
        initRecylerView();
    }

    private void initToolbar() {
        mToolbar.setTitle("合作社成员");
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

    private void initRecylerView() {
        list = CooperData.newInstance().init();
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CooperationAdapter(mRecyclerView, list);
        mRecyclerView.setAdapter(mAdapter);
    }
}
