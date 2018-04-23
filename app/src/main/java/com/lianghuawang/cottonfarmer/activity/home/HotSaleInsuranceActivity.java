package com.lianghuawang.cottonfarmer.activity.home;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.lianghuawang.cottonfarmer.Bean;
import com.lianghuawang.cottonfarmer.R;
import com.lianghuawang.cottonfarmer.adapter.HotSaleInsuranceAdapter;
import com.lianghuawang.cottonfarmer.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

//热销保险---专题名称
public class HotSaleInsuranceActivity extends BaseActivity {
   List<Bean> list = new ArrayList<>();
    private RecyclerView hotsaleinsurance_recy;
    private ImageView hotsaleinsurance_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_hot_sale_insurance;
    }

    @Override
    protected void initView() {
        hotsaleinsurance_return = (ImageView) findViewById(R.id.hotsaleinsurance_return);
        hotsaleinsurance_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        hotsaleinsurance_recy = (RecyclerView) findViewById(R.id.hotsaleinsurance_recy);
        hotsaleinsurance_recy.setLayoutManager(new LinearLayoutManager(HotSaleInsuranceActivity.this));
        for (int i = 0; i < 10; i++) {
            Bean bean = new Bean();
            bean.setName("棉花灾害险");
            list.add(bean);

        }
//        Bean bean = new Bean();
//        bean.setName("棉花灾害险");
//        list.add(bean);
        //设置Adapter
        HotSaleInsuranceAdapter adapter = new HotSaleInsuranceAdapter(this,list);
        hotsaleinsurance_recy.setAdapter(adapter);
    }
}
