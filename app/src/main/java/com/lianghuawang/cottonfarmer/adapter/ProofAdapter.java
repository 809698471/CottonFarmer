package com.lianghuawang.cottonfarmer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.entity.my.Proof;
import com.lianghuawang.cottonfarmer.netutils.instance.ProofInstance;
import com.lianghuawang.cottonfarmer.netutils.instance.ProofInstance.DataBean;
import com.lianghuawang.cottonfarmer.ui.base.AbsRecyclerViewAdapter;

import java.util.List;

public class ProofAdapter extends AbsRecyclerViewAdapter {

    private Context mContext;
    private List<DataBean> mData;

    public ProofAdapter(RecyclerView recyclerView, List<DataBean> mData) {
        super(recyclerView);
        this.mData = mData;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new ItemViewHolder(
                LayoutInflater.from(mContext).inflate(R.layout.proofitmeadapter,parent,false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, final int position) {
        if (holder instanceof ItemViewHolder){
            ItemViewHolder holde = (ItemViewHolder) holder;
            if (mData.get(position).getFlag() == -1){
                holde.bgs.setVisibility(View.VISIBLE);
                Glide.with(mContext).load(mData.get(position).getImg_url()).into(holde.bgs);
                holde.add.setVisibility(View.GONE);
                holde.del.setVisibility(View.VISIBLE);
            } else if (mData.get(position).getFlag() == 0){
                holde.bgs.setVisibility(View.GONE);
                holde.add.setVisibility(View.VISIBLE);
                holde.del.setVisibility(View.GONE);
            }
            holde.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addLinstener.addImage();
                }
            });
            holde.del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    delLinstener.delImage(position);
                }
            });
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void getData(List<DataBean> mData){
        this.mData = mData;
        notifyDataSetChanged();
    }

    private class ItemViewHolder extends ClickableViewHolder{

        public ImageView bgs,del,add;

        public ItemViewHolder(View itemView) {
            super(itemView);
            bgs = $(R.id.img_proof);
            del = $(R.id.img_del);
            add = $(R.id.img_add);
        }
    }


    private AddLinstener addLinstener;

    public void setAddLinstener(AddLinstener linstener){
        this.addLinstener = linstener;
    }

    private DelLinstener delLinstener;

    public void setDelLinstener(DelLinstener linstener){
        this.delLinstener = linstener;
    }

    public interface AddLinstener{
        void addImage();
    }

    public interface DelLinstener{
        void delImage(int position);
    }
}
