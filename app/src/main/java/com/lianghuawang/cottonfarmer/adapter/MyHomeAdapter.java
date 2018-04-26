package com.lianghuawang.cottonfarmer.adapter;

import android.content.Context;
import android.view.View;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseAdapter;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseHolder;

import java.util.List;

/**
 * 1.extends  把父类的代码继承过来。  可以少写很多代码。
 * 2.因为是全部拿来的代码，所以不是所有的代码都适合当前。对于不适合当前的代码（方法）
 * 我们可选择@Override 覆盖|重写
 */


public class MyHomeAdapter extends RecycleBaseAdapter<Bean> {
    Context context;

    public MyHomeAdapter(Context context, List<Bean> list) {
        super(R.layout.newstfragment_item, list);
    }

    @Override
    protected void convert(RecycleBaseHolder holder, Bean bean) {
        holder.setText(R.id.tv_cotton_risks, bean.getName());
        // holder.setText(R.id.item_tv_title, item).setImageResource(R.id.image, R.drawable.ic_default);
       //点击消息框，跳转相应链接
        holder.itemView.findViewById(R.id.newstfragment_item_rela).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}