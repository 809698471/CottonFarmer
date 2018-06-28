package com.lianghuawang.cottonfarmer.activity.order;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.entity.oder.OrderAll;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.ui.base.BaseFragment;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;

import java.util.List;

import butterknife.Bind;

public class OrderItemFragment extends BaseFragment {

    public static final String EXTRA_TYPE = "extra_type";

    @Bind(R.id.tv_state)
    TextView mTvState;

    @Bind(R.id.btn_state)
    Button mBtnState;

    private int type;

    public static OrderItemFragment newInstance(int type, List<OrderAll.DataBean> dataBeans){
        OrderItemFragment mFragment = new OrderItemFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_TYPE, type);
        mFragment.setArguments(bundle);
        return mFragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_itme_order;
    }

    @Override
    public void initViews() {
        type = getArguments().getInt(EXTRA_TYPE);
        LogUtils.d("type---:" + type);
        switch (type){
            case ConstantUtil.ALL:
                mTvState.setText("已支付");
                mBtnState.setText("预约完成");
                break;
            case ConstantUtil.NON_PAYMENT:
                mTvState.setText("待付款");
                mBtnState.setText("去支付");
                break;
            case ConstantUtil.PAYMENT_HAS_BEEN:
                mTvState.setText("已支付");
                mBtnState.setText("预约完成");
                break;
            case ConstantUtil.HAS_BEEN_COMPLETED:
                mTvState.setText("已收货");
                mBtnState.setText("查看订单");
                break;
        }

    }
}
