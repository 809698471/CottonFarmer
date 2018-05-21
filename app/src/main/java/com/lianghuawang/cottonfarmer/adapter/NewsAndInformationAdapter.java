package com.lianghuawang.cottonfarmer.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.home.RecommendationInformationActivity;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseAdapter;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseHolder;

import java.util.List;


/**
 * Created by Administrator on 2018/5/18 0018.
 */

public class NewsAndInformationAdapter extends RecycleBaseAdapter<Bean> {
    Context context;
    public NewsAndInformationAdapter(Context context,List<Bean> list) {
        super(R.layout.newsandinformation_item, list);
        this.context = context;
    }

    @Override
    protected void convert(RecycleBaseHolder holder, Bean bean) {
        holder.setText(R.id.time, bean.getName());
        //推荐资讯
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, RecommendationInformationActivity.class));
            }
        });
    }
}
