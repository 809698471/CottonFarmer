package com.lianghuawang.cottonfarmer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2018/4/8.
 */

public class GridAdapter extends BaseAdapter {
    Context context;
    List<Bean> beans = new ArrayList<>();
    private ViewHolder holder;

    public GridAdapter(Context context, List<Bean> beans) {
        this.context = context;
        this.beans = beans;
    }

    @Override
    public int getCount() {
        return beans.size();
    }

    @Override
    public Object getItem(int position) {
        return beans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.grid_item, null);
            holder.icon=convertView.findViewById(R.id.item_iamge);
            holder.name=convertView.findViewById(R.id.item_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Bean bean = beans.get(position);
        holder.icon.setImageResource(bean.getImage());
        holder.name.setText(bean.getName().toString());
        return convertView;
    }

    class ViewHolder {
        ImageView icon;
        TextView name;
    }
}
