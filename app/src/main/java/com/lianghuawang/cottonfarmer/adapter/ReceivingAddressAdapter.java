package com.lianghuawang.cottonfarmer.adapter;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseAdapter;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1 0001.
 */

public class ReceivingAddressAdapter extends RecycleBaseAdapter<Bean> {
    public ReceivingAddressAdapter(List<Bean> list) {
        super(R.layout.receivingaddressadapter_item, list);
    }

    @Override
    protected void convert(RecycleBaseHolder holder, Bean bean) {
        holder.setText(R.id.dizhi, bean.getName());

    }
}
