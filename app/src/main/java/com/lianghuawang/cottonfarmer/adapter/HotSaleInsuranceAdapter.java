package com.lianghuawang.cottonfarmer.adapter;

import android.content.Intent;
import android.view.View;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.activity.home.HotSaleInsuranceActivity;
import com.lianghuawang.cottonfarmer.activity.home.insurance.InsuranceParticularsActivity;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseAdapter;
import com.lianghuawang.cottonfarmer.adapter.base.RecycleBaseHolder;

import java.util.List;

/**
 * Created by Administrator on 2018/4/19 0019.
 */

public class HotSaleInsuranceAdapter extends RecycleBaseAdapter<Bean> {
    HotSaleInsuranceActivity hotSaleInsuranceActivity;

    public HotSaleInsuranceAdapter(HotSaleInsuranceActivity hotSaleInsuranceActivity, List<Bean> list) {
        super(R.layout.hotsaleinsurance_item, list);
        this.hotSaleInsuranceActivity = hotSaleInsuranceActivity;
    }

    @Override
    protected void convert(RecycleBaseHolder holder, Bean bean) {
        holder.setText(R.id.hotsaleinsurance_item_tv, bean.getName());
        // holder.setText(R.id.item_tv_title, item).setImageResource(R.id.image, R.drawable.ic_default);
       //跳转到购买保险---详情页面
        holder.itemView.findViewById(R.id.hotsaleinsurance_item_lin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hotSaleInsuranceActivity.startActivity(new Intent(hotSaleInsuranceActivity,InsuranceParticularsActivity.class));
//                hotSaleInsuranceActivity.finish();
            }
        });

    }
}
