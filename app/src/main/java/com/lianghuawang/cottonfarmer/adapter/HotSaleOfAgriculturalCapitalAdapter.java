package com.lianghuawang.cottonfarmer.adapter;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseAdapter;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/4/19 0019.
 */

public class HotSaleOfAgriculturalCapitalAdapter extends RecycleBaseAdapter<Bean> {
    public HotSaleOfAgriculturalCapitalAdapter(List<Bean> list) {
        super(R.layout.hotsaleofagriculturalcapital_item, list);
    }

    @Override
    protected void convert(RecycleBaseHolder holder, Bean bean) {
        holder.setText(R.id.hotsaleofagriculturalcapital_item_tv, bean.getName());

    }
}
