package com.lianghuawang.cottonfarmer.adapter;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseAdapter;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/4/20 0020.
 */

public class StagingDetailAdapter extends RecycleBaseAdapter<Bean> {
    public StagingDetailAdapter( List<Bean> list) {
        super(R.layout.stagingdetail_item, list);
    }

    @Override
    protected void convert(RecycleBaseHolder holder, Bean bean) {
        holder.setText(R.id.stagingdetail_item_tv, bean.getName());
        // holder.setText(R.id.item_tv_title, item).setImageResource(R.id.image, R.drawable.ic_default);


    }
}
