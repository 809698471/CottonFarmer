package com.lianghuawang.cottonfarmer.activity.my.bankcard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 2018/4/12.
 */

public class Adapter extends BaseAdapter {
    Context context;
    List<Card_Bean> card_beans = new ArrayList<>();
    private ViewHolder holder;

    public Adapter(Context context, List<Card_Bean> card_beans) {
        this.context = context;
        this.card_beans = card_beans;
    }

    @Override
    public int getCount() {
        return card_beans.size();
    }

    @Override
    public Object getItem(int position) {
        return card_beans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new ViewHolder();
            convertView=View.inflate(context, R.layout.lv_card_item,null);
            holder.icon_card=convertView.findViewById(R.id.icon_card);
     /*       holder.name_card=convertView.findViewById(R.id.name_card);
            holder.number_card=convertView.findViewById(R.id.number_card);*/
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        Card_Bean card_bean = card_beans.get(position);
        holder.icon_card.setImageResource(card_bean.getCard_icon());
/*        holder.name_card.setText(card_bean.getName());
        holder.number_card.setText(card_bean.getNumber_card());*/
        return convertView;
    }

    class ViewHolder {
        TextView name_card;
        ImageView icon_card;
        TextView number_card;
    }
}
