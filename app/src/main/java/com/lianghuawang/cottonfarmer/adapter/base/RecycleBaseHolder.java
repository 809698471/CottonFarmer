package com.lianghuawang.cottonfarmer.adapter.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/4/17 0017.
 * 抽取BaseHolder继承RecyclerView.ViewHolder
 */


public class RecycleBaseHolder extends RecyclerView.ViewHolder {
    //不写死控件变量，而采用Map方式
    private HashMap<Integer, View> mViews = new HashMap<>();
    public RecycleBaseHolder(View itemView) {
        super(itemView);
    }
    /**
     *获取控件的方法
     */
    public<T> T getView(Integer viewId){
        //根据保存变量的类型 强转为该类型
        View view = mViews.get(viewId);
        if(view==null){
            view= itemView.findViewById(viewId);
            //缓存
            mViews.put(viewId,view);
        }
        return (T)view;
    }
    /**
     *传入文本控件id和设置的文本值，设置文本
     */
    public RecycleBaseHolder setText(Integer viewId, String value){
        TextView textView = getView(viewId);
        if (textView != null) {
            textView.setText(value);
        }
        return this;
    }
    /**
     * 传入图片控件id和资源id，设置图片
     */
    public RecycleBaseHolder setImageResource(Integer viewId, Integer resId) {
        ImageView imageView = getView(viewId);
        if (imageView != null) {
            imageView.setImageResource(resId);
        }
        return this;
    }
    //...还可以扩展出各种控件。
    //Fluent API 链式api  obj.setxxx().setyyy()....
}
