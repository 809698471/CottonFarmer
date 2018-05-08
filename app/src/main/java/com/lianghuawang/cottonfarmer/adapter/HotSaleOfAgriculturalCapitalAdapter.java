package com.lianghuawang.cottonfarmer.adapter;

import android.content.Context;
import android.view.View;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseAdapter;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/4/19 0019.
 */

public class HotSaleOfAgriculturalCapitalAdapter extends RecycleBaseAdapter<Bean> {
    Context context;

    public HotSaleOfAgriculturalCapitalAdapter(Context context, List<Bean> list) {
        super(R.layout.hotsaleofagriculturalcapital_item, list);
        this.context = context;
    }

    @Override
    protected void convert(RecycleBaseHolder holder, Bean bean) {
        holder.setText(R.id.hotsaleofagriculturalcapital_item_tv, bean.getName());
        //热销农资----商品详情
        holder.itemView.findViewById(R.id.hotsaleofagriculturalcapital_item_lin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
