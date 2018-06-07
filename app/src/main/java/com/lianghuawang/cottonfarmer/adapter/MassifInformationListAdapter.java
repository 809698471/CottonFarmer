package com.lianghuawang.cottonfarmer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.entity.my.DiKuaiList;
import com.lianghuawang.cottonfarmer.ui.base.AbsRecyclerViewAdapter;

import java.util.List;


/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class MassifInformationListAdapter extends AbsRecyclerViewAdapter {

    private Context context;
    private List<DiKuaiList.DataBean> dataBeans;
    private OnItemDelListener listener;

    public MassifInformationListAdapter(RecyclerView recyclerView, List<DiKuaiList.DataBean> dataBeans) {
        super(recyclerView);
        this.dataBeans = dataBeans;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ItemViewHolder(LayoutInflater.from(context)
        .inflate(R.layout.massifinformationlistadapter_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, final int position) {
        if (holder instanceof ItemViewHolder){
            ItemViewHolder holde = (ItemViewHolder) holder;
            holde.sucheng.setText(dataBeans.get(position).getVulgo());
            holde.dihao.setText(dataBeans.get(position).getLand_num());
            holde.jingdu.setText(dataBeans.get(position).getLongitude());
            holde.weidu.setText(dataBeans.get(position).getLatitude());
            holde.del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.delItem(position,dataBeans.get(position).getId());
                }
            });
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return dataBeans == null ? 0 : dataBeans.size();
    }

    public void getData(List<DiKuaiList.DataBean> dataBeans){
        this.dataBeans = dataBeans;
        notifyDataSetChanged();
    }

    public class ItemViewHolder extends ClickableViewHolder{

        public TextView dihao,sucheng,jingdu,weidu;
        public ImageView del;

        public ItemViewHolder(View itemView) {
            super(itemView);
            dihao = $(R.id.tv_dihao);
            sucheng = $(R.id.tv_sucheng);
            jingdu = $(R.id.tv_jingdu);
            weidu = $(R.id.tv_weidu);
            del = $(R.id.iv_del);
        }
    }

    public interface OnItemDelListener{
        void delItem(int position, int id);
    }

    public void setListener(OnItemDelListener listener){
        this.listener = listener;
    }

}
