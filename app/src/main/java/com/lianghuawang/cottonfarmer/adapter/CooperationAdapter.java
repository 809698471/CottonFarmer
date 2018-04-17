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
import com.lianghuawang.cottonfarmer.entity.home.cooperation.Cooper;
import com.lianghuawang.cottonfarmer.entity.home.insurance.Insurance;
import com.lianghuawang.cottonfarmer.ui.base.AbsRecyclerViewAdapter;

import java.util.List;

public class CooperationAdapter extends AbsRecyclerViewAdapter {

    private List<Cooper> insuranceList;

    public CooperationAdapter(RecyclerView recyclerView, List<Cooper> insuranceList) {
        super(recyclerView);
        this.insuranceList = insuranceList;
    }

    @NonNull
    @Override
    public ClickableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(
                R.layout.adapter_cooperative,parent,false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, final int position) {
        if (holder instanceof ItemViewHolder){
            final ItemViewHolder holde = (ItemViewHolder) holder;
            holde.content.setText(insuranceList.get(position).getContent());
            holde.time.setText(insuranceList.get(position).getTime());
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return insuranceList.size();
    }

    public void upData(List<Cooper> insuranceList){
        this.insuranceList = insuranceList;
    }

    public class ItemViewHolder extends ClickableViewHolder{

        private ImageView img;
        private TextView content,time;

        public ItemViewHolder(View itemView) {
            super(itemView);
            img = $(R.id.iv_coop_view);
            content = $(R.id.tv_coop_content);
            time = $(R.id.tv_coop_time);
        }
    }
}
