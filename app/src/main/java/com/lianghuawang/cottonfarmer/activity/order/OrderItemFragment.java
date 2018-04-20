package com.lianghuawang.cottonfarmer.activity.order;

import android.os.Bundle;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.BaseFragment;

public class OrderItemFragment extends BaseFragment {

    public static final String EXTRA_TYPE = "extra_type";

    public static OrderItemFragment newInstance(String type){
        OrderItemFragment mFragment = new OrderItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_TYPE, type);
        mFragment.setArguments(bundle);
        return new OrderItemFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_itme_order;
    }

    @Override
    public void initViews() {

    }
}
