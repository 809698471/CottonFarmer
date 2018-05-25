package com.lianghuawang.cottonfarmer.activity.home.insurance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.AgricultureAdapter;
import com.lianghuawang.cottonfarmer.netutils.APIUtils.AgriculturalInsurance;
import com.lianghuawang.cottonfarmer.netutils.ToastUtils;
import com.lianghuawang.cottonfarmer.netutils.listener.APIListener;
import com.lianghuawang.cottonfarmer.ui.base.AbsRecyclerViewAdapter;
import com.lianghuawang.cottonfarmer.ui.base.BaseFragment;
import com.lianghuawang.cottonfarmer.netutils.instance.AgriculturalInsurances.DataBean;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;

import java.util.List;

import butterknife.Bind;

/**
 * 农业保险fragment
 */
public class AgricultureFragment extends BaseFragment implements AbsRecyclerViewAdapter.OnItemClickListener {

    public static final String EXTRA_TYPE = "extra_type";

    private List<DataBean> dataBeans;

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private AgricultureAdapter mAdapter;

    private LinearLayoutManager mLayoutManager;


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
        showProgress();
        initRecyclerView();
    }

    private void showProgress() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                getInsurance();
            }
        });
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getInsurance();
            }
        });
    }

    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AgricultureAdapter(mRecyclerView, dataBeans);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
    }

    private void getInsurance(){
        AgriculturalInsurance.Builder()
                .setPage()
                .setListener(new APIListener() {
                    @Override
                    public void onSuccess(Object object) {
                        dataBeans = (List<DataBean>) object;
                        finishTask();
                    }

                    @Override
                    public void onError(String message) {
                        ToastUtils.showLong(getContext(),message);
                        mSwipeRefreshLayout.post(new Runnable() {
                            @Override
                            public void run() {
                                mSwipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    }
                })
                .request()
                .builder();
    }

    private void finishTask(){
        mAdapter.upData(dataBeans);
        mAdapter.notifyDataSetChanged();
        if (mSwipeRefreshLayout.isRefreshing()){
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    //跳转到详情页面
    @Override
    public void onItemClick(int position, AbsRecyclerViewAdapter.ClickableViewHolder holder) {
        Intent intent = new Intent(getContext(), InsuranceParticularsActivity.class);
        intent.putExtra(ConstantUtil.INSURANCE,dataBeans.get(position));
        startActivity(intent);
    }
}
