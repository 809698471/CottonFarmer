package com.lianghuawang.cottonfarmer.adapter;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseAdapter;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseHolder;

import java.util.List;


/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class MassifInformationListAdapter extends RecycleBaseAdapter<Bean> {
    public MassifInformationListAdapter(List<Bean> list) {
        super(R.layout.massifinformationlistadapter_item, list);
    }

    @Override
    protected void convert(RecycleBaseHolder holder, Bean bean) {
        holder.setText(R.id.massifinformationadapter_sucheng, bean.getName());

    }
}
