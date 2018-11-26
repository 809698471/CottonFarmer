package com.lianghuawang.cottonfarmer.adapter;

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
import com.lianghuawang.cottonfarmer.config.Concat;
import com.lianghuawang.cottonfarmer.entity.home.news.News;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.ui.base.AbsRecyclerViewAdapter;

import java.util.List;


/**
 * Created by Administrator on 2018/5/18 0018.
 */

public class NewsAndInformationAdapter extends AbsRecyclerViewAdapter {
    private List<News.DataBean> mNews;
    Context mContext;

    public NewsAndInformationAdapter(RecyclerView recyclerView) {
        super(recyclerView);
    }

    @NonNull
    @Override
    public ClickableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LogUtils.d("viewType---" + viewType);
        mContext = parent.getContext();
        return new ViewHolder(LayoutInflater
                .from(mContext)
                .inflate(R.layout.newsandinformation_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            ViewHolder holde = (ViewHolder) holder;
            holde.mTitle.setText(mNews.get(position).getTitle());
            holde.mTime.setText(mNews.get(position).getCreated_at());
            Glide.with(mContext)
                    .load(Concat.IMAGE_URL + mNews.get(position).getImg_url())
                    .error(R.mipmap.img2)
                    .into(holde.mIcon);
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return mNews == null ? 0 : mNews.size();
    }

    public void notifyData(List<News.DataBean> mNews){
        this.mNews = mNews;
        notifyDataSetChanged();
    }

    public class ViewHolder extends ClickableViewHolder {

        public TextView mTitle,mTime;
        public ImageView mIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = $(R.id.tv_news_item_title);
            mTime = $(R.id.tv_news_item_time);
            mIcon = $(R.id.iv_news_item_icon);
        }
    }
}
