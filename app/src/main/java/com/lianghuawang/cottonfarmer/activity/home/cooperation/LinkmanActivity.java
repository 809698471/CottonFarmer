package com.lianghuawang.cottonfarmer.activity.home.cooperation;

import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.LinkmanAdapter;
import com.lianghuawang.cottonfarmer.entity.home.cooperation.Linkman;
import com.lianghuawang.cottonfarmer.netutils.GsonObjectCallback;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.netutils.OkHttp3Utils;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;
import com.lianghuawang.cottonfarmer.utils.API;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;
import com.lianghuawang.cottonfarmer.utils.SharedPreferencesUtil;

import java.io.IOException;

import butterknife.Bind;
import okhttp3.Call;

/**
 * 合作社页面
 */
public class LinkmanActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;


    private LinearLayoutManager mLayoutManager;
    private Linkman list;
    private LinkmanAdapter mAdapter;
    private SharedPreferencesUtil sp;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_linkman;
    }

    @Override
    protected void initView() {
        sp = SharedPreferencesUtil.newInstance(ConstantUtil.LOGINSP);
        initToolbar();
        showProgress();
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

    private void showProgress() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setRefreshing(true);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                initData();
            }
        });

        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
//                initData();
            }
        });
    }

    private void finishTask() {
        mAdapter.notifyData(list.getData());
        mAdapter.notifyDataSetChanged();
        if (mSwipeRefreshLayout.isRefreshing()){
            mSwipeRefreshLayout.setRefreshing(false);
        }
        LogUtils.d("adapter.size---" + mAdapter.getItemCount());
    }

    private void initData() {
        OkHttp3Utils.doGet(sp.getString(ConstantUtil.LOGINTOKEN,""), API.LINKMAN + "1", new GsonObjectCallback<Linkman>() {
            @Override
            public void onUi(Linkman linkman) {
                list = linkman;
                finishTask();
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }

    private void initRecylerView() {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new LinkmanAdapter(mRecyclerView, list == null ? null : list.getData());
        mRecyclerView.setAdapter(mAdapter);
    }
}
