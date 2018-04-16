package com.lianghuawang.cottonfarmer.activity.home.agriculturalMaterials;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.entity.home.agriculturalMaterials.Am;
import com.lianghuawang.cottonfarmer.entity.home.agriculturalMaterials.AmData;
import com.lianghuawang.cottonfarmer.ui.base.BaseFragment;

import java.util.List;

import butterknife.Bind;

public class AMFragment extends BaseFragment {

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private final static String EXTRA_TYPE = "extra_type";

    private String type;

    private StaggeredGridLayoutManager mLayoutManager;

    private AMAdapter mAdapter;

    public static AMFragment newInstance(String type){
        AMFragment amFragment = new AMFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_TYPE, type);
        amFragment.setArguments(bundle);
        return amFragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_am;
    }

    @Override
    public void initViews() {
        type = getArguments().getString(EXTRA_TYPE);
        initRecyclerView();
        showProgress();
        particulars();
    }

    private void initRecyclerView() {
        List<Am> ams = AmData.newInstance().init();
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AMAdapter(mRecyclerView, ams);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void showProgress() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.notifyDataSetChanged();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
    }

    private void particulars() {

    }
}
