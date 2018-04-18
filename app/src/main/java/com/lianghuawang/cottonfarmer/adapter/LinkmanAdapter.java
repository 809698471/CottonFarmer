package com.lianghuawang.cottonfarmer.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.entity.home.cooperation.Linkman;
import com.lianghuawang.cottonfarmer.ui.base.AbsRecyclerViewAdapter;

import java.util.List;

public class LinkmanAdapter extends AbsRecyclerViewAdapter {

    private List<Linkman.DataBean> list;

    public LinkmanAdapter(RecyclerView recyclerView, List<Linkman.DataBean> list) {
        super(recyclerView);
        this.list = list;
    }

    @NonNull
    @Override
    public ClickableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext())
        .inflate(R.layout.adatper_linkman,parent,false));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder){
            ItemViewHolder holde = (ItemViewHolder) holder;
            holde.textView.setText(list.get(position).getUsername());
            holde.textView1.setText(list.get(position).getMobile_phone());
        }
        super.onBindViewHolder(holder, position);
    }

    public class ItemViewHolder extends ClickableViewHolder {

        ImageView imageView;
        TextView textView,textView1;

        public ItemViewHolder(View itemView) {
            super(itemView);
            imageView = $(R.id.imageView);
            textView = $(R.id.textView);
            textView1 = $(R.id.textView2);
        }
    }
}
