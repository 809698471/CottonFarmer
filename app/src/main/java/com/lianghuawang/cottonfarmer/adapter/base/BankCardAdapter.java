package com.lianghuawang.cottonfarmer.adapter.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.entity.my.CardList;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.ui.base.AbsRecyclerViewAdapter;

import java.util.List;

public class BankCardAdapter extends AbsRecyclerViewAdapter {

    private List<CardList.DataBean> dataBeans;
    private Context context;

    public BankCardAdapter(RecyclerView recyclerView, List<CardList.DataBean> dataBeans) {
        super(recyclerView);
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public ClickableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new ItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bank_card_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder holde = (ItemViewHolder) holder;
            Glide.with(context)
                    .load(dataBeans.get(position).getBankImg())
                    .into(holde.icon);
            String card = substring(dataBeans.get(position).getBank_card());
            holde.number.setText(card);
        }
        super.onBindViewHolder(holder, position);
    }

    public String substring(String str) {
//        for (int i  = 0; i < )
        LogUtils.d(7/2 + "--3/2");
        LogUtils.d(7%2 + "--3%2");
        LogUtils.d("卡号前四位: "+ str.substring(0,3));
        String cardName = "";
        if (str.length() % 4 == 0){
            for (int i = 0; i < str.length() / 4 - 1; i++){
                cardName = cardName + "**** ";
            }
            cardName = cardName + str.substring(str.length() - 4, str.length());
        } else {
            for (int i = 0; i < str.length() / 4; i++) {
                cardName = cardName + "**** ";
            }
            cardName = cardName + str.substring(str.length() - str.length() % 4, str.length());
        }
        return cardName;
    }

    @Override
    public int getItemCount() {
        return dataBeans == null ? 0 : dataBeans.size();
    }

    public void getBankList(List<CardList.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
        notifyDataSetChanged();
    }

    public class ItemViewHolder extends ClickableViewHolder {

        public ImageView icon;
        public TextView number;

        public ItemViewHolder(View itemView) {
            super(itemView);
            icon = $(R.id.img_bank_icon);
            number = $(R.id.tv_bank_number);
        }
    }
}
