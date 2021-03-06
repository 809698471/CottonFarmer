package com.lianghuawang.cottonfarmer.adapter.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/17 0017.
 * 封装的时候，部分参数可以选择由外部的构造函数或者set方法
 */

public class RecycleBaseAdapter<T> extends RecyclerView.Adapter<RecycleBaseHolder> {
    private List<T> mList = new ArrayList<>();
    private int layoutId;
    public RecycleBaseAdapter(int layoutId, List<T> list){
        this.layoutId=layoutId;
        this. mList=list;
    }
    //onCreateViewHolder用来给rv创建缓存
    @Override
    public RecycleBaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //参数3 判断条件 true  1.打气 2.添加到paraent
        // false 1.打气 （参考parent的宽度）
        View view =   LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        RecycleBaseHolder holder = new RecycleBaseHolder(view);
        return holder;
    }
    //onBindViewHolder给缓存控件设置数据
    @Override
    public void onBindViewHolder(RecycleBaseHolder holder, int position) {
        T item = mList.get(position);
        convert(holder,item);
    }
    protected void convert(RecycleBaseHolder holder, T item) {
        //什么都没有做
    }
    //获取记录数据
    @Override
    public int getItemCount() {
        return mList.size();
    }
}
