package com.lianghuawang.cottonfarmer.adapter;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseAdapter;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/4/18 0018.
 */

public class BookIncomeFragmentAdapter extends RecycleBaseAdapter<Bean> {

    public BookIncomeFragmentAdapter(List<Bean> list) {
        super(R.layout.bookincomefragment_item, list);
    }

    @Override
    protected void convert(RecycleBaseHolder holder, Bean bean) {
        holder.setText(R.id.item_tv_expenditure,bean.getName());
        // holder.setText(R.id.item_tv_title, item).setImageResource(R.id.image, R.drawable.ic_default);


    }
}
