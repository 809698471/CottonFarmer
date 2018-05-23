package com.lianghuawang.cottonfarmer.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.ui.base.AbsRecyclerViewAdapter;
import com.lianghuawang.cottonfarmer.netutils.instance.AgriculturalInsurances.DataBean;

import java.util.List;

public class AgricultureAdapter extends AbsRecyclerViewAdapter {

    private List<DataBean> insuranceList;

    public AgricultureAdapter(RecyclerView recyclerView, List<DataBean> insuranceList) {
        super(recyclerView);
        this.insuranceList = insuranceList;
    }

    @NonNull
    @Override
    public ClickableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(
                R.layout.activity_buy_insurance_include_adapter,parent,false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, final int position) {
        if (holder instanceof ItemViewHolder){
            final ItemViewHolder holde = (ItemViewHolder) holder;
            holde.title.setText(insuranceList.get(position).getName());
            holde.content.setText(insuranceList.get(position).getDescribe());
            holde.time.setText(insuranceList.get(position).getStart_end_time());
            Glide.with(getContext()).load(insuranceList.get(position).getImage_url()).into(holde.img);
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return insuranceList == null ? 0 : insuranceList.size();
    }

    public void upData(List<DataBean> insuranceList){
        this.insuranceList = insuranceList;
    }

    public class ItemViewHolder extends ClickableViewHolder{

        private ImageView img;
        private TextView title,content,time;
//        private Button btn;

        public ItemViewHolder(View itemView) {
            super(itemView);
            img = $(R.id.iv_item_view);
            title = $(R.id.tv_title);
            content = $(R.id.tv_content);
            time = $(R.id.tv_subscribe_time);
//            btn = $(R.id.btn_subscribe);
        }
    }

    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{

        void setOnClickListener(int position, ClickableViewHolder holder);
    }
}
