package com.lianghuawang.cottonfarmer.activity.home.agriculturalMaterials;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.entity.home.agriculturalMaterials.Am;
import com.lianghuawang.cottonfarmer.ui.base.AbsRecyclerViewAdapter;

import java.util.List;

public class AMAdapter extends AbsRecyclerViewAdapter {

    private List<Am> list;

    public AMAdapter(RecyclerView recyclerView, List<Am> list) {
        super(recyclerView);
        this.list = list;
    }

    @NonNull
    @Override
    public ClickableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext())
        .inflate(R.layout.adapter_item_am,parent,false));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder ){
            ItemViewHolder holde = (ItemViewHolder) holder;
            holde.tit.setText(list.get(position).getTitle());
            holde.price.setText(list.get(position).getPrice());
            Glide.with(getContext()).load(list.get(position).getImgPath())
                    .placeholder(R.mipmap.bg_def)
                    .into(holde.img);
        }
        super.onBindViewHolder(holder, position);
    }

    public class ItemViewHolder extends ClickableViewHolder{

        public ImageView img;
        public TextView tit,price;

        public ItemViewHolder(View itemView) {
            super(itemView);

            img = $(R.id.item_img);
            tit = $(R.id.item_title);
            price = $(R.id.item_price);

        }
    }
}
