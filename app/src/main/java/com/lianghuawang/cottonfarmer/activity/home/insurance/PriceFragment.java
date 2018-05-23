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
import com.lianghuawang.cottonfarmer.netutils.instance.AgriculturalInsurances.DataBean;
import com.lianghuawang.cottonfarmer.netutils.listener.APIListener;
import com.lianghuawang.cottonfarmer.ui.base.AbsRecyclerViewAdapter;
import com.lianghuawang.cottonfarmer.ui.base.BaseFragment;

import java.util.List;

import butterknife.Bind;

/**
 * 价格保险fragment
 */
public class PriceFragment extends BaseFragment {

    public static final String EXTRA_TYPE = "extra_type";

    private List<DataBean> dataBeans;

    @Bind(R.id.recycle)
    RecyclerView mRecyclerView;

    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private AgricultureAdapter mAdapter;

    private LinearLayoutManager mLayoutManager;


    public static PriceFragment newInstance(String type) {
        PriceFragment mFragment = new PriceFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_TYPE, type);
        mFragment.setArguments(bundle);
        return new PriceFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_insurance_agriculture;
    }

    @Override
    public void initViews() {
        initRecyclerView();
        showProgress();
        particulars();
    }

    private void showProgress() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                AgriculturalInsurance.Builder()
                        .setPage()
                        .setListener(new APIListener() {
                            @Override
                            public void onSuccess(Object object) {
                                dataBeans = (List<DataBean>) object;
                            }

                            @Override
                            public void onError(String message) {
                                ToastUtils.showLong(getContext(),message);
                            }
                        })
                        .request()
                        .builder();

                mSwipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.upData(dataBeans);
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
        mAdapter = new AgricultureAdapter(mRecyclerView, dataBeans);
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
