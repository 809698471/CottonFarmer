package com.lianghuawang.cottonfarmer.activity.my;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.ReceivingAddressAdapter;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

//收货地址
public class ReceivingAddressActivity extends BaseActivity implements View.OnClickListener {


    private ImageView receivingaddress_return;
    private RecyclerView receivingaddress_recy;
    private LinearLayout receivingaddress_xinzeng;
    List<Bean> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_receiving_address;
    }

    @Override
    protected void initView() {
        receivingaddress_return = (ImageView) findViewById(R.id.receivingaddress_return);
        receivingaddress_recy = (RecyclerView) findViewById(R.id.receivingaddress_recy);
        receivingaddress_xinzeng = (LinearLayout) findViewById(R.id.receivingaddress_xinzeng);
        receivingaddress_return.setOnClickListener(this);
        receivingaddress_xinzeng.setOnClickListener(this);
        receivingaddress_recy.setLayoutManager(new LinearLayoutManager(this));

        Bean bean = new Bean();
        bean.setName("具体地址：");
        list.add(bean);

        ReceivingAddressAdapter receivingAddressAdapter = new ReceivingAddressAdapter(list);
        receivingaddress_recy.setAdapter(receivingAddressAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.receivingaddress_return:
                finish();
                break;
            case R.id.receivingaddress_xinzeng:
                finish();
                break;
        }

    }
}
