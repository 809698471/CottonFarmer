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
import com.lianghuawang.cottonfarmer.entity.oder.OrderAll;
import com.lianghuawang.cottonfarmer.ui.base.AbsRecyclerViewAdapter;
import com.lianghuawang.cottonfarmer.utils.ConstantUtil;

import java.util.ArrayList;
import java.util.List;

public class OrderItemFragemntAdapter extends AbsRecyclerViewAdapter {

    private Context mContext;
    private int type;
    private List<OrderAll.DataBean> dataBeans;

    public OrderItemFragemntAdapter(RecyclerView recyclerView, int type, List<OrderAll.DataBean> dataBeans) {
        super(recyclerView);
        this.type = type;
        this.dataBeans = new ArrayList<>();
        for (OrderAll.DataBean bean : dataBeans) {
            if (type == ConstantUtil.ALL) {//全部
                this.dataBeans.add(bean);
            } else if (type == ConstantUtil.NON_PAYMENT) {//待支付
                if (type == bean.getPay_status()) {
                    this.dataBeans.add(bean);
                }
            } else if (type == ConstantUtil.PAYMENT_HAS_BEEN) {//已支付
                if (type == bean.getPay_status()) {
                    this.dataBeans.add(bean);
                }
            } else if (type == ConstantUtil.HAS_BEEN_COMPLETED) {//已完成
                if (type == bean.getPay_status()) {
                    this.dataBeans.add(bean);
                }
            }
        }
    }

    @NonNull
    @Override
    public ClickableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new ViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.fragment_itme_order, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder holde = (ViewHolder) holder;
            holde.time.setText("下单时间：" + dataBeans.get(position).getCreated_at());
            Glide.with(mContext).load(Concat.IMAGE_URL + "/" + dataBeans.get(position).getImage_url())
                    .into(holde.banner);
            switch (dataBeans.get(position).getPay_status()) {
                case ConstantUtil.NON_PAYMENT:
                    holde.state.setText("待支付");
                    break;
                case ConstantUtil.PAYMENT_HAS_BEEN:
                    holde.state.setText("已付款");
                    break;
                case ConstantUtil.HAS_BEEN_COMPLETED:
                    holde.state.setText("已完成");
                    break;
            }
            holde.name.setText(dataBeans.get(position).getName());
            holde.price.setText("单价：" + dataBeans.get(position).getPrice());
            holde.cotton_area.setText("X" + dataBeans.get(position).getCotton_area());
        }
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return dataBeans == null ? 0 : dataBeans.size();
    }

    public class ViewHolder extends ClickableViewHolder {

        private ImageView banner;
        private TextView time, state, name, price, cotton_area;

        public ViewHolder(View itemView) {
            super(itemView);
            banner = $(R.id.iv_);
            time = $(R.id.tv_year);
            state = $(R.id.tv_state);
            name = $(R.id.tv_ins_name);
            price = $(R.id.tv_price);
            cotton_area = $(R.id.tv_cotton_area);
        }
    }
}
