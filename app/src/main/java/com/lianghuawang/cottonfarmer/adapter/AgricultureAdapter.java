package com.lianghuawang.cottonfarmer.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.entity.home.insurance.Insurance;
import com.lianghuawang.cottonfarmer.ui.base.AbsRecyclerViewAdapter;

import java.util.List;

public class AgricultureAdapter extends AbsRecyclerViewAdapter {

    private List<Insurance> insuranceList;

    public AgricultureAdapter(RecyclerView recyclerView, List<Insurance> insuranceList) {
        super(recyclerView);
        this.insuranceList = insuranceList;
    }

    @NonNull
    @Override
    public ClickableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(
                R.layout.activity_buy_insurance_include_adapter,parent,false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder){
            ItemViewHolder holde = (ItemViewHolder) holder;
            holde.title.setText(insuranceList.get(position).getTitle());
            holde.content.setText(insuranceList.get(position).getContent());
            holde.time.setText(insuranceList.get(position).getValidity());
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return insuranceList.size();
    }

    public void upData(List<Insurance> insuranceList){
        this.insuranceList = insuranceList;
    }

    public class ItemViewHolder extends ClickableViewHolder{

        private ImageView img;
        private TextView title,content,time;
        private Button btn;

        public ItemViewHolder(View itemView) {
            super(itemView);
            img = $(R.id.iv_item_view);
            title = $(R.id.tv_title);
            content = $(R.id.tv_content);
            time = $(R.id.tv_subscribe_time);
            btn = $(R.id.btn_subscribe);
        }
    }
}
