package com.lianghuawang.cottonfarmer.adapter.base;

import android.content.Context;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;

import java.util.List;

/**
 * Created by Administrator on 2018/4/18 0018.
 */

public class MyCommonAdapter extends CommonAdapter<Bean> {
    public MyCommonAdapter(Context context, List<Bean> list, int layoutId) {
        super(context, list, layoutId);
    }

    @Override
    public void convert(CommonViewHolder holder, Bean item) {
        holder.setText(R.id.title_tv,item.getName());
//                .setImageResource(R.id.imageview,R.drawable.phone);
    }
}
