package com.lianghuawang.cottonfarmer.activity.home.insurance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.AgricultureAdapter;
import com.lianghuawang.cottonfarmer.entity.home.insurance.Insurance;
import com.lianghuawang.cottonfarmer.entity.home.insurance.InsuranceData;
import com.lianghuawang.cottonfarmer.netutils.APIUtils.BuyInsurance;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.ui.base.AbsRecyclerViewAdapter;
import com.lianghuawang.cottonfarmer.ui.base.BaseFragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;

public class AgricultureFragment extends BaseFragment {

    public static final String EXTRA_TYPE = "extra_type";

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private AgricultureAdapter mAdapter;

    private LinearLayoutManager mLayoutManager;

    private List<Insurance> list;

    public static AgricultureFragment newInstance(String type) {
        AgricultureFragment mFragment = new AgricultureFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_TYPE, type);
        mFragment.setArguments(bundle);
        return new AgricultureFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_insurance_agriculture;
    }

    @Override
    public void initViews() {
        list = InsuranceData.newInstance().getData();
        initRecyclerView();
        showProgress();
        particulars();
    }

    private void showProgress() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list = InsuranceData.newInstance().setAdd(list);
                Map<String,String> params = new HashMap<>();
                params.put("page","1");
                BuyInsurance.Builder()
                        .setPage()
                        .setParams(params)
                        .request()
                        .builder();

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

    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AgricultureAdapter(mRecyclerView, list);
        mRecyclerView.setAdapter(mAdapter);
    }

    //跳转到详情页面
    private void particulars() {
        mAdapter.setOnClickListener(new AgricultureAdapter.OnClickListener() {
            @Override
            public void setOnClickListener(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder) {
                startActivity(new Intent(getContext(), InsuranceParticularsActivity.class));
            }
        });
    }
}
