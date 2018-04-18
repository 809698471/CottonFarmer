package com.lianghuawang.cottonfarmer.adapter.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/4/18 0018.
 */

public abstract class CommonAdapter<T> extends BaseAdapter {
    private Context context;
    private List<T> list;
    private int layoutId;

    public CommonAdapter(Context context, List<T> list,int layoutId) {
        this.context = context;
        this.list = list;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return list == null ? 0:list.size();
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommonViewHolder commonViewHolder = CommonViewHolder.getCommonViewHolder(context,convertView,layoutId,parent,position);
        convert(commonViewHolder,getItem(position));
        return commonViewHolder.getContertView();
    }

    public abstract void convert(CommonViewHolder holder,T item);

}