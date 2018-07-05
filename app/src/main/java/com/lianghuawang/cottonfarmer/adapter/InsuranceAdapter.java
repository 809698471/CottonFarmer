package com.lianghuawang.cottonfarmer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.entity.my.InsuranceEntity;
import com.lianghuawang.cottonfarmer.netutils.LogUtils;
import com.lianghuawang.cottonfarmer.ui.base.AbsRecyclerViewAdapter;

import java.util.List;

/**
 * create by fanwenke at 2018/7/4
 * 历年保险记录adapter
 */
public class InsuranceAdapter extends AbsRecyclerViewAdapter {

    private Context mContext;
    private List<InsuranceEntity.DataBean> mData;

    public InsuranceAdapter(RecyclerView recyclerView, List<InsuranceEntity.DataBean> mData) {
        super(recyclerView);
        this.mData = mData;
    }

    private OnClickItemDel mOnClickItemDel;
    private OnClickItemUpdata onClickItemUpdata;

    @NonNull
    @Override
    public ClickableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new ViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.adapter_insurance_purchase, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder holde = (ViewHolder) holder;
            holde.mDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnClickItemDel != null) {
                        mOnClickItemDel.DelItem(position, mData.get(position));
                    }
                }
            });
            holde.mYear.setText(mData.get(position).getYear() + "");
            holde.mArea.setText(mData.get(position).getIns_area() + "");
            holde.mTypes.setText(mData.get(position).getRisk_name());
        }
        super.onBindViewHolder(holder, position);

        holder.getParentView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickItemUpdata != null){
                    onClickItemUpdata.updata(position,mData.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.mData == null ? 0 : this.mData.size();
    }

    public void notifyData(List<InsuranceEntity.DataBean> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    public class ViewHolder extends ClickableViewHolder {
        public LinearLayout mDel;
        public TextView mYear, mTypes, mArea;

        public ViewHolder(View itemView) {
            super(itemView);
            mDel = $(R.id.ll_insurance_del);
            mYear = $(R.id.tv_insurance_year);
            mTypes = $(R.id.tv_insurance_types);
            mArea = $(R.id.tv_insurance_area);
        }
    }

    public interface OnClickItemDel {
        void DelItem(int position, InsuranceEntity.DataBean dataBean);
    }

    public void OnClickItmeDel(OnClickItemDel mOnClickItemDel) {
        this.mOnClickItemDel = mOnClickItemDel;
    }

    public interface OnClickItemUpdata {
        void updata(int positon, InsuranceEntity.DataBean dataBean);
    }

    public void setOnclickItemUpdata(OnClickItemUpdata onclickItemUpdata){
        this.onClickItemUpdata = onclickItemUpdata;
    }
}
