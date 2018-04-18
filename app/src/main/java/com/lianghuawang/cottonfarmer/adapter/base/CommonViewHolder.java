package com.lianghuawang.cottonfarmer.adapter.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/4/18 0018.
 */

public class CommonViewHolder {

    private SparseArray<View> views;
    private int postion;
    private View contertView;
    private Context context;

    /**
     * 构造方法，完成传统Adapter里的创建convertView对象
     */
    private CommonViewHolder(Context context, View contertView,ViewGroup parent,
                             int lagoutId, int postion) {
        this.context = context;
        this.views = new SparseArray<>();
        this.contertView = LayoutInflater.from(context).inflate(lagoutId,parent,false);
        this.postion = postion;

        this.contertView.setTag(this);
    }

    /**
     * 入口方法，完成传统Adapter里面实例化ViewHolder对象工作
     */
    public static CommonViewHolder getCommonViewHolder(Context context, View convertView, int layoutId,
                                                       ViewGroup parent, int position){
        if(convertView == null){
            return new CommonViewHolder(context,convertView,parent,layoutId,position);
        }else {
            CommonViewHolder commonViewHolder = (CommonViewHolder)convertView.getTag();
            /*由于ListView的复用,比如屏幕只显示5个Item,那么当下拉到第6个时会复用第1个的Item
             *所以这边需要更新position*/
            commonViewHolder.postion = position;
            return commonViewHolder;
        }
    }

    /**
     * 根据控件Id获取对应View对象
     */
    public  <T extends View> T getView(int viewId){
        View view = views.get(viewId);
        if(view == null){
            view = contertView.findViewById(viewId);
            views.put(viewId,view);
        }
        return (T)view;
    }

    /**
     * 返回设置好的ConvertView对象
     */
    public View getContertView(){
        return contertView;
    }

    /**
     *给TextView设置字符串
     */
    public CommonViewHolder setText(int viewId,String text){
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }

    /**
     *给ImageView设置图片资源
     */
    public CommonViewHolder setImageResource(int viewId,int drawableId){
        ImageView imageView = getView(viewId);
        imageView.setImageResource(drawableId);
        return this;
    }

}