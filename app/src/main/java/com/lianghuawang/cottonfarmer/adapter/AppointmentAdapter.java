package com.lianghuawang.cottonfarmer.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.ReservationProgressActivity;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseAdapter;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/4/20 0020.
 */

public class AppointmentAdapter extends RecycleBaseAdapter<Bean> {
    Context context;

    public AppointmentAdapter(Context context, List<Bean> list) {
        super(R.layout.appointmentfragment_item, list);
        this.context = context;
    }

    @Override
    protected void convert(RecycleBaseHolder holder, Bean bean) {
        holder.setText(R.id.appointmentfragment_item_tv, bean.getName());
        // holder.setText(R.id.item_tv_title, item).setImageResource(R.id.image, R.drawable.ic_default);
        //查看进度
        holder.itemView.findViewById(R.id.appointmentfragment_item_lin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ReservationProgressActivity.class));
            }
        });

    }
}
