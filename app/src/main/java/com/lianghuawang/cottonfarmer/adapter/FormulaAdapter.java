package com.lianghuawang.cottonfarmer.adapter;

import android.content.Context;
import android.view.View;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseAdapter;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/4/24 0024.
 */

public class FormulaAdapter extends RecycleBaseAdapter<Bean> {
    Context context;

    public FormulaAdapter(Context context, List<Bean> list) {
        super(R.layout.formulafragment_item, list);
    }

    @Override
    protected void convert(RecycleBaseHolder holder, Bean bean) {
        holder.setText(R.id.formulafragment_item_text, bean.getName());
        // holder.setText(R.id.item_tv_title, item).setImageResource(R.id.image, R.drawable.ic_default);
        //具体详情
        holder.itemView.findViewById(R.id.formulafragment_item_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //点击消息框，跳转相应链接
        holder.itemView.findViewById(R.id.formulafragment_item_lin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
